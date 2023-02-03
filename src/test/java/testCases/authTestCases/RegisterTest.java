package testCases.authTestCases;

import base.ProjectBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.authPages.BaseAuthPage;
import pages.authPages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends ProjectBase {

    public RegisterTest() throws IOException {
    }

    BaseAuthPage baseAuthPage = new BaseAuthPage();
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
