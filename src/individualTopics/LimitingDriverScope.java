package individualTopics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingDriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//scrolling
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,900)");
		js.executeScript("window.scroll(0,document.body.scrollHeight)");
		
		//scrolling table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		System.out.println("The total number of links are : "+driver.findElements(By.tagName("a")).size());
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		System.out.println("The number of links in footer are : "+footer.findElements(By.tagName("a")).size());
		
		
		WebElement columndriver=footer.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			String clickOnEachLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnEachLink);
		}
		//opened all the links
		
//		int size=footer.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul/li/a")).size();
//		for(int i=1;i<size;i++)
//		{
//			String clickOnEachLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
//			footer.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul/li/a")).get(i).sendKeys(clickOnEachLink);
//		}
//		
		
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> itr=windowIds.iterator();
		while(itr.hasNext())
		{
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
	}

}
