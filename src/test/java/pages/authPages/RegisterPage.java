package pages.authPages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

import static utils.GeneralPage.softAssert;


public class RegisterPage extends TestBase {

    public RegisterPage() throws IOException {
    }

    //signup elements
    By newUserLbl = By.xpath("//*[text() = 'New User Signup!']");
    By nameTxt = By.name("name");
    By emailTxt = By.xpath("//*[@data-qa = 'signup-email']");
    By signUbBtn = By.xpath("//*[text() = 'Signup']");

    //account info elements
    By enterAccountLbl = By.xpath("//*[text() = 'Enter Account Information']");
    By titleRadioBtn = By.id("id_gender1");
    By passwordTxt = By.id("password");
    By birthDaysDropdown = By.id("days");
    By birthMonthsDropdown = By.id("months");
    By birthYearsDropdown = By.id("years");
    By newsLetterCheckbox = By.id("newsletter");
    By offersCheckbox = By.id("optin");
    By firstNameTxt = By.id("first_name");
    By lastNameTxt = By.id("last_name");
    By companyText = By.id("company");
    By address1Txt = By.id("address1");
    By address2Txt = By.id("address2");
    By countryDropdown = By.id("country");
    By stateTxt = By.id("state");
    By cityTxt = By.id("city");
    By zipcodeTxt = By.id("zipcode");
    By phoneTxt = By.id("mobile_number");
    By createAccountBtn = By.xpath("//*[text() = 'Create Account']");

    //verify creation elements
    By accountCreatedLbl = By.xpath("//b[contains(text(),'Account Created!')]");
    By continueCreatedBtn = By.linkText("Continue");

    //delete account cycle elements
    By loggedInLbl = By.xpath("//a[contains(text(),'Logged in as')]");
    By deleteBtn = By.xpath("//a[contains(text(),'Delete Account')]");
    By accountDeletedLbl = By.xpath("//b[contains(text(),'Account Deleted!')]");
    By continueDeletedBtn = By.linkText("Continue");

    //duplicate email elements
    By duplicateEmailLbl = By.xpath("//*[text() = 'Email Address already exist!']");

    //method to submit register with new user
    public void registerNewUser() {
        checkSignUpOpen();
        validSignUpForm();
        accountInfoForm();
        verifyAndContinueCreatedAccount();
        deleteAccountCycle();
    }

    //method to submit register with duplicate user
    public void registerDuplicateUser() {
        checkSignUpOpen();
        invalidSignUpForm();
        //check if duplicate email alert is visible
        WebElement duplicateEmailElement = driver.findElement(duplicateEmailLbl);
        actualBool = duplicateEmailElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the Email Address already exist! is invisible-----");
        System.out.println("----the Email Address already exist! is visible-----");
    }

    //method to check that signup is opened
    public void checkSignUpOpen() {
        WebElement newUserElement = driver.findElement(newUserLbl);
        actualBool = newUserElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the New User Signup! is invisible-----");
        System.out.println("----the New User Signup! is visible-----");
    }


    //method to send valid signup data
    public void validSignUpForm() {
        String randomName = "test" + dateFormat;
        String randomEmail = "test" + dateFormat + "@test.com";
        WebElement nameElement = driver.findElement(nameTxt);
        nameElement.sendKeys(randomName);
        WebElement emailElement = driver.findElement(emailTxt);
        emailElement.sendKeys(randomEmail);
        WebElement signUpElement = driver.findElement(signUbBtn);
        signUpElement.click();
    }

    //method to send invalid signup data
    public void invalidSignUpForm() {
        WebElement nameElement = driver.findElement(nameTxt);
        nameElement.sendKeys(properties.getProperty("registeredName"));
        WebElement emailElement = driver.findElement(emailTxt);
        emailElement.sendKeys(properties.getProperty("registeredEmail"));
        WebElement signUpElement = driver.findElement(signUbBtn);
        signUpElement.click();
    }

