package utilities;

import factory.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    private WebDriver driver;
    private static final int default_Timeout=15;

    /* Constructor to webdriver initialize */
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    /* wait until the element visible */
    public WebElement waitForElementToVisible (WebElement element)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(default_Timeout));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            BaseClass.getLogger().info("Timeout waiting for element :" + element);
            return null;
        }
    }

    /* Wait unti the element is clickable */
    public WebElement waitForElementToClickable (WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(default_Timeout));
        return  wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /* wait until the title contains the text */
    public boolean waitForTitleContains (String titlePart){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(default_Timeout));
        return wait.until(ExpectedConditions.titleContains(titlePart));
    }









}
