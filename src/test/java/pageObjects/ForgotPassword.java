package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword extends BasePage
{

	public ForgotPassword(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

    // Element for Email field 
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement inputEmail;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']" )
	WebElement sucessMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']" )
	WebElement alertMessage;
	
	// Method for email 
	public void setEmailfield(String email)
	{
		inputEmail.sendKeys(email);
		
	}
	
	// method for continue button
	public void clickContinueButton ()
	{
		btnContinue.click();
	}
	
	// method for success message
	
	public String getSucessMsg()
	{
		try {
				 return sucessMessage.getText();
		} catch (Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String getAlertMsg()
	{
		try {
				 return alertMessage.getText();
		} catch (Exception e)
		{
			return (e.getMessage());
		}
	}
	
}
