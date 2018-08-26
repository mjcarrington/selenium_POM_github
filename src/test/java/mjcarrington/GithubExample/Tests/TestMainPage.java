package mjcarrington.GithubExample.Tests;

import mjcarrington.GithubExample.Pages.MainPage;
import org.testng.annotations.Test;

public class TestMainPage extends TestBase{

    @Test(priority = 1)
    public void navigateFeaturesTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testNavFeatures();
    }

    @Test(priority = 2)
    public void navigateLogin() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testNavLogin();
    }
}
