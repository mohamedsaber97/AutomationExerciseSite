package pages.authPages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage extends TestBase {
    public LoginPage() throws IOException {
    }

    RegisterPage registerPage = new RegisterPage();

    private final By loginLbl = By.xpath("//*[text() = 'Login to your account']");
    private final By emailTxt = By.xpath("//*[@data-qa = 'login-email']");
    private final By passwordTxt = By.xpath("//*[@data-qa = 'login-password']");
    private final By loginBtn = By.xpath("//*[text() = 'Login']");
    private final By incorrectDataLbl = By.xpath("//*[text() = 'Your email or password is incorrect!']");

    public void validLogin() {
        checkLoginOpen();
        validLoginForm();
        registerPage.deleteAccountCycle();
    }

    public void invalidLogin() {
        checkLoginOpen();
        invalidLoginForm();
        WebElement incorrectDataLElement = driver.findElement(incorrectDataLbl);
        actualBool = incorrectDataLElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the Your email or password is incorrect! is invisible-----");
        System.out.println("-----the Your email or password is incorrect! is visible-----");
    }

    public void checkLoginOpen() {
        WebElement loginLblElement = driver.findElement(loginLbl);
        actualBool = loginLblElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the Login to your account is invisible-----");
        System.out.println("-----the Login to your account is visible-----");
    }

    public void validLoginForm() {
        WebElement emailElement = driver.findElement(emailTxt);
        emailElement.sendKeys(properties.getProperty("loginEmail"));
        WebElement passwordElement = driver.findElement(passwordTxt);
        passwordElement.sendKeys(properties.getProperty("loginPassword"));
        WebElement loginElement = driver.findElement(loginBtn);
        loginElement.click();
    }

    public void invalidLoginForm() {
        String randomEmail = "test" + dateFormat + "@test.com";
        String randomPassword = "test" + dateFormat;
        WebElement emailElement = driver.findElement(emailTxt);
        emailElement.sendKeys(randomEmail);
        WebElement passwordElement = driver.findElement(passwordTxt);
        passwordElement.sendKeys(randomPassword);
        WebElement loginElement = driver.findElement(loginBtn);
        loginElement.click();
    }
}
