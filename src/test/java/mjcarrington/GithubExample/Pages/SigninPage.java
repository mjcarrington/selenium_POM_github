package mjcarrington.GithubExample.Pages;

import mjcarrington.GithubExample.Tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends BasePage {

    public SigninPage(RemoteWebDriver driver) { super(driver); }

    // Elements
    @FindBy(xpath = "//input[@type='submit' and @value='Sign in']")
    private WebElement signinSubmitButton;

    @FindBy(css = "[class*='HeaderNavlink'][data-ga-click*='icon:avatar']")
    private WebElement signinAvatarHeader;

    @FindBy(id = "login_field")
    private WebElement signinUsernameEmailField;

    @FindBy(id = "password")
    private WebElement signinPasswordField;

    // Tests
    public void testSigninViewPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testNavLogin();
        assertSigninPage();
    }

    public void testSigninToSite() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testNavLogin();
        assertSigninPage();
        enterCredsAndSubmit();
    }

    // Helpers
    private void enterCredsAndSubmit() {
        signinUsernameEmailField.sendKeys(TestBase.username);
        signinPasswordField.sendKeys(TestBase.password);
        signinSubmitButton.click();
        assertSuccessfulLogin();
    }

    // Assert
    private void assertSigninPage() { assertElement(signinSubmitButton); }

    private void assertSuccessfulLogin() { assertElement(signinAvatarHeader); }

}
