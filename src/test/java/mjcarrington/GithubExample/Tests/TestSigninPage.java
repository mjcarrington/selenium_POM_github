package mjcarrington.GithubExample.Tests;

import mjcarrington.GithubExample.Pages.SigninPage;
import org.testng.annotations.Test;

public class TestSigninPage extends TestBase{

    @Test(priority = 1)
    public void viewLoginPage() {
        SigninPage signinPage = new SigninPage(driver);
        signinPage.testSigninViewPage();
    }

    @Test(priority = 1)
    public void loginValidUser() {
        SigninPage signinPage = new SigninPage(driver);
        signinPage.testSigninToSite();
    }
}
