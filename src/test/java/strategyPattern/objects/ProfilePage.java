package strategyPattern.objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private final SelenideElement actorName = $x("//div[@class=\"akter\"]/h1");

    public String getActorName() {
        return actorName.getText();
    }

}
