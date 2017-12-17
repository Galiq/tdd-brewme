import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by galik on 17.12.2017.
 */
public class LoginPage {

    WebDriver driver;

    By signIn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    By emailInput = By.id("email");
    By passwordInput = By.id("passwd");
    By submitLogin = By.name("SubmitLogin");


    By userIcon = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/i");
    By authFailed = By.className("alert-danger");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInButton() {
        driver.findElement(signIn).click();
    }

    public void setEmailAddress(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(submitLogin).click();
    }

    public void userIconDisplayed() {
        driver.findElement(userIcon).isDisplayed();
    }

    public void authenticationFailure() {
        driver.findElement(authFailed).isDisplayed();
    }
}
