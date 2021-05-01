package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;

	private By emailid = By.id("user_email");
	private By password= By.id("user_password");
	private By submit=By.name("commit");
	private By forgetpasswordlink=By.cssSelector("[href *='password/new']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement Loginemailid() {
		return driver.findElement(emailid);
	}
	public WebElement loginpassword() {
		return driver.findElement(password);
	}
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	
}
