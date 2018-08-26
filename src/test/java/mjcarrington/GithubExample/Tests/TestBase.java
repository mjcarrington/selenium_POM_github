package mjcarrington.GithubExample.Tests;

import mjcarrington.GithubExample.Pages.BasePage;
import mjcarrington.GithubExample.Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.net.URL;

public class TestBase {
    public static RemoteWebDriver driver;
    BasePage basePage;
    MainPage mainPage;
    public static final String baseTestURL = "http://www.github.com";

    // Driver bring-up
    @BeforeClass
    protected void createDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Applications/Selenium/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), chromeOptions);
        driver.get(baseTestURL);
        basePage = new BasePage(driver);
    }

    // Reset our state after each test
    @AfterMethod
    public void resetTestState() {
        driver.navigate().to(baseTestURL);
    }

    // End test
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}