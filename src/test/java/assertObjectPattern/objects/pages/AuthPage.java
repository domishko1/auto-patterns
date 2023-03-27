package assertObjectPattern.objects.pages;

import com.codeborne.selenide.SelenideElement;
import assertObjectPattern.objects.entities.User;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private final SelenideElement loginField = $x("//input[@id=\"user_login\"]");
    private final SelenideElement passwordField = $x("//input[@id=\"user_pass\"]");
    private final SelenideElement submit = $x("//input[@id=\"wp-submit\"]");

    public void setDataToLoginBox(User user) {
        loginField.click();
        loginField.sendKeys(user.getLogin());
        passwordField.click();
        passwordField.sendKeys(user.getPassword());
    }

    public void clickOnSubmit() {
        submit.click();
    }
}