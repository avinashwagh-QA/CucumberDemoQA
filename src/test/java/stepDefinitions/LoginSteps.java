package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;

import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;


public class LoginSteps 
{
	  WebDriver driver;
	     HomePage hp;
	     LoginPage lp;
	     MyAccountPage macc;

	     java.util.List<HashMap<String, String>> datamap; //Data driven

	
	@Given("the user navigates to QAfox login page")
	public void the_user_navigates_to_q_afox_login_page() 
	{
	    BaseClass.getLogger().info("Home Page > Click on MyAccount > click on Login");
	    
	    hp = new HomePage(BaseClass.getDriver());
	    
	   hp.clickOnMyacc();
	   hp.clickOnLogin();
	    
	}
	
	@When("The user enter Email as {string} and Password as {string}")
	public void the_user_enters_email_as_and_password_as(String username, String password)
	{
	    
		BaseClass.getLogger().info("Enter Email and Password");
		
		lp =new  LoginPage(BaseClass.getDriver());
		
		lp.setEmail(username);
		lp.setPassword(password);
		
	}
	
	
	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button()
{
	  BaseClass.getLogger().info("Click on Log in Button");
	  
	  lp.clickLogin();
}

	@Then("the user should be redirected to the Myaccount page")
	public void the_user_should_be_redirected_to_the_myaccount_page() 
	{
	    BaseClass.getLogger().info("Validating MyAccount Page");
	    
	    MyAccountPage mc = new MyAccountPage (BaseClass.getDriver());
	    
	    boolean acc = mc.isMyAccountPageExists();
	    
	    Assert.assertEquals(acc, true);
		
	}
	
	
	// Data Driven 
	
	@Then("the user should be redirected to my Account page by passing email and password with excel row {string}")
	public void the_user_should_be_redirected_to_my_account_page_by_passing_email_and_password_with_excel_row(String rows) 
	{
		 datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx", "Sheet1");

	        int index=Integer.parseInt(rows)-1;
	        String email= datamap.get(index).get("username");
	        String pwd= datamap.get(index).get("password");
	        String exp_res= datamap.get(index).get("res");

	        lp=new LoginPage(BaseClass.getDriver());
	        lp.setEmail(email);
	        lp.setPassword(pwd);

	        lp.clickLogin();
	        macc=new MyAccountPage(BaseClass.getDriver());
	        try
	        {
	            boolean targetpage=macc.isMyAccountPageExists();
	            System.out.println("target page: "+ targetpage);
	            if(exp_res.equals("Valid"))
	            {
	                if(targetpage==true)
	                {
	                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
	                    myaccpage.clickLogout();
	                    Assert.assertTrue(true);
	                }
	                else
	                {
	                    Assert.assertTrue(false);
	                }
	            }

	            if(exp_res.equals("Invalid"))
	            {
	                if(targetpage==true)
	                {
	                    macc.clickLogout();
	                    Assert.assertTrue(false);
	                }
	                else
	                {
	                    Assert.assertTrue(true);
	                }
	            }


	        }
	        catch(Exception e)
	        {

	            Assert.assertTrue(false);
	        }
	      }
		
		
	

}

	


