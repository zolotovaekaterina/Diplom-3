package PageObject;

import com.github.javafaker.Faker;
import Consts.Constants;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPagePOM {

    WebDriver driver;

    public LoginPagePOM(WebDriver driver) {
        this.driver = driver;
    }

    public static final By loginButton = By.xpath(".//*[@href=\"/account\"]");
    public static final By registerButton = By.xpath(".//*[@href=\"/register\"]");
    public static final By name = By.xpath(".//*[@name=\"name\" and @class=\"text input__textfield text_type_main-default\" and @type=\"text\"][1]");
    public static final By email = By.xpath(".//input[@class=\"text input__textfield text_type_main-default\" and @type=\"text\"]");
    public static final By password = By.xpath(".//input[@class=\"text input__textfield text_type_main-default\" and @type=\"password\"]");
    public static final By registerButtonOnRegisterPage = By.xpath(".//*[text()=\"Зарегистрироваться\"]");
    public static final By wrongPasswordMessage = By.xpath(".//*[text()=\"Некорректный пароль\"]");
    public static final By buttonLogin = By.xpath(".//*[text()='Войти']");
    public static final By buttonLoginOnPersonalAccount = By.xpath(".//*[@class= 'AppHeader_header__link__3D_hX' and @href='/account']");
    public static final By textFromPrivateAccount = By.xpath(".//*[@class='Auth_login__3hAey']");
    public static final By logo = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']/a");
    public static final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    public static final By createOfBurgerButton =  By.xpath(".//*[@class='AppHeader_header__link__3D_hX']");
    public static final By loginOnMainPage = By.xpath(".//*[text()='Войти в аккаунт']");
    public static final By buttonResetYourPassword = By.xpath(".//*[@class=\"Auth_link__1fOlj\" and @href=\"/forgot-password\"]");
    public static final By loginButtonInResetPassword = By.xpath(".//*[text()='Войти']");

    @Step("Нажать на личный кабинет")
    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }
    @Step("Нажать на регистрация")
    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }
    static Faker faker = new Faker();
    @Step("Заполнить нужные параметры")
    public void fillRequiredParams() {

        driver.findElement(name).sendKeys(faker.name().firstName()+"va");
        driver.findElements(email).get(1).sendKeys(faker.name().lastName()+"@mail.com");
        driver.findElement(password).sendKeys(Constants.password);
    }

    @Step("Заполнить нужные параметры")
    public void fillRequiredParamsForNewTest() {

        driver.findElement(name).sendKeys(faker.name().firstName()+"vad");
        driver.findElements(email).get(1).sendKeys(faker.name().lastName()+"@gmail.com");
        driver.findElement(password).sendKeys(Constants.password);
    }

    @Step("Нажать на зарегистрироваться")
    public void pressRegisterButton() {
        driver.findElement(registerButtonOnRegisterPage).click();
    }

    public void fillWrongRequiredParams() {
        driver.findElement(name).sendKeys(Constants.name);
        driver.findElements(email).get(1).sendKeys(Constants.email);
        driver.findElement(password).sendKeys(Constants.wrongPassword);

    }

    @Step("Проверить что кнопка войти теперь активна после заполнения всех параметров")
    public boolean loginButtonCheck() {
        return driver.findElements(buttonLogin).isEmpty();
    }

    public boolean findWrongMessage() {
        return driver.findElements(wrongPasswordMessage).isEmpty();
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
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLoginOnPersonalAccount));
        driver.findElement(buttonLoginOnPersonalAccount).click();
    }

    public boolean privateAccountLinkCheck() {
       return  driver.findElements(textFromPrivateAccount).isEmpty();

    }
    @Step("Нажать на логотип")
    public void clickOnLogo() {
        driver.findElement(logo).click();
    }
    @Step("Проверить что кнопка оформить заказ доступна")
    public boolean orderButtonCheck() {
        return driver.findElement(createOrderButton).isEnabled();
    }
    @Step("Нажать на конструктор")
    public void clickOnCreateBurger(){
        driver.findElements(createOfBurgerButton).get(0).click();
    }
    @Step("Нажать на войти в аккаунт")
    public void clickOnLoginOnMainPage() {
        driver.findElement(loginOnMainPage).click();
    }
    @Step("Проверить что кнопка войти в аккаунт доступна")
    public boolean checkLoginButtonOnMainPage() {
        return driver.findElement(buttonLogin).isEnabled();
    }

    @Step("Подождать пока элемент восстановить пароль будет прогружен")
    public void waitingUntilElementIsReady() {
        new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions.elementToBeClickable(buttonResetYourPassword));
    }
    @Step("Нажать на восстановить пароль")
    public void clickOnResetYourPasswordButton() {
        driver.findElement(buttonResetYourPassword).click();
    }
    @Step("Проверить что кнопка войти будет доступна в восстановить пароль")
    public boolean checkLoginButtonInResetPasswordForm() {
        return driver.findElement(loginButtonInResetPassword).isEnabled();
    }





}
