package tests.web;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.TestData;


@Owner("Мария Валишева")
@Tag("WEB")
@Epic("Разработка функционала главной страницы")
@DisplayName("Тесты на главной странице")
public class MainPageTests extends WebTestBase {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    TestData testData = new TestData();


    @Feature("Поиск")
    @Story("Функционал поиска на главной странице")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест на поиск по ключевому слову")
    @Test
    void searchByKeyWordsTest() {
        mainPage
                .searchByKeyWord(testData.keyWord);

        searchResultPage
                .checkSearchResult("По запросу «"
                        + testData.keyWord + "» мы нашли", 1);
    }

    @Feature("Поиск")
    @Story("Функционал поиска на главной странице")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Тест на поиск по каталогу")
    @Test
    void searchInCatalogTest() {
        mainPage
                .closeLocationPopUp()
                .searchInCatalog(testData.searchWord);

        searchResultPage
                .checkCatalogSearchResult(testData.searchWord);
    }

    @Feature("Локация")
    @Story("Функционал выбора локации")
    @Severity(SeverityLevel.NORMAL)
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



