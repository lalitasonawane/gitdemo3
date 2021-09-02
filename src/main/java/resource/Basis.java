package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basis {
	public WebDriver driver;
	public Properties prop;

	public WebDriver InitialDriver() throws IOException {

		prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);
		//mvn test -Dbrowser=chrome
		//String browserName=System.getProperty("browser");
		String browserName = prop.getProperty("Browser");
		System.out.println(browserName);

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
			/*
			 * ChromeOptions option=new ChromeOptions();
			 * if(browserName.contains("headless")) option.addArguments("Headless"); driver
			 * = new ChromeDriver(option);
			 */
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			/*
			 * opt.setCapability("Platform", org.openqa.selenium.Platform.ANY); driver = new
			 * FirefoxDriver(opt);
			 */
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String screenshot(String filename, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"\\reports\\"+filename+".png";
		FileUtils.copyFile(src,new File(destfile));	
		return destfile;
		}
	
}
