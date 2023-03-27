package strategyPattern.objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TrueBeautySearchStrategy implements SearchStrategy {
    private final SelenideElement searchField = $x("//input[@name=\"s\"]");
    private final SelenideElement searchBtn = $x("//input[@class=\"art-search-button\"]");
    private final SelenideElement title = $x("//a[@href=\"https://doramy.club/23650-68-istinnaya-krasota.html\"]");
    private final SelenideElement searchName = $x("//a[@href=\"https://doramy.club/akter/kan-min-a\"]");

    @Override
    public void search() {
        searchField.click();
        searchField.sendKeys("Истинная красота");
        searchBtn.click();
        title.click();
        searchName.click();
    }
}
