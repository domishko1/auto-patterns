package xpathLocators.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    private final ElementsCollection searchField = $$x("//div[@class=\"art content\"]/div[@class=\"post-home\"]//span");

    public List<String> getAllDoramaNamesOnPage() {
        return searchField.stream().map(SelenideElement::getText).collect(Collectors.toList());
    }
}
