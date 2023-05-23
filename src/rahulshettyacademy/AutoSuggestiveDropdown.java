package rahulshettyacademy;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutoSuggestiveDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("input.inputs")).sendKeys("can");
		List<WebElement> autoOptions=driver.findElements(By.cssSelector("li.ui-menu-item a"));
//		for(WebElement option:autoOptions)
//		{
//			if(option.getText().equalsIgnoreCase("canada"))
//			{
//				option.click();
//				break;
//			}
//		}
		WebElement option=autoOptions.stream().filter(op->op.getText().equalsIgnoreCase("canada")).findAny().orElse(null);
		option.click();
		//number of checkboxes
//		System.out.println(driver.findElements(By.cssSelector("#discount-checkbox input[type='checkbox']")).size());
//		
//		//return date enabled or disabled
//		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
//			System.out.println("disabled");
//		else
//			System.out.println("enabled");
//		
		
		
	}

}
