package mjcarrington.GithubExample.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(RemoteWebDriver driver) { super(driver); }

    // Elements - Menu Bar
    @FindBy(css = "div[class*='HeaderMenu']")
    private WebElement mainHeaderContainer;

    @FindBy(linkText = "Features")
    private WebElement mainHeaderFeatures;

    @FindBy(linkText = "Business")
    private WebElement mainHeaderBusiness;

    @FindBy(linkText = "Features")
    private WebElement mainHeaderExplore;

    @FindBy(linkText = "Sign in")
    private WebElement mainHeaderSignIn;

    @FindBy(xpath = "//form[@class='js-site-search-form']/descendant::input[@type='text']")
    private WebElement mainSearchField;

    // Elements - Search Page
    @FindBy(css = "summary[class*='select-menu-button']")
    private WebElement MainSearchSortContainer;

    // Tests
    public void testNavFeatures() {
        navigateTopBar(mainHeaderFeatures, "features");
    }

    public void testNavLogin() {
        navigateTopBar(mainHeaderSignIn, "login");
    }

    public void testSearchForRepo(String searchQuery) {
        searchRepos(searchQuery);
    }

    // Helper
    private void navigateTopBar(WebElement navSelection, String expectedUrl) {
        assertMainPage();
        explicitWaitAndClick(navSelection, 3);
        validateCurrentUrl(expectedUrl);
    }

    private void searchRepos(String searchQuery) {
        assertMainPage();
        explicitWait(mainSearchField, 3);
        mainSearchField.sendKeys(searchQuery);
        mainSearchField.sendKeys(Keys.RETURN);
        explicitWait(MainSearchSortContainer, 3);
        assertFuzzyTextDisplayed("repository results");
    }

    // Asserts
    private void assertMainPage() { assertElement(mainHeaderContainer); }
}
