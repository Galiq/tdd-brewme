import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by galik on 03.12.2017.
 */
public class AutomationPracticeTest {

    private static WebDriver driver;
    Actions action;
    WebElement element;
    List<WebElement> elements;

    @BeforeClass
    public static void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void getElements(){
        driver.get("http://automationpractice.com");

        element = driver.findElement(By.className("shop-phone")).findElement(By.tagName("strong"));
        assertNotNull(element);

        element = driver.findElement(By.id("homepage-slider"));
        assertTrue(element.isDisplayed());


        element = driver.findElement(By.className("shopping_cart")).findElement(By.tagName("a"));
        assertEquals("http://automationpractice.com/index.php?controller=order", element.getAttribute("href"));
    }

    @Test
    public void bestSellers() {
        driver.get("http://automationpractice.com");

        element = driver.findElement(By.id("blockbestsellers")).findElement(By.className("product_img_link"));
        assertFalse(element.isDisplayed());

        driver.findElement(By.id("home-page-tabs")).findElement(By.xpath("//a[contains(text(), 'Best Sellers')]")).click();

        element = driver.findElement(By.id("blockbestsellers")).findElement(By.className("product_img_link"));
        assertEquals("Printed Chiffon Dress", element.getAttribute("title"));

        elements = driver.findElement(By.id("blockbestsellers")).findElements(By.className("product-container"));
        assertEquals(7, elements.size());

        for (int i = 0; i < elements.size(); i++) {
            assertTrue(elements.get(i).isDisplayed());
        }
    }

    @Test
    public void dresses() throws InterruptedException {
        driver.get("http://automationpractice.com");
        action = new Actions(driver);
        element = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));

        assertTrue(element.isDisplayed());
        action.moveToElement(element).build().perform();

        element = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        assertNotNull(screenshot);

        assertTrue(element.isDisplayed());
        element = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a"));
        assertTrue(element.isDisplayed());
        element = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a"));
        assertTrue(element.isDisplayed());

        try {
            FileUtils.copyFile(screenshot, new File("./target/dresses.png"));
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void loginPage() {
        driver.get("http://automationpractice.com");
        element = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl());


    }

    @AfterClass
    public static void cleanup() {
        driver.quit();
    }
}

