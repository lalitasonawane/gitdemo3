package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import cucumber.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import pageObject.LoginPage;




public class stepDefination extends Base{
	@Given("^driver initialize$")
	public void driver_initialize() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Initialzie the driver");
		driver=initailizedriver();
	   
	}

	@Given("^User is on landing page using link \"([^\"]*)\"$")
	public void user_is_on_landing_page_using_link(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	   
	}

	@When("^click on login link$")
	public void click_on_login_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage lp = new LandingPage(driver);
		Actions a = new Actions(driver);
		// a.moveToElement(lp.PopupClose()).click().build().perform();
		int element = driver.findElements(By.className("sumome-react-svg-image-container")).size();
		if(element>0)
			a.moveToElement(lp.PopupClose()).click().build().perform();
		lp.loginlink();
	   
	}
	   @Then("^enter \"([^\"]*)\" and \"([^\"]*)\" and click on submit$")
	    public void enter_something_and_something_and_click_on_submit(String strArg1, String strArg2) throws Throwable {
		   LoginPage login=new LoginPage(driver);		
			login.Loginemailid().sendKeys(strArg1);
			login.loginpassword().sendKeys(strArg2);
			login.submit();
	    }


	@Then("^close browser$")
	public void close_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("closing the browser");
	   driver.close();
	}


}
