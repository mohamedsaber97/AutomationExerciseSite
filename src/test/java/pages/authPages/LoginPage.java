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

    //login elements
    By loginLbl = By.xpath("//*[text() = 'Login to your account']");
    By emailTxt = By.xpath("//*[@data-qa = 'login-email']");
    By passwordTxt = By.xpath("//*[@data-qa = 'login-password']");
    By loginBtn = By.xpath("//*[text() = 'Login']");

    //error login data elements
    By incorrectDataLbl = By.xpath("//*[text() = 'Your email or password is incorrect!']");


    //method to submit valid login
    public void validLogin() {
        checkLoginOpen();
        validLoginForm();
        registerPage.deleteAccountCycle();
    }

    //method to submit invalid login
    public void invalidLogin() {
        checkLoginOpen();
        invalidLoginForm();
        //check if error login data is visible
        WebElement incorrectDataLElement = driver.findElement(incorrectDataLbl);
        actualBool = incorrectDataLElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the Your email or password is incorrect! is invisible-----");
        System.out.println("----the Your email or password is incorrect! is visible-----");
    }

    //method to check that login is opened
    public void checkLoginOpen() {
        WebElement loginLblElement = driver.findElement(loginLbl);
        actualBool = loginLblElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the Login to your account is invisible-----");
        System.out.println("----the Login to your account is visible-----");
    }

    //method to send valid login data
    public void validLoginForm() {
        WebElement emailElement = driver.findElement(emailTxt);
        emailElement.sendKeys(properties.getProperty("loginEmail"));
        WebElement passwordElement = driver.findElement(passwordTxt);
        passwordElement.sendKeys(properties.getProperty("loginPassword"));
        WebElement loginElement = driver.findElement(loginBtn);
        loginElement.click();
    }

    //method to send invalid login data
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
