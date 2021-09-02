package MainProject.E2EProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.forgotPassword;
import resource.Basis;

public class HomepageBasic extends Basis {

	// private static Logger log=
	// LogManager.getLogger(HomepageBasic.class.getName());
	private static Logger log = LogManager.getLogger(HomepageBasic.class);
	LandingPage lp;
	@BeforeTest
	public void firsttest() throws IOException {
		driver = InitialDriver();
		log.info("Initialize the driver");
	}

	@AfterClass
	public void closebrowser() {
		driver.close();
	}

	@Test(dataProvider = "getdataoflogin")
	public void initializeurl(String emailid, String password) throws IOException {
		driver.get(prop.getProperty("url")); // using data.properties file declared in basis class
		lp = new LandingPage(driver);
		Actions a = new Actions(driver);
		// a.moveToElement(lp.PopupClose()).click().build().perform();
		int element = driver.findElements(By.className("sumome-react-svg-image-container")).size();
		log.info("elemenyt number"+element);
		for(int i=0;i<element;i++) {
		if (element == 0) {
			continue;
		}
		else {
			a.moveToElement(lp.PopupClose()).click().build().perform();
			
			log.info("Clicked on ligin page");
		}
		}
		LoginPage login=lp.loginlink();
		 login.Loginemailid().sendKeys(emailid);
		login.loginpassword().sendKeys(password);
		login.submit().click();
		log.info("Perform the login operation");
		forgotPassword forgot= login.forgetPassword();
		forgot.forgotmailid().sendKeys(emailid);
		forgot.forgotsubmit();
		log.info("forgotpassword opertion performed");

	}

	/*
	 * 0 1 0 lltonawane@gmail.com Lalita@123 1 nikhil14@gmail.com 12345 2
	 * abc@gmail.com 24334
	 */
	@DataProvider
	public Object[][] getdataoflogin() {
		Object[][] data = new Object[3][2];
		data[0][0] = "lltonawane@gmail.com";
		data[0][1] = "Lalita@123";
		data[1][0] = "nikhil14@gmail.com";
		data[1][1] = "12345";
		data[2][0] = "abc@gmail.com";
		data[2][1] = "24334";

		return data;
	}
	
	
	}
