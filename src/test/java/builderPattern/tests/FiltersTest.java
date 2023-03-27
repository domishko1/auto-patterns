package builderPattern.tests;

import builderPattern.objects.Filter;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FiltersTest extends BaseTest {
    public final String section = "Сериалы";
    public final String country = "Китай";

    @Test
    public  void checkCountryFilter() {

        Filter filter = new Filter.ClassicFilterBuilder()
                .setCountry(country)
                .build();

        $x("//div[@class=\"post-home\"]").scrollIntoView(true);
        List<String> list =
                $$x("//tbody/tr[2]/td[2]").stream().map(SelenideElement::getText).collect(Collectors.toList());
        assertThat(list).asList().allMatch(s -> s.toString().contains(country));
    }

    @Test
    public  void checkSectionFilter() {

        Filter filter = new Filter.ClassicFilterBuilder()
                .setSection(section)
                .build();

        $x("//div[@class=\"post-home\"]").scrollIntoView(true);
        List<String> listSection =
                $$x("//tbody/tr[1]/td[1]").stream().map(SelenideElement::getText).collect(Collectors.toList());
        assertThat(listSection).asList().allMatch(s -> s.toString().contains("Сериал"));
    }

    @Test
    public  void checkSectionAndCountryFilter() {

        Filter filter = new Filter.ClassicFilterBuilder()
                .setSection(section)
                .setCountry(country)
                .build();

        $x("//div[@class=\"post-home\"]").scrollIntoView(true);
        List<String> listCountry =
                $$x("//tbody/tr[2]/td[2]").stream().map(SelenideElement::getText).collect(Collectors.toList());
        assertThat(listCountry).asList().allMatch(s -> s.toString().contains(country));

        List<String> listSection =
                $$x("//tbody/tr[1]/td[1]").stream().map(SelenideElement::getText).collect(Collectors.toList());
        assertThat(listSection).asList().allMatch(s -> s.toString().contains("Сериал"));
    }
}
