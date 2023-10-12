package steps.authTest;

import base.TestBase;
import org.testng.annotations.*;
import pages.authPages.GeneralAuthPage;
import pages.authPages.LoginPage;

import java.io.IOException;

public class LoginTest extends TestBase {
    public LoginTest() throws IOException {
    }

    LoginPage loginPage = new LoginPage();
    GeneralAuthPage generalAuthPage = new GeneralAuthPage();


    @BeforeMethod(groups = "auth")
    public void beforeAllAuthTC() {
        generalAuthPage.openRegisterOrLoginPage();
        System.out.println("-----before each auth testcase is finished-----");
    }

    @Test(priority = 3, groups = "auth")
    public void validLoginTC() {
        loginPage.validLogin();
        System.out.println("-----valid login testcase is finished-----");
    }

    @Test(priority = 4, groups = "auth")
    public void invalidLoginTC() {
        loginPage.invalidLogin();
        System.out.println("-----invalid login testcase is finished-----");
    }
}
