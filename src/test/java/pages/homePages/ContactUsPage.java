package pages.homePages;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class ContactUsPage extends TestBase {
    public ContactUsPage() throws IOException {
    }

    private final By contactUsBtn = By.xpath("//*[text() = ' Contact us']");
    private final By getTouchLbl = By.xpath(("//*[text() = 'Get In Touch']"));
    private final By nameTxt = By.name("name");
    private final By emailTxt = By.name("email");
    private final By subjectTxt = By.name("subject");
    private final By messageTxt = By.id("message");
    private final By uploadFile = By.name("upload_file");
    private final By submitBtn = By.name("submit");

    public void openAndVerifyContactUsTitle() {
        WebElement contactUsElement = driver.findElement(contactUsBtn);
        contactUsElement.click();
        WebElement getTouchElement = driver.findElement(getTouchLbl);
        actualBool = getTouchElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the get touch title is invisible-----");
        System.out.println("-----the get touch title is visible-----");
    }

    public void fillContactUsData() {
        WebElement nameElement = driver.findElement(nameTxt);
        nameElement.sendKeys("test name");
        WebElement emailElement = driver.findElement(emailTxt);
        emailElement.sendKeys("tt@tt.ttt");
        WebElement subjectElement = driver.findElement(subjectTxt);
        subjectElement.sendKeys("test subject");
        WebElement messageElement = driver.findElement(messageTxt);
        messageElement.sendKeys("test message");
        WebElement uploadFileElement = driver.findElement(uploadFile);
        uploadFileElement.sendKeys("D:\\work\\Manual\\test data\\sample.pdf");
    }

    public void submitFormAndDialog() {
        WebElement submitElement = driver.findElement(submitBtn);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(submitElement));
            submitElement.click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            actualText = alert.getText();
            expectedText = "Press OK to proceed!";
            alert.accept();
            Assert.assertEquals(actualText, expectedText);
        } catch (Exception e) {
            System.out.println("-----no such alert or submit button is hidden-----");
        }
    }
}
