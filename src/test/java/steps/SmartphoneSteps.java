package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.pages.SmartphoneProductPage;
import web.pages.SmartphonesPage;
import web.pages.StartPage;

// Шаги
public class SmartphoneSteps {
    // Логгер
    private Logger logger = LogManager.getLogger(SmartphoneSteps.class);

    // Страницы
    StartPage startPage;
    SmartphonesPage smartphonesPage;
    SmartphoneProductPage smartphoneProductPage;

    @Дано("Открыта Главная страница ДНС")
    public void startDriverAndOpenStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        smartphonesPage = new SmartphonesPage(WebDriverFactory.getCurrentDriver());
        smartphoneProductPage = new SmartphoneProductPage(WebDriverFactory.getCurrentDriver());

        // Открыть страницу https://www.dns-shop.ru/
        WebDriverFactory.getCurrentDriver().get("https://www.dns-shop.ru/");
        logger.info("Открыта Стартовая страница сайта DNS");
    }

    @Когда("Выполнен переход на страницу Смартфоны")
    public void openSmartphonesPage() {
        startPage.linkYes().click();
        startPage.linkSmartsAndGadget().focusOnLink();
        startPage.linkSmarts().click();
        logger.info("Выполнен переход на страницу Смартфоны");
    }

    @Тогда("Проверить: В заголовке страницы отображается текст Смартфоны")
    public void assertTitle() {
        // Проверка заголовка страницы
        logger.info("Проверка заголовка страницы");
        Assertions.assertTrue(smartphonesPage.getPageTitle().contains("Смартфоны"),
                "В заголовке страницы не отображается текст Смартфоны");
    }
}
