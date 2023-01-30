package pages.authPages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class RegisterPage extends TestBase {

    public RegisterPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@alt = 'Website for automation practice']")
    WebElement homeLogo;

    @FindBy(xpath = "//*[@href = '/login']")
    WebElement signupLoginBtn;


    public void checkLogo() {
        boolean actualLogo = homeLogo.isDisplayed();
        Assert.assertTrue(actualLogo, "-----the home logo is invisible-----");
        System.out.println("----home logo is visible-----");
    }

    public void registerTestCase() {
        signupLoginBtn.click();
    }
}
