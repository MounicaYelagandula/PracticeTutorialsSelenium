package individualTopics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,800)");
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='travel_comp_date']")));
		
		driver.findElement(By.cssSelector("input[id*='travel_comp_date']")).click();
		String givenMonth="November";
		while(!driver.findElement(By.cssSelector(".flatpickr-month")).getText().contains(givenMonth))
		{
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
		}
		
		
		
		
		String givenDate="13";
		
		List<WebElement> allDays=driver.findElements(By.cssSelector(".flatpickr-day "));
		for(int i=0;i<allDays.size();i++)
		{
			if(allDays.get(i).getText().equals(givenDate))
			{
				allDays.get(i).click();
				break;
			}
		}
	}

}
