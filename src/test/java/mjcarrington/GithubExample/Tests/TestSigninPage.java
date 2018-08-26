package mjcarrington.GithubExample.Tests;

import mjcarrington.GithubExample.Pages.SigninPage;
import mjcarrington.GithubExample.Utility.TestNGITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGITestListener.class)

public class TestSigninPage extends TestBase{

    @Test(priority = 1)
    public void viewLoginPage() {
        SigninPage signinPage = new SigninPage(driver);
        signinPage.testSigninViewPage();
    }

    @Test(priority = 2)
    public void loginValidUser() {
        SigninPage signinPage = new SigninPage(driver);
        signinPage.testSigninToSite();
    }
}
