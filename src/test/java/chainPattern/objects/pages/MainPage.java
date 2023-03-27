package chainPattern.objects.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта https://ru.wikipedia.org/
 */
public class MainPage {
    private final SelenideElement searchInput = $x("//input[@id=\"searchInput\"]");
    private final SelenideElement searchBtn = $x("//input[@id=\"searchButton\"]");

    public MainPage clickOnSearchInput() {
        searchInput.click();
        return this;
    }

    public MainPage setTextToSearchInput(String text) {
        searchInput.sendKeys(text);
        return this;
    }

    public DetailPage clickOnSearchBtn() {
        searchBtn.click();
        return new DetailPage();
    }
}
