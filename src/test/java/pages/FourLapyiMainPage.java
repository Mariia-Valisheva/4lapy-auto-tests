package pages;

import com.codeborne.selenide.SelenideElement;

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
            firstSubCategoryBlock = $(".HeaderCatalog_col__0K9Fl", 0),
            tabsMenu = $(".TopCategoriesPanel_root__EMDNE");


    public FourLapyiMainPage openPage() {
        open("");
        cookiePopUp.sibling(0).scrollTo().click();
        return this;
    }

    public FourLapyiMainPage searchByKeyWord(String keyword) {
        searchInput.setValue(keyword);
        searchButton.click();
        return this;
    }

    public FourLapyiMainPage clickToCardIcon() {
        cardIcon.click();
        return this;
    }

    public FourLapyiMainPage closeLocationPopUp() {
        noLocationButton.click();
        closeLocationPopUpMenu.click();
        return this;
    }


    public FourLapyiMainPage searchInCatalog(String expectedText) {
        catalogBurgerMenu.click();
        actions().moveToElement(secondMainCategoryInCatalog).perform();
        actions().moveToElement(firstSubCategoryBlock)
                .moveToElement($(byText(expectedText))).click().perform();
        return this;
    }

    public FourLapyiMainPage clickOnSales(String expectedText) {
        tabsMenu.$(byText(expectedText)).click();
        return this;
    }

    public FourLapyiMainPage clickOnProfileIcon() {
        profileIcon.click();
        return this;
    }

}
