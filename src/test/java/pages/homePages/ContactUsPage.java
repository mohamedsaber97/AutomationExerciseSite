package pages.homePages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class ContactUsPage extends TestBase {
    public ContactUsPage() throws IOException {
    }

    By contactUsBtn = By.xpath("//*[text() = ' Contact us']");
    By getTouchLbl = By.xpath(("//*[text() = 'Get In Touch']"));
    By nameTxt = By.name("name");
    By emailTxt = By.name("email");
    By subjectTxt = By.name("subject");
    By messageTxt = By.id("message");
    By uploadFile = By.name("upload_file");
    By submitBtn = By.name("submit");

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
        emailElement.sendKeys("test name");
        WebElement subjectElement = driver.findElement(subjectTxt);
        subjectElement.sendKeys("test name");
        WebElement messageElement = driver.findElement(messageTxt);
        messageElement.sendKeys("test name");
        WebElement uploadFileElement = driver.findElement(uploadFile);
        uploadFileElement.sendKeys("D:\\saber\\test data\\sample.pdf");
    }

    public void submitFormAndDialog() {
        WebElement submitElement = driver.findElement(submitBtn);
        submitElement.click();
        driver.switchTo().alert().accept();
    }
}
