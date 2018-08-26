package mjcarrington.GithubExample.Tests;

import mjcarrington.GithubExample.Pages.BasePage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;

public class TestBase {
    public static RemoteWebDriver driver;
    public static final String baseTestURL = "http://www.github.com";
    // If using this as a test project, you will need to define these env variables
    public static final String username = System.getenv("GITHUBTESTUSERNAME");
    public static final String password = System.getenv("GITHUBTESTPASSWORD");
    BasePage basePage;


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