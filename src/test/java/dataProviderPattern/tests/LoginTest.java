package dataProviderPattern.tests;

import com.codeborne.selenide.SelenideElement;
import dataProviderPattern.objects.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class LoginTest extends BaseTest {

    private final SelenideElement loginBtn = $x("//div[@class=\"fullcontent\"]//li/a[1]");
    private final SelenideElement loginField = $x("//input[@id=\"user_login\"]");
    private final SelenideElement passwordField = $x("//input[@id=\"user_pass\"]");
    private final SelenideElement submit = $x("//input[@id=\"wp-submit\"]");
    private final SelenideElement profileLoginName = $x("//ul[@class=\"profile-block1\"]//i");

    @Test
    public void loginTest() {
        List<String> data = FileUtil.getRandomLoginDataFromFile();

        loginBtn.click();
        loginField.click();
        loginField.sendKeys(data.get(0));
        passwordField.click();
        passwordField.sendKeys(data.get(1));
        submit.click();

        Assert.assertEquals(data.get(0), profileLoginName.getText());
    }
}
