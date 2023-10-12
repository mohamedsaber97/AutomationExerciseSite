package steps.homeTest;

import base.TestBase;
import org.testng.annotations.Test;
import pages.homePages.ContactUsPage;

import java.io.IOException;

public class ContactUsTest extends TestBase {
    public ContactUsTest() throws IOException {
    }

    ContactUsPage contactUsPage = new ContactUsPage();

    @Test(priority = 5, groups = "home")
    public void openAndVerifyContactUsTitleTC() {
        contactUsPage.openAndVerifyContactUsTitle();
        System.out.println("-----open and verify contactUs Title testcase is finished-----");
    }

    @Test(priority = 6, groups = "home")
    public void submitFormAndDialogTC() {
        contactUsPage.fillContactUsData();
        contactUsPage.submitFormAndDialog();
        System.out.println("-----submit form and dialog testcase is finished-----");
    }
}
