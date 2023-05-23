package streamsTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://rahulshettyacademy.com/angularpractice/");
				
				WebElement protocommerce=driver.findElement(By.cssSelector("div.container a.navbar-brand"));
				String text=driver.findElement(with(By.linkText("Home")).toRightOf(protocommerce)).getText();
				System.out.println(text);
				WebElement nameField=driver.findElement(By.name("name"));
				//Relative locators have a package
				System.out.println(driver.findElement(with(By.tagName("label")).above(nameField)).getText());
				WebElement dobLabel=driver.findElement(By.cssSelector("label[for='dateofBirth']"));
				driver.findElement(with(By.tagName("input")).below(dobLabel)).sendKeys("1995-11-18");
				//dob filed is flex element so relative locators will not work on it. so it will
				// go to the next input field and try to perform the operation.
				
				//toRightOf
				WebElement radiobuttonemployed=driver.findElement(By.cssSelector("#inlineRadio2"));
				System.out.println(driver.findElement(with(By.cssSelector("label[for='inlineRadio2']")).near(radiobuttonemployed)).getText());
				
				//toLeftOf
				
				//near
				
				
	}

}
