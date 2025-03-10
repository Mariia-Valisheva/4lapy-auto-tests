package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.TestGeneratedData;


@Tag("SMOKE")
@DisplayName("Тесты на главной странице")
public class MainPageTests extends FourLapyUiTestBase {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    TestGeneratedData generatedData = new TestGeneratedData();

    //готово
    @DisplayName("Тест на поиск по ключевому слову")
    @Test
    void searchByKeyWordsTest() {
        mainPage
                .searchByKeyWord(generatedData.keyWord);

        searchResultPage
                .checkSearchResult("По запросу «"
                        + generatedData.keyWord + "» мы нашли", 1);
    }

//переделать
    @DisplayName("Тест на поиск по каталогу")
    @Test
    void searchInCatalogTest() {
        mainPage
                .closeLocationPopUp()
                .searchInCatalog(generatedData.searchWord);

        searchResultPage
                .checkCatalogSearchResult(generatedData.searchWord);
    }
}


