package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProductCardPage;
import utils.TestGeneratedData;


public class ProductCardTest extends UiTestBase {

    MainPage mainPage = new MainPage();
    ProductCardPage productCardPage = new ProductCardPage();
    TestGeneratedData generatedData = new TestGeneratedData();

//готово
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
