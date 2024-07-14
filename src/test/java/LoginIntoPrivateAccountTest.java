import pageObgect.LoginPagePOM;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static consts.Constants.URL;

public class LoginIntoPrivateAccountTest {
    protected WebDriver driver = new SelectorOfBrowser().getWebDriver("chrome");

    @Before
    public void beforeMethod() {
        driver.get(URL);
    }

    LoginPagePOM element = new LoginPagePOM(driver);

    @Test
    @DisplayName("Проверка перехода на личный кабинет")
    public void navigationOnPrivateAccountCheck() {
        element.clickOnLoginButton();
        element.fillingStaticCredentialsForLogin();
        element.clickOnLoginIntoSystemButton();
        element.clickOnLoginOnPersonalAccount();
        Assert.assertTrue(element.privateAccountLinkCheck());
    }

    @Test
    @DisplayName("Проверка перехода на логотип из личного кабинета")
    public void navigationOnBurgerLogo() {
        element.clickOnLoginButton();
        element.fillingStaticCredentialsForLogin();
        element.clickOnLoginIntoSystemButton();
        element.clickOnLoginOnPersonalAccount();
        element.clickOnLogo();
        Assert.assertTrue(element.orderButtonCheck());
    }

    @Test
    @DisplayName("Проверка перехода на конструктор")
    public void navigationOnCreateBurger() {
        element.clickOnLoginButton();
        element.fillingStaticCredentialsForLogin();
        element.clickOnLoginIntoSystemButton();
        element.clickOnLoginOnPersonalAccount();
        element.clickOnCreateBurger();
        Assert.assertTrue(element.orderButtonCheck());
    }

    @After
    public void quitFromBrowser() {
        driver.quit();
    }

}
