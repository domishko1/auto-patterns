package builderPattern.objects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Filter {
    private final SelenideElement section = $x("//select[@name='razdel']");
    private final SelenideElement country = $x("//select[@name='tax_strana']");
    private final SelenideElement filterBtn = $x("//div[@class=\"navi-m\"]");
    private final SelenideElement submitBtn = $x("//button[@type='submit']");

    public static class ClassicFilterBuilder implements FilterBuilder {

        public String section = "";
        public String country = "";

        public ClassicFilterBuilder(){
            super();
        }

        @Override
        public FilterBuilder setSection(String section) {
            this.section = section;
            return this;
        }

        @Override
        public FilterBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        @Override
        public Filter build() {
            return  new Filter(this);
        }
    }

    public Filter(ClassicFilterBuilder builder) {
        filterBtn.click();
        if (!builder.section.isEmpty()) {
            section.click();
            SelenideElement element = $x("//select[@name='razdel']//*[contains(text(),'" + builder.section + "')]");
            element.click();
        }
        if (!builder.country.isEmpty()) {
            country.click();
            SelenideElement element = $x("//select[@name='tax_strana']//*[contains(text(),'" + builder.country + "')]");
            element.click();
        }
        submitBtn.click();
    }
}
