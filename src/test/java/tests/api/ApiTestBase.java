package tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {

    @BeforeAll
    static void configParams() {
        RestAssured.baseURI = "https://api.4lapy.ru";
        RestAssured.basePath = "/api/v1";
    }

    public static final String authPath = "/users/customer/auth";
    public static final String favPath = "/favourites/favourites";
}
