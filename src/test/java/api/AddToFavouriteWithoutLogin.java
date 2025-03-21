package api;

import io.qameta.allure.Step;
import io.restassured.specification.ResponseSpecification;
import models.AddToFavouriteRequest;
import models.AddToFavouriteResponse;
import specs.BaseResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;
import static specs.BaseRequestSpec.commonRequestSpec;

public class AddToFavouriteWithoutLogin extends ApiTestBase {

    @Step("Добавляем товар в избранное без регистраци")
    public AddToFavouriteResponse addToFavouriteWithoutLogin(String token, AddToFavouriteRequest addToFavouriteRequest) {

        ResponseSpecification responseSpecification = new BaseResponseSpec().commonResponseSpec(201);

        return given(commonRequestSpec)
                .body(addToFavouriteRequest)
                .header("Authorization", "Bearer " + token)
                .when()
                .post(favPath)
                .then()
                .spec(responseSpecification)
                .extract().as(AddToFavouriteResponse.class);
    }
}
