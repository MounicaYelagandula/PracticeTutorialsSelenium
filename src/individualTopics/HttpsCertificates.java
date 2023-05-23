package individualTopics;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class HttpsCertificates {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//deleting cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("asdf");
		
		driver.get("https://expired.badssl.com/");
		
		ChromeOptions co=new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		
		//setting proxy to  access any website
		Proxy p=new Proxy();
		p.setHttpProxy("ipaddress:portnumber");
		co.setCapability("proxy", p);

		//changing any file download path
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		co.setExperimentalOption("prefs", prefs);
		
		//taking screenshot
		File pic=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pic, new File("C://windowScreenshot.png")); //system may not allow to access C drive
		//C:Users/Mounica folder is allowed to access
		
		
		
	}

}
