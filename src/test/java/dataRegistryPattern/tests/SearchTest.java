package dataRegistryPattern.tests;

import com.codeborne.selenide.SelenideElement;
import dataRegistryPattern.objects.SearchRegistry;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$x;

public class SearchTest extends BaseTest {
    private final SelenideElement searchField = $x("//input[@name=\"s\"]");
    private final SelenideElement searchBtn = $x("//input[@class=\"art-search-button\"]");
    private final SelenideElement title = $x("//div[@class=\"post-home\"]//span");

    @Test
    public void searchTestSmt() {
        String text = SearchRegistry.getSearchText();
        System.out.println(text);

        searchField.click();
        searchField.sendKeys(text);
        searchBtn.click();
        $x("//div[@class=\"post-home\"]").scrollIntoView(true);
        Assert.assertEquals(text, title.getText());
    }

    @Test
    public void searchTestSde() {
        String text = SearchRegistry.getSearchText();
        System.out.println(text);

        searchField.click();
        searchField.sendKeys(text);
        searchBtn.click();
        $x("//div[@class=\"post-home\"]").scrollIntoView(true);
        Assert.assertEquals(text, title.getText());
    }

    @Test
    public void searchTestAvr() {
        String text = SearchRegistry.getSearchText();
        System.out.println(text);

        searchField.click();
        searchField.sendKeys(text);
        searchBtn.click();
        $x("//div[@class=\"post-home\"]").scrollIntoView(true);
        Assert.assertEquals(text, title.getText());
    }
}
