package pages.authPages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class RegisterPage extends TestBase {

    public RegisterPage() throws IOException {
    }

    //main elements
    By homeLogoImg = By.xpath("//*[@alt = 'Website for automation practice']");
    By singUpLoginBtn = By.xpath("//*[@href = '/login']");

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

    //method to check if that home is opened
    public void checkLogo() {
        WebElement homeLogoElement = driver.findElement(homeLogoImg);
        boolean actualLogo = homeLogoElement.isDisplayed();
        Assert.assertTrue(actualLogo, "-----the home logo is invisible-----");
        System.out.println("----the home logo is visible-----");
    }

    //method to submit register with new user
    public void registerNewUser() {
        signUpForm();
        accountInfoForm();
        verifyAndContinueCreatedAccount();
        deleteAccountCycle();
    }

    public void registerDuplicateUser() {
        signUpForm();

        //check if duplicate email alert is visible
        WebElement duplicateEmailElement = driver.findElement(duplicateEmailLbl);
        boolean actualDuplicateLbl = duplicateEmailElement.isDisplayed();
        Assert.assertTrue(actualDuplicateLbl, "-----the Email Address already exist! is invisible-----");
        System.out.println("----the Email Address already exist! is visible-----");
    }

    //method to submit valid signup form
    public void signUpForm() {
        //click on signup/login button
        WebElement singUpLoginBtnElement = driver.findElement(singUpLoginBtn);
        singUpLoginBtnElement.click();

        //check that signup is opened
        WebElement newUserElement = driver.findElement(newUserLbl);
        boolean actualLbl = newUserElement.isDisplayed();
        Assert.assertTrue(actualLbl, "-----the New User Signup! is invisible-----");
        System.out.println("----the New User Signup! is visible-----");

        //send data
        WebElement nameElement = driver.findElement(nameTxt);
        nameElement.sendKeys(properties.getProperty("name"));
        WebElement emailElement = driver.findElement(emailTxt);
        emailElement.sendKeys(properties.getProperty("email"));
        WebElement signUpElement = driver.findElement(signUbBtn);
        signUpElement.click();
    }

    public void accountInfoForm() {
        //check that account info is opened
        WebElement enterAccountElement = driver.findElement(enterAccountLbl);
        boolean actualLbl = enterAccountElement.isDisplayed();
        Assert.assertTrue(actualLbl, "-----the ENTER ACCOUNT INFORMATION is invisible-----");
        System.out.println("----the ENTER ACCOUNT INFORMATION is visible-----");

        //fill user data
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
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].click()", newsLetterElement);
        WebElement offersElement = driver.findElement(offersCheckbox);
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].click()", offersElement);

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
        JavascriptExecutor jse3 = (JavascriptExecutor) driver;
        jse3.executeScript("arguments[0].click()", createAccountElement);
    }

    //method to verify that account is created
    public void verifyAndContinueCreatedAccount() {
        WebElement accountCreatedElement = driver.findElement(accountCreatedLbl);
        boolean actualLbl = accountCreatedElement.isDisplayed();
        Assert.assertTrue(actualLbl, "-----the ACCOUNT CREATED! is invisible-----");
        System.out.println("----the ACCOUNT CREATED! is visible-----");
        WebElement continueCreatedElement = driver.findElement(continueCreatedBtn);
        continueCreatedElement.click();
    }

    //method to submit delete account cycle
    public void deleteAccountCycle() {
        //check if that user is already registered
        SoftAssert softAssert = new SoftAssert();
        WebElement loggedInElement = driver.findElement(loggedInLbl);
        boolean actualLoggedLbl = loggedInElement.isDisplayed();
        softAssert.assertTrue(actualLoggedLbl, "-----the Logged in as username is invisible-----");
        System.out.println("----the Logged in as username is visible-----");

        //click on delete account button
        WebElement deleteElement = driver.findElement(deleteBtn);
        deleteElement.click();

        //check if that user is deleted
        WebElement accountDeletedElement = driver.findElement(accountDeletedLbl);
        boolean actualDeletedLbl = accountDeletedElement.isDisplayed();
        softAssert.assertTrue(actualDeletedLbl, "-----the ACCOUNT DELETED! is invisible-----");
        System.out.println("----the ACCOUNT DELETED! is visible-----");

        //click on continue and finish delete cycle
        WebElement continueDeletedElement = driver.findElement(continueDeletedBtn);
        continueDeletedElement.click();
        softAssert.assertAll();
    }

}
