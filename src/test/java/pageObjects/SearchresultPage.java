package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;

public class SearchresultPage extends BasePage

{

	public SearchresultPage(WebDriver driver)
	{
		super(driver);
        PageFactory.initElements(driver, this);
    }
	
    // WebElement for the search results page header
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement searchPageHeader;
	
	//WebElement for all product by search name 
	@FindBy(xpath= "//*[@id='content']/div[3]//img")
	List < WebElement> searchProducts;
	
	// if no search result is found 
	  @FindBy(xpath = "//p[contains(text(),'There is no product')]")
	    private WebElement noProductMessage;
	
	
	
	 /**
     * Verify if the search results page exists by checking the header text
     * 
     * @return true if the search results page exists, false otherwise
     */
	
	public boolean isSearchPageExists()
	{
		try
		{
			Thread.sleep(1000);
			WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement header = mywait.until(ExpectedConditions.visibilityOf(searchPageHeader));
			
			String actualText= header.getText();

			BaseClass.getLogger().info("Debug actual text of header ......"+actualText);
			return actualText.contains("Search - ");
		}
		catch (Exception e)
		{
            BaseClass.getLogger().info("Error in isSearchPageExists: " + e.getMessage());
			return false;
			
		}
	}
	
	
	 /**
     * Check if a product exists in the search results by its name
     * 
     * @param productName The name of the product to search for
     * @return true if the product exists, false otherwise
     */
	  
    public boolean isProductExist(String productName)
    {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

		mywait.until(ExpectedConditions.visibilityOfAllElements(searchProducts)); // Wait for product list to be visible

       
            for (WebElement product : searchProducts) 
            {
                if (product.getAttribute("title").equals(productName))
                {
                    return true;
                }
            }
			return false;
        } 
    
    public String getNoProductMessage() 
    {
        return noProductMessage.getText();
    }

    /**
     * Select a product from the search results by its name
     *
     * @param productName The name of the product to select
     * @return a ProductPage instance after selecting the product
     */

    public ProductPage selectProduct(String productName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfAllElements(searchProducts)); // Wait for product list to be visible

            for (WebElement product : searchProducts) {
                if (product.getAttribute("title").equals(productName)) {
                    wait.until(ExpectedConditions.elementToBeClickable(product));
                    product.click();
                    return new ProductPage(driver);
                }
            }
            System.out.println("Product not found " + productName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;

    }
}
