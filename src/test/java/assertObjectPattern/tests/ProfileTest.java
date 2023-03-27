package assertObjectPattern.tests;

import assertObjectPattern.objects.entities.User;
import assertObjectPattern.objects.entities.UserAssert;
import assertObjectPattern.objects.pages.AuthPage;
import assertObjectPattern.objects.pages.MainPage;
import assertObjectPattern.objects.pages.ProfilePage;
import org.junit.Before;
import org.junit.Test;

public class ProfileTest extends BaseTest {
    private final User user = new User("domishko1", "257274", "christina.lavrinenko@gmail.com");
    private User userOnProfile;
    MainPage mainPage = new MainPage();
    AuthPage authPage = new AuthPage();

    ProfilePage profilePage = new ProfilePage();

    @Before
    public void precondition() {
        mainPage.clickOnLoginBtn();
        authPage.setDataToLoginBox(user);
        authPage.clickOnSubmit();
        mainPage.goToProfile();
        userOnProfile = profilePage.getUserData();
    }

    @Test
    public void checkProfileData() {
        assertThat(userOnProfile).hasProfileData();
    }

    public static UserAssert assertThat(User user) {
        return new UserAssert(user);
    }
}
