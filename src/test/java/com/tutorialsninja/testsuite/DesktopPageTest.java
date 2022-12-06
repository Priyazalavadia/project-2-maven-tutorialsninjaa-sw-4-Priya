package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopPageTest extends BaseTest {
    DesktopsPage desktopsPage= new DesktopsPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        desktopsPage.hoverAndClickOnDesktopsTab();
        desktopsPage.verifyProductArrangeInDescendingOrder();
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        desktopsPage.selectYourCurrency();
        desktopsPage.hoverAndClickOnDesktopsTab();
        desktopsPage.setSortOrderByAToZ();
        desktopsPage.setSelectProduct();
        String expectedText = "HP LP3065";
        String actualText = desktopsPage.getProductText();
        Assert.assertEquals(actualText, expectedText, "HP LP3065 Product not display");
        desktopsPage.pickDate();
        desktopsPage.addProductToCart();
        String expectedText1 = "Shopping Cart";
        String actualText1 = desktopsPage.productAddedToCartDisplayed();
        Assert.assertEquals(actualText1, expectedText1, "Text not displayed");
        desktopsPage.goToCartByClickOnBanner();
        String expectedText2 = "HP LP3065";
        String actualText2 = desktopsPage.verifyProductNameDisplayed();
        Assert.assertEquals(actualText2, expectedText2, "Product name not matched");
        String expectedText3 = "2022-11-30";
        String actualText3 = desktopsPage.verifyDeliveryDate();
        Assert.assertEquals(actualText3, expectedText3, "Delivery date not matched");
        String expectedText4 = "Product 21";
        String actualText4 = desktopsPage.verifyProductModel();
        Assert.assertEquals(actualText4, expectedText4, "Delivery date not matched");
        String expectedText5 = "£74.73";
        String actualText5 = desktopsPage.verifyOrderTotal();
        Assert.assertEquals(actualText5, expectedText5, "Delivery date not matched");
    }

}
