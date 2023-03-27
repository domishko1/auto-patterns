package xpathLocators.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private final SelenideElement searchField = $x("//form[@class=\"art-search\"]/input[@name=\"s\"]");
    private final SelenideElement searchBtn = $x("//form[@class=\"art-search\"]/input[@class=\"art-search-button\"]");


    // region unauth block /////////////////////////////////////////////////////
    private final SelenideElement loginBtn = $x("//ul[@class=\"profile-block\"]//a[@href=\"/regs-login\"]");
    // endregion

    // region auth block /////////////////////////////////////////////////////
    private final SelenideElement profileName = $x("//ul[@class=\"profile-block1\"]/li[following::*][2]");
    // endregion

    @Step("Пользователь нажимает кнопку Войти")
    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    @Step("Пользователь нажимает на строку поиска")
    public HomePage clickOnSearchField() {
        searchField.click();
        return this;
    }

    @Step("Пользователь вводит в строку поиска текст {0}")
    public HomePage sendTextToSearchField(String text) {
        searchField.sendKeys(text);
        return this;
    }

    @Step("Пользователь нажимает кнопку Поиск")
    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    @Step("Пользователь фокусирует внимание на имени в авторизованном профиле")
    public String getAuthUserName() {
        return profileName.getText();
    }
}
