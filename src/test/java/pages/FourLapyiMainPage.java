package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FourLapyiMainPage {
    private final SelenideElement
            searchInput = $(".HeaderSearch_input__Zug7g"),
            searchButton = $(".HeaderSearch_button__wh1pL"),
            cookiePopUp = $(".CookiesNotification_content___ZSOn"),
            cardIcon = $("#nav_menu_cart"),
            profileIcon = $("#nav_menu_profile"),
            noLocationButton = $(".LocationPopup_buttonGroup__XzgWa").$(".Button_root__pS5iJ", 1),
            closeLocationPopUpMenu = $(".Popup_content__q59Dx").$(".ContentWrapper_close__gXjHF"),
            catalogBurgerMenu = $(".HeaderToggleCatalogBtn_catalogIcon__8VnVk"),
            secondMainCategoryInCatalog = $(".HeaderCatalog_categoryItem__0Mq_J", 1),
            firstSubCategoryBlock = $(".HeaderCatalog_col__0K9Fl", 0);


    @Step("Открываем главную страницу")
    public FourLapyiMainPage openPage() {
        open("");
        cookiePopUp.sibling(0).scrollTo().click();
        return this;
    }

    @Step("Выполняем поиск по ключевому слову")
    public FourLapyiMainPage searchByKeyWord(String keyword) {
        searchInput.setValue(keyword);
        searchButton.click();
        return this;
    }

    @Step("Кликаем на икнонку корзины на главной странице")
    public FourLapyiMainPage clickToCardIcon() {
        cardIcon.click();
        return this;
    }

    @Step("Выбираем локацию в модальном окне")
    public FourLapyiMainPage closeLocationPopUp() {
        noLocationButton.click();
        closeLocationPopUpMenu.click();
        return this;
    }

    @Step("Выполняем поиск по каталогу на главной странице")
    public FourLapyiMainPage searchInCatalog(String expectedText) {
        catalogBurgerMenu.click();
        actions().moveToElement(secondMainCategoryInCatalog).perform();
        actions().moveToElement(firstSubCategoryBlock)
                .moveToElement($(byText(expectedText))).click().perform();
        return this;
    }

    @Step("Кликаем на таб на главной странице")
    public FourLapyiMainPage clickOnTab(String expectedText) {
        $$(".TopCategoriesPanelMenu_listItem__imjYP").findBy(exactText(expectedText)).click();
        return this;
    }

    @Step("Кликаем на иконку профиля на главной странице")
    public FourLapyiMainPage clickOnProfileIcon() {
        profileIcon.click();
        return this;
    }
}
