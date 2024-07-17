package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OrangeLogin;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OrangeWebTest {
    private WebDriver driver;
    private OrangeLogin orangeLogin;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        orangeLogin = new OrangeLogin(driver);
    }

    @Test
    public void testValidLogin() {
        orangeLogin.enterCredentials("Admin", "admin123");
        orangeLogin.clickLoginButton();

        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testInvalidLogin() {
        orangeLogin.enterCredentials("invalidUser", "invalidPass");
        orangeLogin.clickLoginButton();

        String expectedErrorMessage = "Invalid credentials";
        String actualErrorMessage = orangeLogin.getErrorMessage();
        assertNotNull(actualErrorMessage);
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void testEmptyCredentials() {
        orangeLogin.enterCredentials("", "");
        orangeLogin.clickLoginButton();

        String expectedErrorMessage = "Required";
        String actualErrorMessage = orangeLogin.getErrorMessage();
        assertNotNull(actualErrorMessage);
        assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
