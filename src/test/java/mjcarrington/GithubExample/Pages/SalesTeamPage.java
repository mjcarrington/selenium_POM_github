package mjcarrington.GithubExample.Pages;

import mjcarrington.GithubExample.Tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class SalesTeamPage extends BasePage {

    public SalesTeamPage(RemoteWebDriver driver) { super(driver); }

    // Elements
    @FindBy(css = "button[class*='js-trial-submit']")
    private WebElement salesSubmitButton;

    @FindBy(css = "svg[class*='octicon']")
    private WebElement salesHeaderReturnButton;

    // Request Fields
    @FindBy(id = "cr_ua_name")
    private WebElement salesNameField;

    @FindBy(id = "cr_ua_oa_name")
    private WebElement salesOrgField;

    @FindBy(id = "cr_ua_email")
    private WebElement salesEmailField;

    @FindBy(id = "cr_ua_phone")
    private WebElement salesPhoneField;

    @FindBy(id = "cr_comments")
    private WebElement salesRequestField;

    // Tests
    public void testSalesRequest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToSales();
        assertSalesPage();
        enterSalesRequest();
        //submitSalesRequest(); // NOTE: Commenting this out so we do not spam the server :)
        // After this we would assert the page that we arrive on afterwards
    }

    public void testSalesNavigateBackToMain() {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToSales();
        assertSalesPage();
        clickHeaderIconToReturnToMain();
        mainPage.assertMainPage();
    }

    // Helpers
    private void enterSalesRequest() {
        // full name
        salesNameField.sendKeys("Tester McTest");
        // org
        salesOrgField.sendKeys("Happy Testing");
        // work email
        salesEmailField.sendKeys("null@dflasjdfalskjdfsdklfasjftest.org");
        // phone number
        salesPhoneField.sendKeys("1234567890");
        // request body
        salesRequestField.sendKeys("This is purely a test and we are not going to hit the submit button");
    }

    private void submitSalesRequest() {
        explicitWaitAndClick(salesSubmitButton, 2);
    }

    private void clickHeaderIconToReturnToMain() {
        explicitWaitAndClick(salesHeaderReturnButton,2 );
    }

    // Assert
    private void assertSalesPage() { assertElement(salesSubmitButton); }

}
