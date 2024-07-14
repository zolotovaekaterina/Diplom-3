import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorOfBrowser {
    public WebDriver getWebDriver(String browser){

        switch (browser){
            case "chrome":
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.gecko.driver", "/Users/ekaterina/WebDriver/geckodriver");
                return new ChromeDriver();
            default:
                throw new RuntimeException("invalid browser name");
        }

}}
