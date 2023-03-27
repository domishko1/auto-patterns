package pageObjectPattern.tests;

import pageObjectPattern.objects.pages.DetailPage;
import pageObjectPattern.objects.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class WikiTest extends BaseTest {
    private final static String SEARCH_STR = "Воронеж";

    @Test
    public void checkResultOfSearching() {
        MainPage mainPage = new MainPage();
        DetailPage detailPage = new DetailPage();

        mainPage.clickOnSearchInput();
        mainPage.setTextToSearchInput(SEARCH_STR);
        mainPage.clickOnSearchBtn();

        String actualStr = detailPage.getTitleText();

        Assert.assertTrue(actualStr.contains(SEARCH_STR));
    }
}