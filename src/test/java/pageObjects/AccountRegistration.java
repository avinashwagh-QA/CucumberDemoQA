package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage
{

	public AccountRegistration(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Elements 
	
	@FindBy(xpath= "//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath= "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath= "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath= "//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath= "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath= "//input[@id='input-confirm']")
	WebElement txtConfrimPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	@FindBy(xpath="//div[@class='text-danger']")
	List < WebElement> errorMessages;
	
	//Action method for each elements 
	public void setFristName(String fname)
	{
		txtFirstName.sendKeys(fname);;
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone (String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	

	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmpwd(String password)
	{
		txtConfrimPassword.sendKeys(password);
	}
	
	public void setPolicy()
	{
		chkPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	
	public String getConfirmationMsg()
	{
		try {
		return msgConfirmation.getText();
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}
	
	// Creating a method for 
	
	public List<String> getAllErrorMessage ()
	{
		List <String> messages = new ArrayList <>();
		
		for (WebElement errorMessage : errorMessages)
		{
			if (errorMessage.isDisplayed())
			{
				messages.add(errorMessage.getText().trim());
			}
		}
		
		return messages;
	}
	
	
	
	
	
	
}
