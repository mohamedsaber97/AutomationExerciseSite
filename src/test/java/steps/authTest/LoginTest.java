package steps.authTest;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.authPages.GeneralAuthPage;
import pages.authPages.LoginPage;
import java.io.IOException;

public class LoginTest extends TestBase {
    public LoginTest() throws IOException {
    }

    LoginPage loginPage = new LoginPage();
    GeneralAuthPage generalAuthPage = new GeneralAuthPage();

    @BeforeMethod
    public void beforeEachLoginTC() {
        generalAuthPage.openRegisterOrLoginPage();
        System.out.println("-----before each login testcase is finished-----");
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
