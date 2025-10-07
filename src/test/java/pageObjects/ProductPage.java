package pageObjects;

import factory.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage
{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    /* Element for add to cart */
    @FindBy(xpath="//button[@id='button-cart']")
    WebElement btnCart;

    /* Element for set quantity */
    @FindBy(xpath = "//input[@id='input-quantity']")
     WebElement inputQuantity;

    /* Element for set confirmation message  */
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement cnfMsg;

    /* Element for view add to cart item */
    @FindBy(xpath = "//div[@id='cart']")
    WebElement btnViewCart;

    public void setProductQuantity(String qnt) {
        waitHelper.waitForElementToVisible(inputQuantity);
        inputQuantity.clear();
        inputQuantity.sendKeys(qnt);

    }

    public void addToCart() {
       waitHelper.waitForElementToClickable(btnCart);
        btnCart.click();
    }

    public boolean getCnfMsg() {
        if (cnfMsg != null) {
            waitHelper.waitForElementToVisible(cnfMsg);
            return cnfMsg.isDisplayed();
        } else {
            BaseClass.getLogger().info("Confirmation Message not found");
            return false;
        }

    }
}


