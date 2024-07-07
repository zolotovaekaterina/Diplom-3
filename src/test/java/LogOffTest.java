import PageObject.LogOffPOM;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import static Consts.Constants.URL;

public class LogOffTest {

    protected WebDriver driver = new SelectorOfBrowser().getWebDriver("chrome");

    @Before
    public void beforeMethod() {
         driver.get(URL);
    }
    LogOffPOM element = new LogOffPOM(driver);
    @Test
    @DisplayName("Проверка выхода из пользователя")
    public void logoffTest() {
        element.clickOnLoginButton();
        element.fillingStaticCredentialsForLogin();
        element.clickOnLoginIntoSystemButton();
        element.clickOnLoginOnPersonalAccount();
        element.waitingUntilElementExitIsReady();
        element.clickOnExitButton();
        Assert.assertTrue(element.checkLoginButtonAfterExitExist());
    }

    @After
    public void quitFromBrowser() {
        driver.quit();
    }
}
