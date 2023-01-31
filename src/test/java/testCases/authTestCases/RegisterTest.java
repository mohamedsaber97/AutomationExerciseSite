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
        System.out.println("-----before method is finished-----");
    }

    @AfterMethod
    public void afterEachMethod() {
        driver.quit();
        System.out.println("-----after method is finished-----");
    }

    @Test(priority = 1)
    public void registerNewUserTC() {
        registerPage.registerNewUser();
        System.out.println("-----register new user testcase is finished-----");
    }

    @Test(priority = 2)
    public void registerDuplicateUserTC() {
        registerPage.registerDuplicateUser();
        System.out.println("-----register duplicate user testcase is finished-----");
    }
}
