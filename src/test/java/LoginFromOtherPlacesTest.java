import pageObgect.LoginPagePOM;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static consts.Constants.URL;

public class LoginFromOtherPlacesTest {

    protected WebDriver driver = new SelectorOfBrowser().getWebDriver("chrome");

    @Before
    public void beforeMethod() {
        driver.get(URL);
    }

    LoginPagePOM element = new LoginPagePOM(driver);

    @Test
    @DisplayName("Проверка кнопки войти с главной страницы")
    public void loginOnMainPage() {
        element.clickOnLoginOnMainPage();
        Assert.assertTrue(element.checkLoginButtonOnMainPage());
    }

    @Test
    @DisplayName("Проверка кнопки войти с личного кабинета")
    public void loginByPersonalAccount() {
        element.clickOnLoginOnPersonalAccount();
        Assert.assertTrue(element.checkLoginButtonOnMainPage());
    }

    @Test
    @DisplayName("Проверка кнопки войти с формы регистрации")
    public void loginByRegistrationForm() {
        element.clickOnLoginButton();
        element.clickOnRegisterButton();
        element.fillRequiredParams();
        element.pressRegisterButton();
        Assert.assertTrue(element.checkLoginButtonOnMainPage());
    }

    @Test
    @DisplayName("Проверка кнопки войти с формы восстановить пароль")
    public void loginByResetYourPasswordForm() {
        element.clickOnLoginButton();
        element.clickOnRegisterButton();
        element.fillRequiredParamsForNewTest();
        element.pressRegisterButton();
        element.waitingUntilElementIsReady();
        element.clickOnResetYourPasswordButton();
        Assert.assertTrue(element.checkLoginButtonInResetPasswordForm());

    }

    @After
    public void quitFromBrowser() {
        driver.quit();
    }

}
