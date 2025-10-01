package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;

public class RegistrationSteps 
{
	     WebDriver driver;
	     HomePage hp;
	     AccountRegistration regpage;
	

	     @Given("The user navigates to registration page")
	     public void the_user_navigates_to_registration_page() 
	     {
	    	 BaseClass.getLogger().info("User navigatting to registration page .....");
	    	 
	    	   hp = new HomePage(BaseClass.getDriver());
	   	    
	    	   hp.clickOnMyacc();
	    	   hp.clickOnRegistration();
	    	 
	     }
	     
	     @When("User enters the details into below fields")
	     public void user_enters_the_details_into_below_fields(DataTable dataTable) 
	     {
	    	 Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	    	 
	    	 BaseClass.getLogger().info("User Entering the Registration Details .....");

	 		regpage=new AccountRegistration(BaseClass.getDriver());
	 		regpage.setFristName(dataMap.get("firstName"));
	 		regpage.setLastName(dataMap.get("lastName"));
	 		regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
	 		regpage.setTelephone(dataMap.get("telephone"));
	 		regpage.setPassword(dataMap.get("password"));
	 		regpage.setConfirmpwd(dataMap.get("password"));
	 		
	    	
	     }
	     
	     
	     @When("The user select privacy policy")
	     public void the_user_select_privacy_policy() 
	     {
	    	 BaseClass.getLogger().info("Marking Privacy Policy .....");

	    	 regpage.setPolicy();
		    	
	     }
	     
	     @When("The user clicks on the Continue button")
	     public void the_user_clicks_on_the_continue_button() 
	     {
	    	 BaseClass.getLogger().info("User click on continue button.....");

	    	 regpage.clickContinue();
	    	 
	     }
	     
		@Then("The user account should get created Successfully")
	     public void the_user_account_should_get_created_successfully()
	     {
	    	 String confMsg = regpage.getConfirmationMsg();
	    	 Assert.assertEquals(confMsg, "Your Account Has Been Created!");
	     }


		@When("no details are entered and the Continue button is clicked")
		public void no_details_are_entered_and_the_continue_button_is_clicked() 
		{
	 		regpage=new AccountRegistration(BaseClass.getDriver());

		   BaseClass.getLogger().info("Click on continue button without entring the any input fields");

		   regpage.clickContinue();

		}
		
		@Then("error message {string} should be displayed")
		public void error_message_should_be_displayed(String expectedMessage) 
		{
		    
			List<String> actualMessages = regpage.getAllErrorMessage();
		    Assert.assertTrue("Expected error message not found: " + expectedMessage, actualMessages.contains(expectedMessage));

			
		}
		
		
}
