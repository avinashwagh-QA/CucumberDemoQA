package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.ProductPage;
import pageObjects.SearchresultPage;

public class AddtoCartSteps
{
   private ProductPage productPage;

    @When("I select the product {string} from the search result")
    public void i_select_the_product_from_the_search_result(String productName)
    {
        SearchresultPage srp = new SearchresultPage(BaseClass.getDriver());
        BaseClass.getLogger().info("Selecting Product from Search result cart page");
        BaseClass.getLogger().info("Selecting Product from Search result cart page");

        productPage =  srp.selectProduct(productName);

    }
    @When("I set the quantity as to {string}")
    public void i_set_the_quantity_as_to(String qnt) {
      productPage.setProductQuantity(qnt);
      BaseClass.getLogger().info("Set quantity to {}", qnt);

    }
    @When("Add the product to cart")
    public void add_the_product_to_cart() {
        productPage.addToCart();
        BaseClass.getLogger().info("Product added to cart");
    }
    @Then("I should see the success message confirming the product was add to cart")
    public void i_sholud_see_the_sucess_message_confirming_the_product_was_add_to_cart() {
        Assert.assertTrue("Success message not displayed", productPage.getCnfMsg());
        BaseClass.getLogger().info("Success message verified and Product added to cart.....");
    }


}
