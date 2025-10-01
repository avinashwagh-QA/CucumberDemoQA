package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.ForgotPassword;
import pageObjects.LoginPage;

public class ForgotPasswordSteps 
{
	WebDriver driver =BaseClass.getDriver() ;
	ForgotPassword fgpwd;
	LoginPage lgp;
	
	
	public ForgotPasswordSteps ()
	{
	     fgpwd = new ForgotPassword (driver);
		 lgp = new LoginPage(driver);
	}
	
	@When("The user clicks on Forgot password link")
	public void the_user_clicks_on_forgot_password_link() 
	{
	    BaseClass.getLogger().info("Clicking on Register email link .....................");    
	    lgp.clickForgotPassword();
	}
	
	@When("The user enter register email {string}")
	public void the_user_enter_register_email(String email) 
	{
	    BaseClass.getLogger().info("The user entering register email in the input");
	        
	     fgpwd = new ForgotPassword (BaseClass.getDriver());
	     
	     fgpwd.setEmailfield(email);
	}

	@When("The user submit the request")
	public void the_user_submit_the_request() 
	{
	    BaseClass.getLogger().info("***** Clicking on Continue Button ***********");
    
	    fgpwd.clickContinueButton();
		
	}

	@Then("Success message {string} should be displayed")
	public void confirmation_message_should_be_displayed(String actualSuccessMsg)
	{
	    BaseClass.getLogger().info(" Validating Alert messgae ...............");
	    
	     actualSuccessMsg = fgpwd.getSucessMsg();

	     Assert.assertEquals(actualSuccessMsg, "An email with a confirmation link has been sent your email address.");
	}

	@Then("Alert message {string} should be displayed")
	public void alert_message_should_be_displayed(String alertMsg)
	{
		
	    BaseClass.getLogger().info(" Validating Alert  messgae ...............");

		alertMsg = fgpwd.getAlertMsg();
		
	     Assert.assertEquals(alertMsg, "Warning: The E-Mail Address was not found in our records, please try again!");
		
	}
}
