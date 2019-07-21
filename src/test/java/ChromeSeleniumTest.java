import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ChromeSeleniumTest extends BaseTest {


    ChromeSeleniumTest() {
        super("CHROME");
    }

    @Test
    public void chromeTest() {
        this.driver.get("http://demo.guru99.com/test/guru99home/");
        String title = this.driver.getTitle();
        assertTrue(title.contains("Demo Guru99 Page"));
    }



}