package assertObjectPattern.objects.pages;

import assertObjectPattern.objects.entities.User;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private final SelenideElement login = $x("//table[@class=\"form-table\"]//tr[1]//th[2]");
    private final SelenideElement email = $x("//table[@class=\"form-table\"]//tr[2]//th[2]");

    public User getUserData() {
        return new User(login.getText(), "", email.getText());
    }
}
