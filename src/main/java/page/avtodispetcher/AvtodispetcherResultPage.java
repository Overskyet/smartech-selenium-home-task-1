package page.avtodispetcher;

import helper.action.PageActions;
import helper.locator.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AvtodispetcherResultPage extends PageActions {

    private final ObjectRepository objRepo = new ObjectRepository("object_repo.properties");
    private final By totalDistance = objRepo.getLocator("avtodispetcher.resultPage.field.totalDistance.xpath");
    private final By totalAmount = objRepo.getLocator("avtodispetcher.resultPage.field.totalAmount.xpath");

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
