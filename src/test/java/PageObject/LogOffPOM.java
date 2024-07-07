package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import com.github.javafaker.Faker;
import Consts.Constants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOffPOM {

    WebDriver driver;

    public LogOffPOM(WebDriver driver) {
        this.driver = driver;
    }

    public static final By loginButton = By.xpath(".//*[@href=\"/account\"]");
    public static final By exitButton = By.xpath(".//*[text()='Выход']");
    public static final By name = By.xpath(".//*[@name=\"name\" and @class=\"text input__textfield text_type_main-default\" and @type=\"text\"][1]");
    public static final By email = By.xpath(".//input[@class=\"text input__textfield text_type_main-default\" and @type=\"text\"]");
    public static final By password = By.xpath(".//input[@class=\"text input__textfield text_type_main-default\" and @type=\"password\"]");
    public static final By buttonLogin = By.xpath(".//*[text()='Войти']");
    public static final By buttonLoginOnPersonalAccount = By.xpath(".//*[@class= 'AppHeader_header__link__3D_hX' and @href='/account']");
    public static final By buttonAfterExit = By.xpath(".//*[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    @Step("Нажать на личный кабинет")
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }
    @Step("Ввести статичные данные для входа")
    public void fillingStaticCredentialsForLogin() {
        driver.findElement(email).click();
        driver.findElement(email).sendKeys(Constants.staticEmail);
        driver.findElement(password).sendKeys(Constants.staticPassword);
    }
    @Step("Нажать кнопку войти")
    public void clickOnLoginIntoSystemButton() {
        driver.findElement(buttonLogin).click();
    }
    @Step("Нажать на кнопку Личный кабинет")
    public void clickOnLoginOnPersonalAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(700))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLoginOnPersonalAccount));
        driver.findElement(buttonLoginOnPersonalAccount).click();
    }
    @Step("Подождать пока кнопка выход не станет доступна")
    public void waitingUntilElementExitIsReady() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(exitButton));
    }
    @Step("Нажать на кнопку выход")
    public void clickOnExitButton(){
        driver.findElement(exitButton).click();
    }
    @Step("Проверка кнопки войти после выхода из профиля")
    public boolean checkLoginButtonAfterExitExist() {
        return driver.findElement(buttonAfterExit).isEnabled();
    }

}
