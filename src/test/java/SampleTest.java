import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.avtodispetcher.AvtodispetcherMainPage;
import page.avtodispetcher.AvtodispetcherResultPage;
import page.yandex.YandexResultPage;
import page.yandex.YandexSearchPage;

public class SampleTest extends BaseTest {

    @Test
    public void sampleFirstTestScenario() {
        YandexSearchPage searchPage = new YandexSearchPage(driver);
        searchPage.visit("https://yandex.ru/");
        searchPage.hightlightElement(searchPage.getHomeLogo(), 5L);

        YandexResultPage resultPage = new YandexResultPage(driver);
        resultPage.visit("https://yandex.ru/search/?lr=15&oprnd=9585134529&text=dfds");
    }

    @Test
    public void sampleSecondTestScenario() {
        AvtodispetcherMainPage mainPage = new AvtodispetcherMainPage(driver);
        mainPage.visit("https://www.avtodispetcher.ru/distance/");

        AvtodispetcherResultPage resultPage = new AvtodispetcherResultPage(driver);
        resultPage.visit("https://www.avtodispetcher.ru/distance/?from=%D0%A2%D1%83%D0%BB%D0%B0&to=%D0%A1%D0%B0%D0%BD%D0%BA%D1%82-%D0%9F%D0%B5%D1%82%D0%B5%D1%80%D0%B1%D1%83%D1%80%D0%B3&v=&vt=car&rm=110&rp=90&rs=60&ru=40&fc=9&fp=42&ov=&atn=&aup=&atr=&afd=&ab=&acb=");
    }
}
