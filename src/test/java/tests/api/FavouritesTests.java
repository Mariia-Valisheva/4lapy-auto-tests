package tests.api;

import api.AddToFavouriteWithoutLogin;
import api.GetFavouritesWithoutLogin;
import helpers.TestVariables;
import io.qameta.allure.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.AddToFavouriteRequest;
import models.AddToFavouriteResponse;
import models.GetFavouriteResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.RequestSpec;
import specs.ResponseSpec;
import utils.TestData;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Мария Валишева")
@Tag("API")
@Epic("Разработка функционала Избранное и Корзина")
@DisplayName("Тесты на работу с избранным")
public class FavouritesTests extends ApiTestBase {

    TestData testData = new TestData();
    TestVariables testVariables = new TestVariables();
    String token = testVariables.getToken();
    RequestSpecification requestSpecification = new RequestSpec().baseRequestAuthSpec(token);
    AddToFavouriteRequest addToFavouriteRequest = new AddToFavouriteRequest(testData.skuId);

    @Story("Функционал работы с избранным")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест на добавление товара в избранное")
    @Test
    void addToFavouriteWithoutLoginTest() {
        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(201);

        AddToFavouriteResponse addToFavouriteResponse = step("Добавляем товар в избранное", () ->
                given(requestSpecification)
                        .body(addToFavouriteRequest)
                        .when()
                        .post(favPath)
                        .then()
                        .spec(responseSpecification)
                        .extract().as(AddToFavouriteResponse.class)
        );
        step("Проверяем, что товар добавился в избранное", () ->
        {
            SoftAssertions.assertSoftly(
                    softAssertions -> {
                        assertThat(addToFavouriteResponse.getSkuId()).isEqualTo(testData.skuId);
                        assertThat(addToFavouriteResponse.getDateAdd()).isNotEmpty();
                    });
        });
    }

    @Story("Функционал работы с избранным")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест на получение товаров в избранном")
    @Test
    void getFavouritesWithoutLoginTest() {
        AddToFavouriteWithoutLogin addToFavouriteWithoutLogin = new AddToFavouriteWithoutLogin();
        addToFavouriteWithoutLogin.addToFavouriteWithoutLogin(token, addToFavouriteRequest);

        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(200);

        GetFavouriteResponse getFavouriteResponse = step("Запрашиваем данные об избранном", () ->
                given(requestSpecification)
                        .when()
                        .get(favPath)
                        .then()
                        .spec(responseSpecification)
                        .extract().as(GetFavouriteResponse.class)
        );

        step("Проверяем данные в избранном", () ->
        {
            SoftAssertions.assertSoftly(
                    softAssertions -> {
                        assertThat(getFavouriteResponse.getItems().get(0).getSkuId()).isEqualTo(testData.skuId);
                        assertThat(getFavouriteResponse.getItems()).hasSize(1);
                        assertThat(getFavouriteResponse.getMeta().getCount()).isEqualTo(1);
                    });
        });
    }

    @Story("Функционал работы с избранным")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Тест на удаление товара из избранного")
    @Test
    void deleteFromFavouritesWithoutLoginTest() {
        AddToFavouriteWithoutLogin addToFavouriteWithoutLogin = new AddToFavouriteWithoutLogin();
        addToFavouriteWithoutLogin.addToFavouriteWithoutLogin(token, addToFavouriteRequest);

        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(204);

        step("Удаляем товар из избранного", () ->

                given(requestSpecification)
                        .when()
                        .delete(favPath + "/" + testData.skuId)
                        .then()
                        .spec(responseSpecification)
                        .extract().body()
        );
        step("Проверяем, что товаров в избранном не осталось", () ->
        {
            GetFavouritesWithoutLogin getFavouritesWithoutLoginFinal = new GetFavouritesWithoutLogin();
            SoftAssertions.assertSoftly(
                    softAssertions -> {
                        assertThat(getFavouritesWithoutLoginFinal.getFavouritesWithoutLogin(token)
                                .getItems()).hasSize(0);
                    });
        });
    }
}
