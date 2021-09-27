package web.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    // Логгер
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    // Драйвер
    private static WebDriver webDriver;

    // Получение экземпляра драйвера по имени
    public static WebDriver getDriver(BrowserName name) {
        switch (name) {
            // Драйвер браузера Google Chrome
            case CHROME:
                logger.info("Драйвер браузера Google Chrome");
                return ChromeBrowserDriver.getDriver();
            // Драйвер браузера Mozilla Firefox
            case FIREFOX:
                logger.info("Драйвер браузера Mozilla Firefox");
                return FirefoxBrowserDriver.getDriver();
            // Драйвер браузера Microsoft Edge
            case EDGE:
                logger.info("Драйвер браузера Microsoft Edge");
                return EdgeBrowserDriver.getDriver();
            // По умолчанию
            default:
                throw new RuntimeException("Некорректное наименование браузера");
        }
    }

    // Получение уже созданного экземпляра драйвера
    public static WebDriver getCurrentDriver() {
        return webDriver;
    }
}
