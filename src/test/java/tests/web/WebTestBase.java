package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import helpers.Attachments;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;

public class WebTestBase {

    MainPage mainPage = new MainPage();
    boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote", "false"));
    String environment = System.getProperty("env");

    @BeforeAll
    static void configParams() {
        WebDriverConfig webDriverConfig = new WebDriverConfig();
        webDriverConfig.configParams();
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
    void addAttachments() {
        if (isRemote || environment.equals("remote")) {
            if (!Configuration.browser.equals("firefox")) {
                Attachments.addScreenshot("Test screenshot");
                Attachments.addPageSource();
                Attachments.addBrowserConsoleLogs();
                Attachments.addVideo();
            }
        } else {
            Attachments.addScreenshot("Test screenshot");
            Attachments.addPageSource();
            Attachments.addBrowserConsoleLogs();
        }
        Selenide.closeWebDriver();
    }
}