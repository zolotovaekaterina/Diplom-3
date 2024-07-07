package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPOM {
    WebDriver driver;

    public NavigationPOM(WebDriver driver) {
        this.driver = driver;
    }

    public static final By sections = By.xpath(".//*[@class='text text_type_main-default']");
    public static final By activeSause = By.xpath(".//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    @Step("Снавигироваться на соусы")
    public String navigateToSause(){
        driver.findElements(sections).get(1).click();
        return driver.findElement(activeSause).getText();
    }
    @Step("Снавигироваться на начинки")
    public String navigateToFilling(){
        driver.findElements(sections).get(2).click();
        return driver.findElement(activeSause).getText();
    }
    @Step("Снавигироваться на булочки")
    public String navigateToBuns(){
        driver.findElements(sections).get(0).click();
        return driver.findElement(activeSause).getText();
    }
}
