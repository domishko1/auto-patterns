package valueObjectPattern.tests;

import org.junit.Assert;
import valueObjectPattern.objects.entities.User;
import valueObjectPattern.objects.pages.AuthPage;
import valueObjectPattern.objects.pages.MainPage;
import org.junit.Test;

public class LoginTest extends BaseTest{
    private final User user = new User("domishko1", "257274", "");

    @Test
    public void loginTest() {

        MainPage mainPage = new MainPage();
        AuthPage authPage = new AuthPage();

        mainPage.clickOnLoginBtn();
        authPage.setDataToLoginBox(user);
        authPage.clickOnSubmit();

        Assert.assertTrue(mainPage.getProfileName().contains(user.getLogin()));
    }
}
