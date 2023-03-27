package pageElementPattern.objects.widgets;

import chainPattern.objects.pages.DetailPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HeadWidget {
    private final SelenideElement searchInput = $x("//input[@id=\"searchInput\"]");
    private final SelenideElement searchBtn = $x("//input[@id=\"searchButton\"]");

    public HeadWidget clickOnSearchInput() {
        searchInput.click();
        return this;
    }

    public HeadWidget setTextToSearchInput(String text) {
        searchInput.sendKeys(text);
        return this;
    }

    public DetailPage clickOnSearchBtn() {
        searchBtn.click();
        return new DetailPage();
    }
}
