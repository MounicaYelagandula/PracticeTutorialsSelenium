package individualTopics;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		String downloadpath=System.getProperty("user.dir")+"/downloads";
		Map<String, Object> preferences = new HashMap<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.default_directory",downloadpath );
		
		ChromeOptions co=new ChromeOptions();
		co.setExperimentalOption("prefs",preferences );
		WebDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		//download a file and see if file is downloaded successfully
		
		driver.get("https://smallpdf.com/blog/sample-pdf");
		driver.findElement(By.cssSelector("span[class*='iiSRjo']")).click();
		//write steps to click download option
		//verify that file is present in Downloads folder
		Thread.sleep(5000);
		File f=new File(downloadpath+"/newfile.pdf");
		if(f.exists())
		{
			System.out.println("file downloaded successfully");
			f.delete();
		}
		
		
		
		
	}

}
