package MainProject.E2EProject;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import pageObject.LandingPage;
import resource.Basis;


public class ValidateTitleText extends Basis {
	//private static Logger log= LogManager.getLogger(ValidateTitleText.class.getName());
	WebDriver driver;
	private static Logger log = LogManager.getLogger(ValidateTitleText.class);
	LandingPage lp;
	
	@BeforeTest
	public void firsttest() throws IOException {
		driver=InitialDriver();		
		log.info("Initialize driver");
		driver.get(prop.getProperty("url")); //using data.properties file declared in basis class
		log.info("open website homepage link");
	}
	
	
	@AfterTest
	public void closebrowser() {
		driver.close();
	//	log.info("close the browser");
	}
	
	@Test
	public void validateTilteText() {
			lp=new LandingPage(driver);
			Actions a=new Actions(driver);
			a.moveToElement(lp.PopupClose()).click().build().perform();
			log.info("homepage popup close");
			Assert.assertEquals(lp.gettitletext().getText(), "featured cources12");
			log.info("Title text are correct");
			Assert.assertTrue(lp.CheckElementofnav().isDisplayed());
			log.info("nav element are displaying");
			
			}
	
	@Test
	public void productlist() {
		lp=new LandingPage(driver);
		int list= lp.Checkproductlist().size();
		System.out.println(list);
		Assert.assertEquals(10, list);
		
	}
		
}
