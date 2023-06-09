package pageElementPattern.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {
    private final static String BASE_URL = "https://ru.wikipedia.org";

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Before()
    public void init(){
        setUp();
        Selenide.open(BASE_URL);
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
