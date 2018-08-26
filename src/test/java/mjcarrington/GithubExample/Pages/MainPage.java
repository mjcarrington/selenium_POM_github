package mjcarrington.GithubExample.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(RemoteWebDriver driver) { super(driver); }

    // Elements
    @FindBy(css = "div[class*='HeaderMenu']")
    private WebElement mainHeaderContainer;

    @FindBy(linkText = "Features")
    private WebElement mainHeaderFeatures;

    @FindBy(linkText = "Business")
    private WebElement mainHeaderBusiness;

    @FindBy(linkText = "Features")
    private WebElement mainHeaderExplore;

    // Tests
    public void testNavFeatures() {
        navigateTopBar(mainHeaderFeatures);
    }

    // Helper
    private void navigateTopBar(WebElement navSelection) {
        assertMainPage();
        explicitWait(navSelection, 3);
        navSelection.click();
    }

    // Asserts
    private void assertMainPage() { assertElement(mainHeaderContainer); }
}
