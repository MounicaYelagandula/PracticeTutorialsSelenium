package rahulshettyacademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//ChromeOptions options = new ChromeOptions(); options.addArguments("--remote-allow-origins=*");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Select select=new Select(driver.findElement(By.xpath("//select[contains(@id,'Currency')]")));	//css : select[id*='Curr']
		select.selectByIndex(1);
		System.out.println(select.getFirstSelectedOption().getText());
		select.selectByValue("AED");
		System.out.println(select.getFirstSelectedOption().getText());
		select.selectByVisibleText("USD");
		System.out.println(select.getFirstSelectedOption().getText());
		System.out.println(select.getAllSelectedOptions().size());
	}

}
