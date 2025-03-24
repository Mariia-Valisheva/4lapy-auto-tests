package api;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.GetFavouriteResponse;
import specs.RequestSpec;
import specs.ResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;

public class GetFavouritesWithoutLogin extends ApiTestBase {

    @Step("Получаем список избранного по токену без регистрации")
    public GetFavouriteResponse getFavouritesWithoutLogin(String token) {

        RequestSpecification requestSpecification = new RequestSpec().baseRequestAuthSpec(token);
        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(200);

        return
                given(requestSpecification)
                        .when()
                        .get(favPath)
                        .then()
                        .spec(responseSpecification)
                        .extract().as(GetFavouriteResponse.class);
    }
}
