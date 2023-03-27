package chainPattern.tests;

import chainPattern.objects.pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class WikiTest extends BaseTest {
    private final static String SEARCH_STR = "Воронеж";

    @Test
    public void checkResultOfSearching() {
        String actualTitle = new MainPage()
                .clickOnSearchInput()
                .setTextToSearchInput(SEARCH_STR)
                .clickOnSearchBtn()
                .getTitleText();

        Assert.assertTrue(actualTitle.contains(SEARCH_STR));
    }
}