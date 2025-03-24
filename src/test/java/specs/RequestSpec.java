package specs;

import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RequestSpec {

    public static RequestSpecification commonRequestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON);

    public RequestSpecification baseRequestAuthSpec(String token) {
        return with()
                .filter(withCustomTemplates())
                .header("Authorization", "Bearer " + token)
                .log().all()
                .contentType(JSON);
    }

    public RequestSpecification extendedRequestAuthSpec(String token) {
        return with()
                .filter(withCustomTemplates())
                .header("Authorization", "Bearer " + token)
                .header("Poligon", "r343-kazan-10-14-14-18-18-22")
                .header("Region", "16")
                .header("Channel", "web")
                .header("Locale", "ru-RU")
                .log().all()
                .contentType(JSON);
    }
}
