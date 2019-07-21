import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    WebDriver driver;

    BaseTest (String browser) {
        DesiredCapabilities cap;
        if(browser.contentEquals("CHROME")){
            cap = DesiredCapabilities.chrome();

            //System. setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
            //driver=new ChromeDriver();
        }
        else {
            cap = DesiredCapabilities.firefox();
            //System.setProperty("webdriver.firefox.marionette",".\\Drivers\\geckodriver.exe");
            //driver = new FirefoxDriver();
        }

        cap.setCapability("version","");
        cap.setCapability("platform", "LINUX");
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @BeforeEach
    public void beforeTest() {


    }

    @AfterEach
    public void afterTest() {
        driver.quit();
    }
}
