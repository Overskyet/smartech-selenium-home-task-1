package page.avtodispetcher;

import helper.basepage.BasePage;
import helper.config.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AvtodispetcherResultPage extends BasePage {

    private final Locators objRepo = new Locators();
    private final By totalDistance = objRepo.getLocator("avtodispetcher.resultPage.field.totalDistance");
    private final By totalAmount = objRepo.getLocator("avtodispetcher.resultPage.field.totalAmount");

    public AvtodispetcherResultPage(WebDriver driver) {
        super(driver);
    }

    public By getTotalDistance() {
        return totalDistance;
    }
    public By getTotalAmount() {
        return totalAmount;
    }

}
