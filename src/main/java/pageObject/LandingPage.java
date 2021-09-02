package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	private By popupclose=By.className("sumome-react-svg-image-container");
	private By login=By.cssSelector("a[href*='sign_in']");
	private By texttitle=By.xpath("//section[@id='content']/div[1]/div[1]/h2");
	private By navelements=By.className(".nav.navbar-nav.navbar-right>li>a");
	private By productlist=By.cssSelector("ul[class *= 'course-list'] li");
	
	public LandingPage( WebDriver driver) {
		this.driver=driver;
		
	}
	
	public WebElement PopupClose() {
		return driver.findElement(popupclose);
	}	
	
	public LoginPage loginlink() {
		driver.findElement(login).click();
		LoginPage lp=new LoginPage(driver);
		return lp; 
	}
	public WebElement gettitletext() {
		return driver.findElement(texttitle);
	}
	public WebElement CheckElementofnav() {
		List<WebElement> nav=driver.findElements(By.xpath("//nav/ul"));
		WebElement driverelementofnav= nav.get(1);
		return driverelementofnav;
	}
	public List<WebElement> Checkproductlist() {
		return driver.findElements(productlist);
	}
	}
