package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	//Elements 
	@FindBy(xpath = "//input[@id='input-email'] ")
	WebElement inputEmail;
	
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement inputPassword;
	
	@FindBy(xpath= "//input[@value='Login']" )
	WebElement btnLogin;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement lnkForgottPassword;
	
	// Method for each elements 
	public void setEmail(String email)
	{
		inputEmail.sendKeys(email);
	
	}
	
	public void setPassword(String pwd)
	{
		inputPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
	//Forgot password link method 
	
	public void clickForgotPassword()
	{
		lnkForgottPassword.click();
	}
	
}
