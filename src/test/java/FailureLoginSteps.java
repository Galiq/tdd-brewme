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
public class FailureLoginSteps {

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
    protected void cleanup(){
        driver.quit();
    }

    @Given("^I click main signin button$")
    public void IClickSignInButton() {
        setup();
        loginPage.clickSignInButton();
    }

    @And("^I enter bad email \"([^\"]*)\" in form$")
    public void iEnterBadEmailInForm(String email) {
        loginPage.setEmailAddress(email);
    }

    @And("^I enter bad password \"([^\"]*)\" in form$")
    public void iEnterBadPasswordInForm(String password) {
        loginPage.setPassword(password);
    }

    @When("^I click Signin button$")
    public void iClickSignInButton() {
        loginPage.clickLogin();
    }

    @Then("^I have authentication failure$")
    public void iHaveAuthenticationFailure() {
        loginPage.authenticationFailure();
        cleanup();
    }
}
