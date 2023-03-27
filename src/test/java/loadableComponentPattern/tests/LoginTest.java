package loadableComponentPattern.tests;

import loadableComponentPattern.objects.AuthPage;
import loadableComponentPattern.objects.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest1() {
        HomePage mainPage = new HomePage();
        AuthPage authPage = new AuthPage();

        mainPage.clickOnLoginBtn();
        authPage.setDataToLoginBox("domishko1", "257274");
        authPage.clickOnSubmit();

        Assert.assertTrue(mainPage.getProfileName().contains("domishko1"));
    }


}