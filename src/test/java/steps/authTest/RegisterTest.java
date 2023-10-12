package steps.authTest;

import base.TestBase;
import org.testng.annotations.*;
import pages.authPages.GeneralAuthPage;
import pages.authPages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase {

    public RegisterTest() throws IOException {
    }

    RegisterPage registerPage = new RegisterPage();
    GeneralAuthPage generalAuthPage = new GeneralAuthPage();

    @BeforeMethod(groups = "auth")
    public void beforeAllAuthTC() {
        generalAuthPage.openRegisterOrLoginPage();
        System.out.println("-----before each auth testcase is finished-----");
    }

    @Test(priority = 1, groups = "auth")
    public void registerNewUserTC() {
        registerPage.registerNewUser();
        System.out.println("-----register new user testcase is finished-----");
    }

    @Test(priority = 2, groups = "auth")
    public void registerDuplicateUserTC() {
        registerPage.registerDuplicateUser();
        System.out.println("-----register duplicate user testcase is finished-----");
    }
}
