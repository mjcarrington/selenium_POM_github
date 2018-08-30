package mjcarrington.GithubExample.Tests;

import mjcarrington.GithubExample.Pages.MainPage;
import mjcarrington.GithubExample.Pages.SalesTeamPage;
import mjcarrington.GithubExample.Utility.TestNGITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGITestListener.class)

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

    @Test(priority = 3)
    public void searchForRepository() {
        MainPage mainPage = new MainPage(driver);
        mainPage.testSearchForRepo("google/fruit");
    }

    @Test(priority = 4)
    public void contactSalesTeam() {
        SalesTeamPage salesTeamPage = new SalesTeamPage(driver);
        salesTeamPage.testSalesRequest();
    }
}
