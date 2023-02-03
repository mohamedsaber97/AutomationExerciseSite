package pages.authPages;

import base.ProjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage extends ProjectBase {
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
        loginForm();
        registerPage.deleteAccountCycle();
    }

    //method to submit invalid login
    public void invalidLogin() {
        loginForm();

        //check if error login data is visible
        WebElement incorrectDataLElement = driver.findElement(incorrectDataLbl);
        boolean actualIncorrectLbl = incorrectDataLElement.isDisplayed();
        Assert.assertTrue(actualIncorrectLbl, "-----the Your email or password is incorrect! is invisible-----");
        System.out.println("----the Your email or password is incorrect! is visible-----");
    }

    //method to submit valid login form
    public void loginForm() {
        //check that login is opened
        WebElement loginLblElement = driver.findElement(loginLbl);
        boolean actualLbl = loginLblElement.isDisplayed();
        Assert.assertTrue(actualLbl, "-----the Login to your account is invisible-----");
        System.out.println("----the Login to your account is visible-----");

        //send data
        WebElement emailElement = driver.findElement(emailTxt);
        emailElement.sendKeys(properties.getProperty("loginEmail"));
        WebElement passwordElement = driver.findElement(passwordTxt);
        passwordElement.sendKeys(properties.getProperty("loginPassword"));
        WebElement loginElement = driver.findElement(loginBtn);
        loginElement.click();
    }
}
