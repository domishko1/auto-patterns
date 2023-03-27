package xpathLocators.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private final SelenideElement loginField = $x("//form[@id=\"loginform\"]//input[@id=\"user_login\"]");
    private final SelenideElement passwordField = $x("//form[@id=\"loginform\"]//input[@id=\"user_pass\"]");
    private final SelenideElement submit = $x("//div[@class=\"login\"]//p[@class=\"submitl\"]/input[@id=\"wp-submit\"]");

    @Step("Пользователь вводить авторизационные данные, где логин {0} и пароль {1}")
    public AuthPage setDataToLoginBox(String login, String pass) {
        loginField.click();
        loginField.sendKeys(login);
        passwordField.click();
        passwordField.sendKeys(pass);

        return this;
    }

    @Step("Пользователь нажимает кнопку Войти")
    public void clickOnSubmit() {
        submit.click();
    }
}
