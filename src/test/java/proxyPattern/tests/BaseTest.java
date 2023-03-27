package proxyPattern.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {
    private final static String BASE_URL = "https://doramy.club";

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }

    @Before()
    @Step("init")
    public void init(){
        setUp();
        Selenide.open(BASE_URL);
    }

    @After
    @Step("tearDown")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
