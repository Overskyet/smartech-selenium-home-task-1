package helper.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    private final Actions builder;

    public MouseActions(WebDriver driver) {
        this.builder = new Actions(driver);
    }

    /**
     * This method moves the mouse to the middle of the element. The element is also scrolled into the view on performing this action.
     */
    public void moveTo(WebElement element) {
        moveToElement(element);
    }

    /**
     * It will move to the element and clicks (without releasing) in the middle of the given element.
     */
    public void clickAndHold(WebElement element) {
        clickAndHoldElement(element);
    }

    /**
     * This method firstly performs a mouse-move to the location of the element and performs the context-click (right click) on the given element.
     */
    public void contextClick(WebElement element) {
        contextClickOnElement(element);
    }

    /**
     * It will move to the element and performs a double-click in the middle of the given element.
     */
    public void doubleClick(WebElement element) {
        doubleClickOnElement(element);
    }

    /**
     * This method firstly performs a click-and-hold on the source element, moves to the location of the target element and then releases the mouse.
     */
    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        dragAndDropOnElement(sourceElement, targetElement);
    }

    private void moveToElement(WebElement element) {
        builder.moveToElement(element).build().perform();
    }

    private void clickAndHoldElement (WebElement element) {
        builder.clickAndHold(element).build().perform();
    }

    private void contextClickOnElement (WebElement element) {
        builder.contextClick(element).build().perform();
    }

    private void doubleClickOnElement (WebElement element) {
        builder.doubleClick(element).build().perform();
    }

    private void dragAndDropOnElement (WebElement sourceElement, WebElement targetElement) {
        builder.dragAndDrop(sourceElement, targetElement).build().perform();
    }
}
