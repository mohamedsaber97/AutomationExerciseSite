package steps.authTest;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.authPages.GeneralAuthPage;
import pages.authPages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase {

    public RegisterTest() throws IOException {
    }

    GeneralAuthPage generalAuthPage = new GeneralAuthPage();
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeEachRegisterTC() {
        generalAuthPage.openRegisterOrLoginPage();
        System.out.println("-----before each register testcase is finished-----");
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
