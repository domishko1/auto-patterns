package pageObjectPattern.objects.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта https://ru.wikipedia.org/
 */
public class MainPage {
    private final SelenideElement searchInput = $x("//input[@id=\"searchInput\"]");
    private final SelenideElement searchBtn = $x("//input[@id=\"searchButton\"]");

    public void clickOnSearchInput() {
        searchInput.click();
    }

    public void setTextToSearchInput(String text) {
        searchInput.sendKeys(text);
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }
}
