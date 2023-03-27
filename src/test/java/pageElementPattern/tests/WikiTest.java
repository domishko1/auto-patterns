package pageElementPattern.tests;

import pageElementPattern.objects.pages.DetailPage;
import pageElementPattern.objects.pages.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WikiTest extends BaseTest {
    private final static String SEARCH_STR1 = "Воронеж";
    private final static String SEARCH_STR2 = "Тула";
    MainPage mainPage = new MainPage();
    DetailPage detailPage = new DetailPage();

    @Before
    public void precondition() {
        mainPage.getHeadWidget()
                .clickOnSearchInput()
                .setTextToSearchInput(SEARCH_STR1)
                .clickOnSearchBtn();
    }

    @Test
    public void checkResultOfSearching() {
        String actualStr = detailPage.getTitleText();
        Assert.assertTrue(actualStr.contains(SEARCH_STR1));
    }

    @Test
    public void searchFromDetailPage() {
        String actualStr = detailPage.getHeadWidget()
                .clickOnSearchInput()
                .setTextToSearchInput(SEARCH_STR2)
                .clickOnSearchBtn()
                .getTitleText();

        Assert.assertTrue(actualStr.contains(SEARCH_STR2));
    }
}