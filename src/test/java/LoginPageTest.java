import pageObgect.LoginPagePOM;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static consts.Constants.URL;

public class LoginPageTest {

    protected WebDriver driver = new SelectorOfBrowser().getWebDriver("chrome");

    @Before
    public void beforeMethod() {
        driver.get(URL);
    }

    LoginPagePOM element = new LoginPagePOM(driver);


    @Test
    @DisplayName("Проверка успешного создания пользователя")
    public void successfullyLoginIntoSystemTest() {
        element.clickOnLoginButton();
        element.clickOnRegisterButton();
        element.fillRequiredParams();
        element.pressRegisterButton();
        Assert.assertTrue(element.loginButtonCheck());
    }

    @Test
    @DisplayName("Проверка создания пользователя с паролем меньше 6ти символов")
    public void failedLoginIntoSystemTest() {
        element.clickOnLoginButton();
        element.clickOnRegisterButton();
        element.fillWrongRequiredParams();
        element.pressRegisterButton();
        Assert.assertFalse(element.findWrongMessage());
    }

    @After
    public void quitFromBrowser() {
        driver.quit();
    }


}
