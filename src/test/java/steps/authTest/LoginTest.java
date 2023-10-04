package steps.authTest;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import general.GeneralTest;
import pages.authPages.LoginPage;

import java.io.IOException;

public class LoginTest extends TestBase {
    public LoginTest() throws IOException {
    }

    GeneralTest baseAuthPage = new GeneralTest();
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

    @Test(priority = 3)
    public void validLoginTC() {
        loginPage.validLogin();
        System.out.println("-----valid login testcase is finished-----");
    }

    @Test(priority = 4)
    public void invalidLoginTC() {
        loginPage.invalidLogin();
        System.out.println("-----invalid login testcase is finished-----");
    }
}
