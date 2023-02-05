package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class ProjectBase {

    //global project variables
    public static WebDriver driver;
    public static Actions actions;
    public static Properties properties;
    public static JavascriptExecutor javascriptExecutor;
    public static String dateFormat;

    //read project config file
    public ProjectBase() throws IOException {
        properties = new Properties();
        FileInputStream configFile = new FileInputStream("src/main/java/base/ProjectConfig");
        properties.load(configFile);
    }

    //initialize all global project variables and open browser with project url
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
            throw new Error("------browser not supported------");
        }

        actions = new Actions(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
        dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("url"));
    }
}
