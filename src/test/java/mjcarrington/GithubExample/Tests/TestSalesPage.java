package mjcarrington.GithubExample.Tests;

import mjcarrington.GithubExample.Pages.MainPage;
import mjcarrington.GithubExample.Pages.SalesTeamPage;
import mjcarrington.GithubExample.Utility.TestNGITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGITestListener.class)

public class TestSalesPage extends TestBase{

    @Test(priority = 1)
    public void contactSalesTeam() {
        SalesTeamPage salesTeamPage = new SalesTeamPage(driver);
        salesTeamPage.testSalesRequest();
    }

    @Test(priority = 2)
    public void navigateBackFromSales() {
        SalesTeamPage salesTeamPage = new SalesTeamPage(driver);
        salesTeamPage.testSalesNavigateBackToMain();
    }
}
