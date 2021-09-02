package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPassword {
	
	public WebDriver driver;

	private By emailid = By.id("user_email");
	private By submit=By.name("commit");
	private By forgetpasswordlink=By.cssSelector("[href *='password/new']");
	
	public forgotPassword(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement forgotmailid() {
		return driver.findElement(emailid);
	}
	public WebElement forgotsubmit() {
		return driver.findElement(submit);
	}
	
}
