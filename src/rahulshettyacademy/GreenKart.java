package rahulshettyacademy;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String input[]= {"brocolli","beetroot"};
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
