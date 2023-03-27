package objectPoolPattern.tests;

import com.codeborne.selenide.SelenideElement;
import objectPoolPattern.objects.PooledUser;
import objectPoolPattern.objects.UserPool;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$x;

public class LoginTest extends BaseTest {
    private final SelenideElement loginBtn = $x("//div[@class=\"fullcontent\"]//li/a[1]");
    private final SelenideElement loginField = $x("//input[@id=\"user_login\"]");
    private final SelenideElement passwordField = $x("//input[@id=\"user_pass\"]");
    private final SelenideElement submit = $x("//input[@id=\"wp-submit\"]");
    private final SelenideElement profileLoginName = $x("//ul[@class=\"profile-block1\"]//i");

    private static final UserPool USER_POOL = new UserPool();
    private PooledUser pooledUser;

    @Before
    public void precondition() {
        pooledUser = USER_POOL.getPooledUser();
    }

    @Test
    public void loginTest1() {
        loginBtn.click();
        loginField.click();
        loginField.sendKeys(pooledUser.getLogin());
        passwordField.click();
        passwordField.sendKeys(pooledUser.getPassword());
        submit.click();

        PooledUser pooledUserNew = USER_POOL.getPooledUser();

        Assert.assertNotEquals(pooledUserNew.getLogin(), profileLoginName.getText());
        USER_POOL.releasePooledUser(pooledUserNew);
    }

    @Test
    public void loginTest2() {
        loginBtn.click();
        loginField.click();
        loginField.sendKeys(pooledUser.getLogin());
        passwordField.click();
        passwordField.sendKeys(pooledUser.getPassword());
        submit.click();

        Assert.assertEquals(pooledUser.getLogin(), profileLoginName.getText());
    }

    @Test
    public void loginTest3() {
        loginBtn.click();
        loginField.click();
        loginField.sendKeys(pooledUser.getLogin());
        passwordField.click();
        passwordField.sendKeys(pooledUser.getPassword());
        submit.click();

        Assert.assertEquals(pooledUser.getLogin(), profileLoginName.getText());
    }

    @After
    public void postcondition() {
        USER_POOL.releasePooledUser(pooledUser);
    }
}