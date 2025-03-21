package tests.api;

import api.AddToFavouriteWithoutLogin;
import api.GetAuthInfo;
import io.restassured.specification.ResponseSpecification;
import models.AddToFavouriteRequest;
import models.AddToFavouriteResponse;
import models.GetFavouriteResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import specs.BaseResponseSpec;
import utils.TestGeneratedData;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BaseRequestSpec.commonRequestSpec;

public class FavouritesTests extends ApiTestBase {
    TestGeneratedData testGeneratedData = new TestGeneratedData();

    @Test
    void addToFavouriteWithoutLoginTest() {

        GetAuthInfo getAuthInfo = new GetAuthInfo();
        String token = "Bearer " + getAuthInfo.ResponseToken().getToken().getAccessToken();

        AddToFavouriteRequest addToFavouriteRequest = new AddToFavouriteRequest(testGeneratedData.skuId);

        ResponseSpecification responseSpecification = new BaseResponseSpec().commonResponseSpec(201);

        AddToFavouriteResponse addToFavouriteResponse = step("Добавляем товар в избранное", () ->
                given(commonRequestSpec)
                        .body(addToFavouriteRequest)
                        .header("Authorization", token)
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
                        assertThat(addToFavouriteResponse.getSkuId()).isEqualTo(testGeneratedData.skuId);
                        assertThat(addToFavouriteResponse.getDateAdd()).isNotEmpty();
                    });
        });
    }


    @Test
    void getFavouritesWithoutLoginTest() {
        GetAuthInfo getToken = new GetAuthInfo();
        String token = getToken.ResponseToken().getToken().getAccessToken();

        AddToFavouriteRequest addToFavouriteRequest = new AddToFavouriteRequest(testGeneratedData.skuId);

        AddToFavouriteWithoutLogin addToFavouriteWithoutLogin = new AddToFavouriteWithoutLogin();
        addToFavouriteWithoutLogin.addToFavouriteWithoutLogin(token, addToFavouriteRequest);

        ResponseSpecification responseSpecification = new BaseResponseSpec().commonResponseSpec(200);

        GetFavouriteResponse getFavouriteResponse =
        given(commonRequestSpec)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(favPath)
                .then()
                .spec(responseSpecification)
                .extract().as(GetFavouriteResponse.class);
    }


    @Test
    void deleteFromFavouritesWithoutLoginTest() {
        GetAuthInfo getToken = new GetAuthInfo();
        String token = getToken.ResponseToken().getToken().getAccessToken();


        AddToFavouriteWithoutLogin addToFav = new AddToFavouriteWithoutLogin();
        //String bookId = addToFav.addtoFavouriteWithoutLogin(token).getSkuId();


        given()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                // .delete("https://api.4lapy.ru/api/v1/favourites/favourites/" + bookId)
                .then();
        // .log().all()
        // .extract().body();
    }
}
