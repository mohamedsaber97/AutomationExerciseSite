package steps.authTest;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.authPages.GeneralAuthPage;

import java.io.IOException;

public class GeneralAuthTest extends TestBase {
    public GeneralAuthTest() throws IOException {
    }

    GeneralAuthPage generalAuthPage = new GeneralAuthPage();

    @BeforeMethod(groups = "auth")
    public void beforeAllAuthTC() {
        generalAuthPage.openRegisterOrLoginPage();
        System.out.println("-----before each auth testcase is finished-----");
    }

    @AfterMethod(groups = "auth")
    public void afterAll() {
        driver.quit();
        System.out.println("-----after each auth testcase is finished-----");
    }
}
