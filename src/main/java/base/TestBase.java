package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties properties;
    public static Actions actions;
    public static JavascriptExecutor javascriptExecutor;
    public static String dateFormat;
    public static String expectedText = "";
    public static String actualText = "";
    public static Boolean actualBool = false;

    public static WebDriverWait wait;

    public TestBase() throws IOException {
        properties = new Properties();
        FileInputStream configFile = new FileInputStream("src/main/java/base/TestConfig");
        properties.load(configFile);
    }

    public static void initialization(String browser) {
        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Error("-----browser not supported-----");
        }

        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
        dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("url"));
    }
}
