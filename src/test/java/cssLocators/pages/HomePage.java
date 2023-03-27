package cssLocators.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement searchField = $("form.art-search input");
    private final SelenideElement searchBtn = $("form.art-search input.art-search-button");


    // region unauth block /////////////////////////////////////////////////////
    private final SelenideElement loginBtn = $("ul.profile-block a[href='/regs-login']");
    private final SelenideElement registerBtn = $("ul.profile-block a[href='/regs-register']");
    private final SelenideElement logo = $("ul.logo");
    // endregion

    // region auth block /////////////////////////////////////////////////////
    private final SelenideElement profileName = $("ul.profile-block1 li:nth-child(2)");
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
