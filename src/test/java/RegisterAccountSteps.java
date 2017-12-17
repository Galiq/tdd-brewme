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
public class RegisterAccountSteps {

    private static ChromeDriver driver;
    private static CreateAccountPage createAccountPage;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");
        createAccountPage = new CreateAccountPage(driver);
    }

    @AfterClass
    protected void cleanup(){
        driver.quit();
    }

    @Given("^I click sign in button$")
    public void IClickSignInButton() {
        setup();
        createAccountPage.clickSignInButton();
    }

    @And("^I enter \"([^\"]*)\" in form$")
    public void iEnterInForm(String email) {
        createAccountPage.setEmailAddress(email);
    }

    @And("^I click Create an account button$")
    public void iClickCreateAnAccountButton() {
        createAccountPage.clickCreateEmail();
    }

    @And("^I enter the rest of required fields \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iEnterTheRestOfRequiredFields(String firstName, String lastName, String password, String address, String city, String state, String zipCode, String country, String mobilePhone) {
        createAccountPage.fillRegisterForm(firstName, lastName, password, address, city, state, zipCode, country, mobilePhone);
    }

    @When("^I click Register button$")
    public void iClickRegisterButton() {
        createAccountPage.clickRegisterSubmit();
    }

    @Then("^I am in my account page$")
    public void iAmInMyAccountPage() {
        createAccountPage.userIconDisplayed();
        cleanup();
    }
}
