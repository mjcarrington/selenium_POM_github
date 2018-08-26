package mjcarrington.GithubExample.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {
    public RemoteWebDriver driver;

    // Constructor
    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Universal Methods
    // Takes an element and wait time
    public void explicitWait(WebElement waitElement, int waitTime) {
        new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(waitElement));
    }

    // Takes an element, a wait time, then clicks
    public void explicitWaitAndClick(WebElement waitElement, int waitTime) {
        new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(waitElement));
        waitElement.click();
    }
    // Wait for 3 seconds, assert element is displayed
    public void assertElement(WebElement waitElement) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(waitElement));
        Assert.assertTrue(waitElement.isDisplayed());
    }

    // Assert fuzzy text match
    public void assertFuzzyTextDisplayed(String searchQuery) {
        WebElement searchElement = driver.findElementByXPath("//*[contains(text(), '"+searchQuery+"')]");
        Assert.assertTrue(searchElement.isDisplayed(), "Text not displayed: " + searchQuery);
    }

    // Validate string match of current url against expected url
     public void validateCurrentUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.toLowerCase().contains(expectedUrl.toLowerCase()), "Expected: "
                + expectedUrl
                + ", Actual: "
                + currentUrl);
    }
}
