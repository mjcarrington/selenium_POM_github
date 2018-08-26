package mjcarrington.GithubExample.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import javax.xml.bind.annotation.XmlAnyAttribute;

public class MainPage extends BasePage {

    public MainPage(RemoteWebDriver driver) { super(driver); }

    // Elements
    @FindBy(css = "div[class*='HeaderMenu']") // TODO: Make this more unique
    private WebElement mainHeaderContainer;

    @FindBy(linkText = "Features")
    private WebElement mainHeaderFeatures;

    @FindBy(linkText = "Business")
    private WebElement mainHeaderBusiness;

    @FindBy(linkText = "Features")
    private WebElement mainHeaderExplore;

    @FindBy(linkText = "Sign in")
    private WebElement mainHeaderSignIn;

    @FindBy(css = "form[class='js-site-search-form']")
    private WebElement mainSearchField;

    // Tests
    public void testNavFeatures() {
        navigateTopBar(mainHeaderFeatures, "features");
    }

    public void testNavLogin() {
        navigateTopBar(mainHeaderSignIn, "login");
    }

    // Helper
    private void navigateTopBar(WebElement navSelection, String expectedUrl) {
        assertMainPage();
        explicitWait(navSelection, 3);
        navSelection.click();
        validateCurrentUrl(expectedUrl);
    }

    private void searchRepos(String searchQuery) {
        assertMainPage();


    }

    // Asserts
    private void assertMainPage() { assertElement(mainHeaderContainer); }
}
