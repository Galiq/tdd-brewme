import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by galik on 17.12.2017.
 */
public class CreateAccountPage {

    WebDriver driver;

    By signIn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    By emailCreate = By.name("email_create");
    By submitCreate = By.name("SubmitCreate");

    By firstNameInput = By.id("customer_firstname");
    By lastNameInput = By.id("customer_lastname");
    By passwordInput = By.id("passwd");
    By addressInput = By.id("address1");
    By cityInput = By.id("city");
    By stateSelect = By.id("id_state");
    By zipcodeInput = By.id("postcode");
    By countrySelect = By.id("id_country");
    By phoneInputSelect = By.id("phone_mobile");
    By registerSubmit = By.name("submitAccount");

    By userIcon = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/i");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInButton() {
        driver.findElement(signIn).click();
    }

    public void setEmailAddress(String email) {
        driver.findElement(emailCreate).sendKeys(email);
    }

    public void clickCreateEmail() {
        driver.findElement(submitCreate).click();
    }

    public void fillRegisterForm(String firstName, String lastName, String password, String address, String city, String state, String zipCode, String country, String mobilePhone) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(cityInput).sendKeys(city);
        new Select(driver.findElement(stateSelect)).selectByVisibleText(state);
        driver.findElement(zipcodeInput).sendKeys(zipCode);
        new Select(driver.findElement(countrySelect)).selectByVisibleText(country);
        driver.findElement(phoneInputSelect).sendKeys(mobilePhone);
    }

    public void clickRegisterSubmit() {
        driver.findElement(registerSubmit).click();
    }

    public void userIconDisplayed() {
        driver.findElement(userIcon).isDisplayed();
    }

}
