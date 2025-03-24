package api;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.GetCurrentResponse;
import specs.RequestSpec;
import specs.ResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;

public class GetCurrentCustomerState extends ApiTestBase {

    public GetCurrentResponse getCurrentCustomerState(String token) {

        RequestSpecification requestSpecification = new RequestSpec().baseRequestAuthSpec(token);
        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(200);

        return given(requestSpecification)
                .when()
                .get(currentPath)
                .then()
                .spec(responseSpecification)
                .extract().as(GetCurrentResponse.class);
    }
}
