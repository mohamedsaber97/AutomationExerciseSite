package general;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class GeneralTest extends TestBase {
    public GeneralTest() throws IOException {
    }

    public static SoftAssert softAssert = new SoftAssert();

    //main elements
    By homeLogoImg = By.xpath("//*[@alt = 'Website for automation practice']");
    By singUpLoginBtn = By.xpath("//*[@href = '/login']");

    //method to check if that home is opened
    public void checkHomeLogo() {
        WebElement homeLogoElement = driver.findElement(homeLogoImg);
        actualBool = homeLogoElement.isDisplayed();
        Assert.assertTrue(actualBool, "-----the home logo is invisible-----");
        System.out.println("----the home logo is visible-----");
    }

    public void openRegisterPage() {
        //click on signup/login button
        WebElement singUpLoginBtnElement = driver.findElement(singUpLoginBtn);
        singUpLoginBtnElement.click();
    }
}
