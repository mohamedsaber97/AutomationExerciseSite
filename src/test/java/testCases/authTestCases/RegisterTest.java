package testCases.authTestCases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.authPages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase {

    public RegisterTest() throws IOException {
    }

    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void openSiteAndVerifyHome() {
        initialization(properties.getProperty("browser"));
        WebElement homeLogo = driver.findElement(By.xpath("//*[@alt = 'Website for automation practice']"));
        boolean actualLogo = homeLogo.isDisplayed();
        Assert.assertTrue(actualLogo, "-----the home logo is invisible-----");
        System.out.println("----home logo is visible-----");
    }

    @AfterMethod
    public void afterEachMethod() {
        driver.quit();
    }

    @Test
    public void registerUserTC() {
        WebElement btn = driver.findElement(By.xpath("//*[@href = '/login']"));
        btn.click();
    }
}
