package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProductCardPage;
import utils.TestData;


@DisplayName("Тесты на проверку карточки товара")
public class ProductCardTest extends WebTestBase {

    MainPage mainPage = new MainPage();
    ProductCardPage productCardPage = new ProductCardPage();
    TestData generatedData = new TestData();

    @DisplayName("Тест на отображение отзывов у товара")
    @Test
    void checkReviewTest() {

        mainPage
                .searchByKeyWord(generatedData.keyWord);

        productCardPage
                .clickOnProductCard()
                .goToReviews()
                .checkReviewsVisible(0);
    }
}
