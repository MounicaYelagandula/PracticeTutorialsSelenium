package rahulshettyacademy;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartInMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String input[]= {"brocolli","beetroot"};
		addItemsToCart(driver, input);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click()	;
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//wait is required here
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'promo')]")));
		driver.findElement(By.xpath("//input[contains(@placeholder,'promo')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class*='promo']")).click();

		
	}
	public static void addItemsToCart(WebDriver driver,String input[])
	{
		int count=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
		{
			List<String> inputList=    Arrays.asList(input);
			String currentProductName=products.get(i).getText().split(" ")[0].trim().toLowerCase();
			if(inputList.contains(currentProductName))
			{  
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				count++;
				
	
			}
			if(count==input.length)
				break;
		}
	}

}
