import pageObgect.NavigationPOM;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static consts.Constants.URL;

public class NavigateToIngredientsTest {
    protected WebDriver driver = new SelectorOfBrowser().getWebDriver("chrome");

    @Before
    public void beforeMethod() {
        driver.get(URL);
    }

    NavigationPOM element = new NavigationPOM(driver);

    @Test
    @DisplayName("Проверка перехода на соусы")
    public void navigateToSauceCheck() {
        String str = element.navigateToSause();
        Assert.assertEquals("Соусы", str);
    }

    @Test
    @DisplayName("Проверка перехода на начинки")
    public void navigateToFillingCheck() {
        String str = element.navigateToFilling();
        Assert.assertEquals("Начинки", str);
    }

    @Test
    @DisplayName("Проверка перехода на булочки")
    public void navigateToBunsCheck() {
        element.navigateToSause();
        String str = element.navigateToBuns();
        Assert.assertEquals("Булки", str);
    }

    @After
    public void quitFromBrowser() {
        driver.quit();
    }
}
