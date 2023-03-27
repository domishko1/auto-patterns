package cssLocators.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private final ElementsCollection searchField = $$("div.post-home span");

    public List<String> getAllDoramaNamesOnPage() {
        return searchField.stream().map(SelenideElement::getText).collect(Collectors.toList());
    }
}
