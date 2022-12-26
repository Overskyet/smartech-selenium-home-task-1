package helper.basepage;

import helper.enums.PageName;
import helper.exception.PageClassNotFoundException;
import org.openqa.selenium.WebDriver;
import page.avtodispetcher.AvtodispetcherDistancePage;

import javax.annotation.Nullable;

public class PageFactoryImpl implements PageFactory{
    private PageFactoryImpl() {}

    private static class PageFactoryImplHolder {
        private final static PageFactoryImpl INSTANCE = new PageFactoryImpl();
    }

    public static PageFactoryImpl getInstance() { return PageFactoryImplHolder.INSTANCE; }

    @Nullable
    @Override
    public BasePage createPage(PageName pageName, WebDriver driver) {
        switch (pageName) {
            case AVTODISPETCHER: return new AvtodispetcherDistancePage(driver);
            default: throw new PageClassNotFoundException("Can't find a Page Class with the name: " + pageName);
        }
    }
}
