package proxyPattern.tests;

import org.junit.Assert;
import org.junit.Test;
import proxyPattern.objects.AuthPage;
import proxyPattern.objects.HomePage;
import proxyPattern.objects.SiteProxy;
import proxyPattern.objects.SourceInfo;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest1() {
        HomePage homePage = new HomePage();
        AuthPage authPage = new AuthPage();

        SourceInfo sourceInfoHomePage = new SiteProxy(homePage);
        sourceInfoHomePage.getSource("homeBeforeAuth");

        homePage.clickOnLoginBtn();
        authPage.setDataToLoginBox("domishko1", "257274");
        authPage.clickOnSubmit();

        sourceInfoHomePage.getSource("homeAfterAuth");
        Assert.assertNotEquals(sourceInfoHomePage.getSource("homeBeforeAuth"), sourceInfoHomePage.getSource("homeAfterAuth"));

    }
}