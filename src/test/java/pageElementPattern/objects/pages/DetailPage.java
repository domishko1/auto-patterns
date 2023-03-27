package pageElementPattern.objects.pages;

import pageElementPattern.objects.widgets.HeadWidget;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DetailPage {
    private final SelenideElement title = $x("//h1[@id=\"firstHeading\"]");

    public String getTitleText() {
        return title.getText();
    }

    public HeadWidget getHeadWidget() {
        return new HeadWidget();
    }
}