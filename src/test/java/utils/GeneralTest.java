package utils;

import base.TestBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class GeneralTest extends TestBase {
    public GeneralTest() throws IOException {
    }

    GeneralPage generalPage= new GeneralPage();

    @BeforeTest
    public void beforeAll(){
        initialization(properties.getProperty("browser"));
        generalPage.checkHomeLogo();
        System.out.println("-----before each testcase is finished-----");
    }

    @AfterTest
    public void afterAll(){
        driver.quit();
        System.out.println("-----after each testcase is finished-----");
    }
}
