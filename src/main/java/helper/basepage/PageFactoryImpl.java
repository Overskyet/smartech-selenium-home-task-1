package helper.basepage;

import helper.enums.Page;
import helper.exception.PageClassNotFoundException;
import org.openqa.selenium.WebDriver;
import page.avtodispetcher.AvtodispetcherDistancePage;
import page.avtodispetcher.AvtodispetcherResultPage;
import page.yandex.YandexResultPage;
import page.yandex.YandexSearchPage;

public class PageFactoryImpl implements PageFactory{
    private PageFactoryImpl() {}

    private static class PageFactoryImplHolder {
        private final static PageFactoryImpl INSTANCE = new PageFactoryImpl();
    }

    public static PageFactoryImpl getInstance() { return PageFactoryImplHolder.INSTANCE; }

    @Override
    public BasePage createPage(Page pageName, WebDriver driver) {
        switch (pageName) {
            case AVTODISPETCHER_DISTANCE: return new AvtodispetcherDistancePage(driver);
            case AVTODISPETCHER_RESULT: return new AvtodispetcherResultPage(driver);
            case YANDEX_SEARCH: return new YandexSearchPage(driver);
            case YANDEX_SEARCH_RESULT: return new YandexResultPage(driver);
            default: throw new PageClassNotFoundException("Can't find a Page Class with the name: " + pageName);
        }
    }
}
