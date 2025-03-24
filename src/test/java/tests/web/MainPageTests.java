package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.TestData;



@DisplayName("Тесты на главной странице")
public class MainPageTests extends WebTestBase {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    TestData testData = new TestData();


    @DisplayName("Тест на поиск по ключевому слову")
    @Test
    void searchByKeyWordsTest() {
        mainPage
                .searchByKeyWord(testData.keyWord);

        searchResultPage
                .checkSearchResult("По запросу «"
                        + testData.keyWord + "» мы нашли", 1);
    }

    @DisplayName("Тест на поиск по каталогу")
    @Test
    void searchInCatalogTest() {
        mainPage
                .closeLocationPopUp()
                .searchInCatalog(testData.searchWord);

        searchResultPage
                .checkCatalogSearchResult(testData.searchWord);
    }

    @DisplayName("Тест на выбор города на главной странице")
    @Test
    void chooseCityTest() {
        CityPage cityPage = new CityPage();
        cityPage
                .clickOnYourCity()
                .chooseRandomCity(testData.chooseCity)
                .checkChosenCity(testData.chooseCity);
    }
}



