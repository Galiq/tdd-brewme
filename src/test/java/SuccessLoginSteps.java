import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by galik on 17.12.2017.
 */
public class SuccessLoginSteps {

    private static ChromeDriver driver;
    private static LoginPage loginPage;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    protected void cleanup() {
        driver.quit();
    }

    @Given("^I click main sign in button$")
    public void IClickSignInButton() {
        setup();
        loginPage.clickSignInButton();
    }

    @And("^I enter email \"([^\"]*)\" in form$")
    public void iEnterEmailInForm(String email) {
        loginPage.setEmailAddress(email);
    }

    @And("^I enter password \"([^\"]*)\" in form$")
    public void iEnterPasswordInForm(String password) {
        loginPage.setPassword(password);
    }

    @When("^I click Sign in button$")
    public void iClickSignInButton() {
        loginPage.clickLogin();
    }

    @Then("^I have logged in$")
    public void iHaveLoggedIn() {
        loginPage.userIconDisplayed();
        cleanup();
    }
}
