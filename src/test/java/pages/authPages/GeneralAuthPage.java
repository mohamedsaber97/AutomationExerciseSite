package pages.authPages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class GeneralAuthPage extends TestBase {
    public GeneralAuthPage() throws IOException {
    }
    By singUpLoginBtn = By.xpath("//*[@href = '/login']");

    public void openRegisterOrLoginPage() {
        //click on signup/login button
        WebElement singUpLoginBtnElement = driver.findElement(singUpLoginBtn);
        singUpLoginBtnElement.click();
    }
}
