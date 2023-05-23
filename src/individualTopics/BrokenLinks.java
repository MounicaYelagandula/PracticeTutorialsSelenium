package individualTopics;

import java.io.IOException;
import org.testng.asserts.SoftAssert;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class BrokenLinks {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		
		/*How to identify broken links in Selenium WebDriver
		Collect all the links present on a web page based on the <a> tag.
		Send HTTP request for each link.
		Verify the HTTP response code.
		Determine if the link is valid or broken based on the HTTP response code.
		Repeat the process for all links captured with the first step.*/
		//Developer tools->network->XHR & ALL
		//java methods to get the URLs and call them and get their status codes
		// TODO Auto-generated method stub
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,1200)");
				
				//String url=driver.findElement(By.cssSelector("a[href*='restapi']")).getAttribute("href");
				//System.out.println(url);
				
				
				List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
				//SoftAssert soft=new SoftAssert();
				for(WebElement link: links)
				{
					String url=link.getAttribute("href");
					HttpURLConnection connection=(HttpURLConnection)new URL(url).openConnection();
					connection.setRequestMethod("HEAD");
					connection.connect();
					int responseCode=connection.getResponseCode();
					System.out.println(responseCode);
					//soft.assertTrue(true condition,"message");
					//soft.assertTrue(responseCode<400,"The link with text : "+link.getText()+" is broken with code "+responseCode);
				}
				
				//soft.assertAll();
				
//				if(responseCode>400)
//					Assert.assertTrue(false);
	}

}
