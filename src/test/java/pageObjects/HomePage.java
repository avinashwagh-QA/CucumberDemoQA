package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage 
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Elements
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegistration;
	
	
	// Action Method
	public void clickOnMyacc()
	{
		lnkMyAccount.click();
	}
	
	public void clickOnLogin()
	{
		lnkLogin.click();
	}
			
	
	public void clickOnRegistration()
	{
		lnkRegistration.click();
	}
	

}
