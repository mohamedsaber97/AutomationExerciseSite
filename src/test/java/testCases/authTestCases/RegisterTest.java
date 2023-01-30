package testCases.authTestCases;

import base.TestBase;
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
        registerPage.checkLogo();
    }

    @AfterMethod
    public void afterEachMethod() {
        driver.quit();
    }

    @Test
    public void registerUserTC() {
        registerPage.registerTestCase();
    }
}
