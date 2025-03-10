package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
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
    public MainPage openPage() {
        open("");
        cookiePopUp.sibling(0).scrollTo().click();
        return this;
    }

    @Step("Выполняем поиск по ключевому слову")
    public MainPage searchByKeyWord(String keyword) {
        searchInput.setValue(keyword);
        searchButton.click();
        return this;
    }

    @Step("Кликаем на икнонку корзины на главной странице")
    public MainPage clickToCardIcon() {
        cardIcon.click();
        return this;
    }

    @Step("Выбираем локацию в модальном окне")
    public MainPage closeLocationPopUp() {
        noLocationButton.click();
        closeLocationPopUpMenu.click();
        return this;
    }

    @Step("Выполняем поиск по каталогу на главной странице")
    public MainPage searchInCatalog(String expectedText) {
        catalogBurgerMenu.click();
        actions().moveToElement(secondMainCategoryInCatalog).perform();
        $(".HeaderCatalog_grid__X1wyT").find(byText(expectedText)).click();
        return this;
    }

    @Step("Кликаем на иконку профиля на главной странице")
    public MainPage clickOnProfileIcon() {
        profileIcon.click();
        return this;
    }
}
