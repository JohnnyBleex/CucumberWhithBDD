package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class DropDownMenu extends BaseElement{
    public DropDownMenu(WebElement webElement) {
        super(webElement);
    }

    // Раскрытие гармошки
    public void show() {
        // Ожидание кликабельности гармошки
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
