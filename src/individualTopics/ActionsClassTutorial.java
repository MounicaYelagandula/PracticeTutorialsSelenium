package individualTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassTutorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
		ac.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("umbrella").doubleClick().build().perform();
		
		//build() will generate a composite action containing all the actions requested so far
		
		Actions builder=new Actions(driver);
		Action aciob=builder.moveToElement(null).click().build();
		aciob.perform();
		
	}

}
