package api;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.AddToFavouriteRequest;
import models.AddToFavouriteResponse;
import specs.RequestSpec;
import specs.ResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;

public class AddToFavouriteWithoutLogin extends ApiTestBase {

    @Step("Добавляем товар в избранное без регистраци")
    public AddToFavouriteResponse addToFavouriteWithoutLogin(String token, AddToFavouriteRequest addToFavouriteRequest) {

        RequestSpecification requestSpecification = new RequestSpec().baseRequestAuthSpec(token);
        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(201);

        return given(requestSpecification)
                .body(addToFavouriteRequest)
                .when()
                .post(favPath)
                .then()
                .spec(responseSpecification)
                .extract().as(AddToFavouriteResponse.class);
    }
}
