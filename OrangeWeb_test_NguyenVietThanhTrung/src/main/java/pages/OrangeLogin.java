package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrangeLogin {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userNameBox = By.name("username");
    private By passwordBox = By.name("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By errorMsg = By.xpath("//p[contains(@class, 'oxd-alert-content-text')]");

    public OrangeLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
    }

    public void enterCredentials(String username, String password) {
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameBox));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox));

        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginButtonElement.click();
    }

    public String getErrorMessage() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return errorMessageElement.getText();
    }
}
