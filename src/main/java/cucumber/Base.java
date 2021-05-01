package cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Base {
	public WebDriver driver;
	
	
	public WebDriver initailizedriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lalita\\Downloads\\selenium\\chromedriver\\new version\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		/* driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */
		return driver;
	}
	

}
