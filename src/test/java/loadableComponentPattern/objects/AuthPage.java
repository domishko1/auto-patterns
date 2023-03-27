package loadableComponentPattern.objects;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import valueObjectPattern.objects.entities.User;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage extends LoadableComponent<AuthPage> {
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
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(submit.isDisplayed());
        System.out.println("Auth page submit button is displayed!");
    }
}
