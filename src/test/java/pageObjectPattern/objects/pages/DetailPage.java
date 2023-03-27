package pageObjectPattern.objects.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DetailPage {
    private final SelenideElement title = $x("//h1[@id=\"firstHeading\"]");

    public String getTitleText() {
        return title.getText();
    }
}