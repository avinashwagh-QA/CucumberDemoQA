package stepDefinitions;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.SearchresultPage;

public class SearchProductSteps 
{
	
	HomePage hp;
	SearchresultPage srp;
	
	
	@Given("I navigate to the home page")
	public void i_navigate_to_the_home_page() 
	{
		hp = new HomePage(BaseClass.getDriver());
	    hp.lnkToHomePage();	
	}
	
	@When("I search for the product with name {string}")
	public void i_search_for_the_product_with_name(String string) 
	{
	    hp.searchProduct(string);
	}
	
	@When("Click on searh button")
	public void click_on_searh_button() 
	{
	    hp.clickOnSearch();
	}
	
	@Then("I should see the search result page")
	public void i_should_see_the_search_result_page() 
	{
		srp = new SearchresultPage(BaseClass.getDriver());
		Assert.assertTrue("Search results page is not displayed.", 	srp.isSearchPageExists());			
	}
	
	
	@Then("I should see the product {string} in the search result")
	public void i_should_see_the_product_in_the_search_result(String productName) 
	{
	    Assert.assertTrue("Product not found " + productName, srp.isProductExist(productName));
	}

	@Then("I should see a message {string}")
	public void i_should_see_a_message(String expectedMsg) 
	{
	   Assert.assertEquals(expectedMsg, srp.getNoProductMessage());
	}
	
	
}
