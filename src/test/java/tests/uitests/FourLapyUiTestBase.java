package tests.uitests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.FourLapyiMainPage;

import java.util.Map;

public class FourLapyUiTestBase {

    FourLapyiMainPage mainPage = new FourLapyiMainPage();

    @BeforeAll
    static void configStartParams() {
        Configuration.baseUrl = "https://4lapy.ru/";
        Configuration.browserSize = System.getProperty("browser_size", "1440x932");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version");

        String SELENOID_HOST = System.getProperty("selenoid_host");
        Configuration.remote = "https://user1:1234@" + SELENOID_HOST + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @Step("Открывается главная страница сайта Четыре Лапы")
    @BeforeEach
    void openPageBeforeEachTest() {
        mainPage.openPage();
    }

    @BeforeEach
    void addSelenideListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @AfterEach
    void configFinishParams() {

        if (!Configuration.browser.equals("firefox")) {
            Attachments.addScreenshot("Test screenshot");
            Attachments.addPageSource();
            Attachments.addBrowserConsoleLogs();
            Attachments.addVideo();
        }

        Selenide.closeWebDriver();
    }
}