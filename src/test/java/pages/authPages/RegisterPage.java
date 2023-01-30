package pages.authPages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class RegisterPage extends TestBase {

    public RegisterPage() throws IOException {
    }

    By homeLogo = By.xpath("//*[@alt = 'Website for automation practice']");
    By singUpLoginBtn = By.xpath("//*[@href = '/login']");

    public void checkLogo() {
        WebElement logo = driver.findElement(homeLogo);
        boolean actualLogo = logo.isDisplayed();
        Assert.assertTrue(actualLogo, "-----the home logo is invisible-----");
        System.out.println("----home logo is visible-----");
    }

    public void registerTestCase() {
        WebElement singUpLogin = driver.findElement(singUpLoginBtn);
        singUpLogin.click();
    }

}
