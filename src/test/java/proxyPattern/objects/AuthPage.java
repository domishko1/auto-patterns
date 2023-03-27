package proxyPattern.objects;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage implements SourceInfo{
    private final SelenideElement loginField = $x("//input[@id=\"user_login\"]");
    private final SelenideElement passwordField = $x("//input[@id=\"user_pass\"]");
    private final SelenideElement submit = $x("//input[@id=\"wp-submit\"]");

    public void setDataToLoginBox(String login, String pass) {
        loginField.click();
        loginField.sendKeys(login);
        passwordField.click();
        passwordField.sendKeys(pass);
    }

    public void clickOnSubmit() {
        submit.click();
    }

    @Override
    public String getSource(String pageName) {
        return WebDriverRunner.source();
    }
}
