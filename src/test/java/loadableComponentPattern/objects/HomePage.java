package loadableComponentPattern.objects;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends LoadableComponent<HomePage> {
    // region unauth block /////////////////////////////////////////////////////
    private final SelenideElement loginBtn = $x("//div[@class=\"fullcontent\"]//li/a[1]");
    private final SelenideElement registerBtn = $x("//div[@class=\"fullcontent\"]//li/a[2]");
    private final SelenideElement logo = $x("//ul[@class=\"logo\"]");
    // endregion

    // region auth block /////////////////////////////////////////////////////
    private final SelenideElement profileName = $x("//ul[@class=\"profile-block1\"]/li[2]");
    // endregion

    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    public String getProfileName() {
        return profileName.getText();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("Home page logo is displayed!");
    }
}
