package pages.authPages;

import base.ProjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class BaseAuthPage extends ProjectBase {
    public BaseAuthPage() throws IOException {
    }

    //main elements
    By homeLogoImg = By.xpath("//*[@alt = 'Website for automation practice']");
    By singUpLoginBtn = By.xpath("//*[@href = '/login']");


    //method to check if that home is opened
    public void checkHomeLogo() {
        WebElement homeLogoElement = driver.findElement(homeLogoImg);
        boolean actualLogo = homeLogoElement.isDisplayed();
        Assert.assertTrue(actualLogo, "-----the home logo is invisible-----");
        System.out.println("----the home logo is visible-----");
    }

    public void openRegisterPage() {
        //click on signup/login button
        WebElement singUpLoginBtnElement = driver.findElement(singUpLoginBtn);
        singUpLoginBtnElement.click();
    }
}
