package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;


public class FluentWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.id("start")).click();
//		Wait<WebDriver> fw= new FluentWait(driver).withTimeout().pollingEvery().ignoring(NoSuchElementExeption.class);
//		
//		WebElement foo = fw.until(new Function<WebDriver, WebElement>() {
//		     public WebElement apply(WebDriver driver) {
//		    	 if(driver.findElement(By.id("finish")).isDisplayed())
//		       return driver.findElement(By.id("finish"));
//		    	 else
//		    		 return null;
//		     }
//		   });
		
		System.out.println(driver.findElement(By.id("finish")).isDisplayed());
		
		

		
	}

}
