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

    private final By newUserLbl = By.xpath("//*[text() = 'New User Signup!']");
    private final By nameTxt = By.name("name");
    private final By emailTxt = By.xpath("//*[@data-qa = 'signup-email']");
    private final By signUbBtn = By.xpath("//*[text() = 'Signup']");
    private final By enterAccountLbl = By.xpath("//*[text() = 'Enter Account Information']");
    private final By titleRadioBtn = By.id("id_gender1");
    private final By passwordTxt = By.id("password");
    private final By birthDaysDropdown = By.id("days");
    private final By birthMonthsDropdown = By.id("months");
    private final By birthYearsDropdown = By.id("years");
    private final By newsLetterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");
    private final By firstNameTxt = By.id("first_name");
    private final By lastNameTxt = By.id("last_name");
    private final By companyText = By.id("company");
    private final By address1Txt = By.id("address1");
    private final By address2Txt = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateTxt = By.id("state");
    private final By cityTxt = By.id("city");
    private final By zipcodeTxt = By.id("zipcode");
    private final By phoneTxt = By.id("mobile_number");
    private final By createAccountBtn = By.xpath("//*[text() = 'Create Account']");
    private final By accountCreatedLbl = By.xpath("//b[contains(text(),'Account Created!')]");
    private final By continueCreatedBtn = By.linkText("Continue");
    private final By loggedInLbl = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By deleteBtn = By.xpath("//a[contains(text(),'Delete Account')]");
    private final By accountDeletedLbl = By.xpath("//b[contains(text(),'Account Deleted!')]");
    By continueDeletedBtn = By.linkText("Continue");
    private final By duplicateEmailLbl = By.xpath("//*[text() = 'Email Address already exist!']");

    public void registerNewUser() {
        checkSignUpOpen();
        validSignUpForm();
        accountInfoForm();
        verifyAndContinueCreatedAccount();
        deleteAccountCycle();
    }

    public void registerDuplicateUser() {
        checkSignUpOpen();
        invalidSignUpForm();
        WebElement duplicateEmailElement = driver.findElement(duplicateEmailLbl);
        actualBool = duplicateEmailElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the Email Address already exist! is invisible-----");
        System.out.println("-----the Email Address already exist! is visible-----");
    }

    public void checkSignUpOpen() {
        WebElement newUserElement = driver.findElement(newUserLbl);
        actualBool = newUserElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the New User Signup! is invisible-----");
        System.out.println("-----the New User Signup! is visible-----");
    }

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

    public void invalidSignUpForm() {
        WebElement nameElement = driver.findElement(nameTxt);
        nameElement.sendKeys(properties.getProperty("registeredName"));
        WebElement emailElement = driver.findElement(emailTxt);
        emailElement.sendKeys(properties.getProperty("registeredEmail"));
        WebElement signUpElement = driver.findElement(signUbBtn);
        signUpElement.click();
    }

    public void accountInfoForm() {
        WebElement enterAccountElement = driver.findElement(enterAccountLbl);
        actualBool = enterAccountElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the ENTER ACCOUNT INFORMATION is invisible-----");
        System.out.println("-----the ENTER ACCOUNT INFORMATION is visible-----");

        WebElement titleRadioBtnElement = driver.findElement(titleRadioBtn);
        titleRadioBtnElement.click();
        WebElement passwordElement = driver.findElement(passwordTxt);
        passwordElement.sendKeys("123456");

        WebElement birthDaysElements = driver.findElement(birthDaysDropdown);
        Select daysDropdown = new Select(birthDaysElements);
        daysDropdown.selectByValue("5");
        WebElement birthMonthsElement = driver.findElement(birthMonthsDropdown);
        Select monthsDropdown = new Select(birthMonthsElement);
        monthsDropdown.selectByVisibleText("April");
        WebElement birthYearsElement = driver.findElement(birthYearsDropdown);
        Select yearsDropdown = new Select(birthYearsElement);
        yearsDropdown.selectByValue("2015");

        WebElement newsLetterElement = driver.findElement(newsLetterCheckbox);
        javascriptExecutor.executeScript("arguments[0].click()", newsLetterElement);
        WebElement offersElement = driver.findElement(offersCheckbox);
        javascriptExecutor.executeScript("arguments[0].click()", offersElement);

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

        WebElement createAccountElement = driver.findElement(createAccountBtn);
        javascriptExecutor.executeScript("arguments[0].click()", createAccountElement);
    }

    public void verifyAndContinueCreatedAccount() {
        WebElement accountCreatedElement = driver.findElement(accountCreatedLbl);
        actualBool = accountCreatedElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the ACCOUNT CREATED! is invisible-----");
        System.out.println("-----the ACCOUNT CREATED! is visible-----");
        WebElement continueCreatedElement = driver.findElement(continueCreatedBtn);
        continueCreatedElement.click();
    }

    public void deleteAccountCycle() {
        WebElement loggedInElement = driver.findElement(loggedInLbl);
        actualBool = loggedInElement.isDisplayed();
        softAssert.assertTrue(actualBool, "-----the Logged in as username is invisible-----");
        System.out.println("-----the Logged in as username is visible-----");

        WebElement deleteElement = driver.findElement(deleteBtn);
        deleteElement.click();

        WebElement accountDeletedElement = driver.findElement(accountDeletedLbl);
        actualBool = accountDeletedElement.isDisplayed();
        softAssert.assertTrue(actualBool, "-----the ACCOUNT DELETED! is invisible-----");
        System.out.println("-----the ACCOUNT DELETED! is visible-----");

        WebElement continueDeletedElement = driver.findElement(continueDeletedBtn);
        continueDeletedElement.click();
        softAssert.assertAll();
    }

}
