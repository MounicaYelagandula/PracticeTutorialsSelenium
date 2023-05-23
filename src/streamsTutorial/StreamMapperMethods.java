package streamsTutorial;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamMapperMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> elements=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//List<String> vegetableList=elements.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> priceList=elements.stream().filter(s->s.getText().contains("Potato")).map(s->getPriceofVegetable(s)).collect(Collectors.toList());
	System.out.println(priceList.get(0));
	priceList.forEach(p->System.out.println(p));
	
	
	}

	private static String getPriceofVegetable(WebElement s) {
		// TODO Auto-generated method stub
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
