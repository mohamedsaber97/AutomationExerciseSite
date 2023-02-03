package testCases.authTestCases;

import base.ProjectBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.authPages.BaseAuthPage;
import pages.authPages.LoginPage;

import java.io.IOException;

public class LoginTest extends ProjectBase {
    public LoginTest() throws IOException {
    }

    BaseAuthPage baseAuthPage = new BaseAuthPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeEachLoginTC() {
        initialization(properties.getProperty("browser"));
        baseAuthPage.checkHomeLogo();
        baseAuthPage.openRegisterPage();
        System.out.println("-----before each login testcase is finished-----");
    }

    @AfterMethod
    public void afterEachLoginTC() {
        driver.quit();
        System.out.println("-----after each login testcase is finished-----");
    }

    @Test
    public void validLoginTC() {
        loginPage.validLogin();
        System.out.println("-----valid login testcase is finished-----");
    }

    @Test
    public void invalidLoginTC() {
        loginPage.invalidLogin();
        System.out.println("-----invalid login testcase is finished-----");
    }
}
