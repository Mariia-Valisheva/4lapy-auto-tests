package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;

public class ResponseSpec {

    public ResponseSpecification commonResponseSpec(int expectedStatusCode) {
        return new ResponseSpecBuilder()
                .log(ALL)
                .expectStatusCode(expectedStatusCode)
                .build();
    }
}