    //method to complete account information
    public void accountInfoForm() {
        //check that account info is opened
        WebElement enterAccountElement = driver.findElement(enterAccountLbl);
        actualBool = enterAccountElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the ENTER ACCOUNT INFORMATION is invisible-----");
        System.out.println("----the ENTER ACCOUNT INFORMATION is visible-----");

        //fill user info
        WebElement titleRadioBtnElement = driver.findElement(titleRadioBtn);
        titleRadioBtnElement.click();
        WebElement passwordElement = driver.findElement(passwordTxt);
        passwordElement.sendKeys("123456");

        //fill user birthday
        WebElement birthDaysElements = driver.findElement(birthDaysDropdown);
        Select daysDropdown = new Select(birthDaysElements);
        daysDropdown.selectByValue("5");
        WebElement birthMonthsElement = driver.findElement(birthMonthsDropdown);
        Select monthsDropdown = new Select(birthMonthsElement);
        monthsDropdown.selectByVisibleText("April");
        WebElement birthYearsElement = driver.findElement(birthYearsDropdown);
        Select yearsDropdown = new Select(birthYearsElement);
        yearsDropdown.selectByValue("2015");

        //choose checkboxes of newLetters and offers
        WebElement newsLetterElement = driver.findElement(newsLetterCheckbox);
        javascriptExecutor.executeScript("arguments[0].click()", newsLetterElement);
        WebElement offersElement = driver.findElement(offersCheckbox);
        javascriptExecutor.executeScript("arguments[0].click()", offersElement);

        //fill user address data
        WebElement firstNameElement = driver.findElement(firstNameTxt);
        firstNameElement.sendKeys("new");
        WebElement lastNameElement = driver.findElement(lastNameTxt);
        lastNameElement.sendKeys("user");
        WebElement companyElement = driver.findElement(companyText);
        companyElement.sendKeys("test company");
        WebElement address1Element = driver.findElement(address1Txt);
        address1Element.sendKeys("address 1 test");
        WebElement address2Element = driver.findElement(address2Txt);
        address2Element.sendKeys("address 2 test");
        WebElement countryElement = driver.findElement(countryDropdown);
        Select countriesDropdown = new Select(countryElement);
        countriesDropdown.selectByIndex(2);
        WebElement stateElement = driver.findElement(stateTxt);
        stateElement.sendKeys("state test");
        WebElement cityElement = driver.findElement(cityTxt);
        cityElement.sendKeys("city test");
        WebElement zipcodeElement = driver.findElement(zipcodeTxt);
        zipcodeElement.sendKeys("1234");
        WebElement phoneElement = driver.findElement(phoneTxt);
        phoneElement.sendKeys("0123456789");

        //click on create account button
        WebElement createAccountElement = driver.findElement(createAccountBtn);
        javascriptExecutor.executeScript("arguments[0].click()", createAccountElement);
    }

    //method to verify that account is created
    public void verifyAndContinueCreatedAccount() {
        WebElement accountCreatedElement = driver.findElement(accountCreatedLbl);
        actualBool = accountCreatedElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the ACCOUNT CREATED! is invisible-----");
        System.out.println("----the ACCOUNT CREATED! is visible-----");
        WebElement continueCreatedElement = driver.findElement(continueCreatedBtn);
        continueCreatedElement.click();
    }

    //method to submit delete account cycle
    public void deleteAccountCycle() {
        //check if that user is already registered
        WebElement loggedInElement = driver.findElement(loggedInLbl);
        actualBool = loggedInElement.isDisplayed();
        softAssert.assertTrue(actualBool, "-----the Logged in as username is invisible-----");
        System.out.println("----the Logged in as username is visible-----");

        //click on delete account button
        WebElement deleteElement = driver.findElement(deleteBtn);
        deleteElement.click();

        //check if that user is deleted
        WebElement accountDeletedElement = driver.findElement(accountDeletedLbl);
        actualBool = accountDeletedElement.isDisplayed();
        softAssert.assertTrue(actualBool, "-----the ACCOUNT DELETED! is invisible-----");
        System.out.println("----the ACCOUNT DELETED! is visible-----");

        //click on continue and finish delete cycle
        WebElement continueDeletedElement = driver.findElement(continueDeletedBtn);
        continueDeletedElement.click();
        softAssert.assertAll();
    }

}
