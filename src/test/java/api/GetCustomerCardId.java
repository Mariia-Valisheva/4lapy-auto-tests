package api;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specs.RequestSpec;
import specs.ResponseSpec;
import tests.api.ApiTestBase;

import static io.restassured.RestAssured.given;

public class GetCustomerCardId extends ApiTestBase {

    public String getCustomerCardId(String token, String customerId) {

        RequestSpecification requestSpecification = new RequestSpec().baseRequestAuthSpec(token);
        ResponseSpecification responseSpecification = new ResponseSpec().commonResponseSpec(200);

        return given(requestSpecification)
                .queryParam("customerId", customerId)
                .when()
                .get(customerCartPath)
                .then()
                .spec(responseSpecification)
                .extract().body().asString();
    }
}
