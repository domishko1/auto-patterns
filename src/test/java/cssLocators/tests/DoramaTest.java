package cssLocators.tests;

import cssLocators.pages.AuthPage;
import cssLocators.pages.SearchPage;
import org.junit.Assert;
import org.junit.Test;
import cssLocators.pages.HomePage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DoramaTest extends BaseTest {
    HomePage homePage = new HomePage();
    AuthPage authPage = new AuthPage();
    SearchPage searchPage = new SearchPage();

    @Test
    public void loginTest() {
        homePage.clickOnLoginBtn();
        authPage.setDataToLoginBox("domishko1", "257274")
               .clickOnSubmit();

        Assert.assertEquals("domishko1", homePage.getAuthUserName());
    }

    @Test
    public void searchTest() {
        homePage.clickOnSearchField()
                .sendTextToSearchField("Месть")
                .clickOnSearchBtn();

        List<String> actualDoramaNames = searchPage.getAllDoramaNamesOnPage();
        assertThat(actualDoramaNames).asList().allMatch(s -> s.toString().toLowerCase().contains("месть"));

    }
}