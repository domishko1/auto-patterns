package assertObjectPattern.objects.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // region unauth block /////////////////////////////////////////////////////
    private final SelenideElement loginBtn = $x("//div[@class=\"fullcontent\"]//li/a[1]");
    private final SelenideElement registerBtn = $x("//div[@class=\"fullcontent\"]//li/a[2]");
    // endregion

    // region auth block /////////////////////////////////////////////////////
    private final SelenideElement profileName = $x("//ul[@class=\"profile-block1\"]/li[2]");
    private final SelenideElement profileBtn = $x("//ul[@class=\"profile-block1\"]/li[1]");

    // endregion

    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    public String getProfileName() {
        return profileName.getText();
    }

    public void goToProfile() {
        profileBtn.click();
    }
}
