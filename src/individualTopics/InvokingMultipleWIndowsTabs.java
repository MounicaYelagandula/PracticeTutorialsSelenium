package individualTopics;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWIndowsTabs {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rahulshettyacademy.com/angularpractice/");
		
		//invoking multiple tabs & windows from one driver instance is possible from selenium 4
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> itr=windowIds.iterator();
		String first=itr.next();
		String second=itr.next();
		//driver.switchTo().window(second); don't need to switch again
		driver.get("https://rahulshettyacademy.com/");
		//String courseName=driver.findElement(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']:nth-child(1)")).getText();
		//The above css is getting 24 elements not 1 so use findElements and get(1) to get the first element.
		String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(first);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		
		//taking screenshot of element : partial screenshot
		WebElement name=driver.findElement(By.cssSelector("[name='name']"));
		File sc=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sc, new File("C:/Users/mouni/OneDrive/Desktop/Selenium/sc.png"));
		
		File wsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(wsc, new File("C:/Users/mouni/OneDrive/Desktop/Selenium/wsc.png"));
		
		//Get height and width of name webelement
		System.out.println(name.getRect().getDimension());
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getWidth());
		
	}

}
