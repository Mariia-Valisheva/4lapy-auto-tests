package tests.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ApiTestBase {

    @BeforeAll
    static void configParams() {
        RestAssured.baseURI = System.getProperty("baseURI", "https://api.4lapy.ru");
        RestAssured.basePath = "api/v1";
    }

    public static final String authEmailPath = "https://4lapy.ru/api/auth/authByEmail/";
    public static final String authPath = "users/customer/auth";
    public static final String favPath = "favourites/favourites";
    public static final String currentPath = "users/current";
    public static final String customerCartPath = "cart/customerCartId";
    public static final String cartPath = "cart/cart/";
    public static final String itemPath = "/items";
    public static final String miniCartPath = "/mini";

    @BeforeEach
    void addSelenideListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}

