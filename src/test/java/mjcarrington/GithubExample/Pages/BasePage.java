package mjcarrington.GithubExample.Pages;

import org.openqa.selenium.WebDriver;
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

    public void assertElement(WebElement waitElement) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(waitElement));
        Assert.assertTrue(waitElement.isDisplayed());
    }
}
