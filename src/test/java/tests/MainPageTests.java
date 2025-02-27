package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.FourLapyGeneratedData;


@Tag("SMOKE")
@DisplayName("Тесты для сайта Четыре Лапы")
public class MainPageTests extends FourLapyUiTestBase {

    FourLapyiMainPage mainPage = new FourLapyiMainPage();
    FourLapySearchResultPage searchResultPage = new FourLapySearchResultPage();
    FourLapySalesPage salesPage = new FourLapySalesPage();
    FourLapyGeneratedData generatedData = new FourLapyGeneratedData();
    FourLapyCatsPage catsPage = new FourLapyCatsPage();
    FourLapyDogsPage dogsPage = new FourLapyDogsPage();
    FourLapyFishPage fishPage = new FourLapyFishPage();
    FourLapyBirdsPage birdsPage = new FourLapyBirdsPage();
    FourLapyRodentsPage rodentsPage = new FourLapyRodentsPage();

    @DisplayName("Тест на поиск по ключевому слову")
    @Test
    void searchByKeyWordsTest() {
        mainPage
                .searchByKeyWord(generatedData.keyWord);

        searchResultPage
                .checkSearchResult("По запросу «"
                        + generatedData.keyWord + "» мы нашли", 1);
    }


    @DisplayName("Тест на поиск по каталогу")
    @Test
    void searchInCatalogTest() {
        mainPage
                .closeLocationPopUp()
                .searchInCatalog("Сухой корм");

        searchResultPage
                .checkCatalogSearchResult("Сухой корм для кошек и котов");
    }


    @DisplayName("Тест на работу табов")
    @Test
    void searchByTabsTest() {
        mainPage
                .closeLocationPopUp()
                .clickOnTab("акции");

        salesPage
                .checkPageTitle("Акции и спецпредложения");

        mainPage
                .clickOnTab("кошки");

        catsPage
                .checkPageTitle("Товары для кошек");

        mainPage
                .clickOnTab("собаки");

        dogsPage
                .checkPageTitle("Товары для собак");

        mainPage
                .clickOnTab("рыбы");

        fishPage
                .checkPageTitle("Товары для аквариумистики");

        mainPage
                .clickOnTab("грызуны");

        rodentsPage
                .checkPageTitle("Товары для грызунов и хорьков");

        mainPage
                .clickOnTab("птицы");

        birdsPage
                .checkPageTitle("Товары для птиц");
    }
}