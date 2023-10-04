package steps.authTest;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import general.GeneralTest;
import pages.authPages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase {

    public RegisterTest() throws IOException {
    }

    GeneralTest baseAuthPage = new GeneralTest();
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeEachRegisterTC() {
        initialization(properties.getProperty("browser"));
        baseAuthPage.checkHomeLogo();
        baseAuthPage.openRegisterPage();
        System.out.println("-----before each register testcase is finished-----");
    }

    @AfterMethod
    public void afterEachRegisterTC() {
        driver.quit();
        System.out.println("-----after each register testcase is finished-----");
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
