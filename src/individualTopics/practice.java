package individualTopics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.openqa.selenium.By;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.testng.asserts.SoftAssert;
public class practice {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		//System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.32.2-win-aarch64\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://rahulshettyacademy.com/angularpractice/");
		WebElement protocommerce=driver.findElement(By.cssSelector("div.container a.navbar-brand"));
		String text=driver.findElement(with(By.linkText("Home")).toLeftOf(protocommerce)).getText();
		System.out.println(text);
		
		File pic=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pic, new File("D://pic.png"));
		
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert s=new SoftAssert();
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			HttpURLConnection connectionObject=(HttpURLConnection) new URL(url).openConnection();
			connectionObject.setRequestMethod("HEAD");
			connectionObject.connect();
			int rcode=connectionObject.getResponseCode();
			s.assertTrue(rcode<400, "link is broken :"+link.getText());
		}
		s.assertAll();
	}

}
