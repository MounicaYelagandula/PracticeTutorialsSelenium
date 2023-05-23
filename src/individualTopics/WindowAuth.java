package individualTopics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAuth {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
//		driver.get("http://admin:admin@the-internet.herokuapp.com/");
//		driver.findElement(By.linkText("Basic Auth")).click();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.findElement(By.id("file-upload")).click();
		//call exe file
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D://firstpdf.exe");
		
		
	}

}
