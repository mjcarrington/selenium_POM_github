package mjcarrington.GithubExample.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(RemoteWebDriver driver) { super(driver); }

    // Elements
    @FindBy(xpath = "//input[@type='submit' and @value='Sign in']")
    private WebElement loginSignInButton;

    // Tests
    public void loginViewPage() {
        MainPage mainPage = new MainPage(driver);
        //mainPage.navigateToSignIn();
        assertLoginPage();
    }

    // Assert
    private void assertLoginPage() { assertElement(loginSignInButton); }

}
