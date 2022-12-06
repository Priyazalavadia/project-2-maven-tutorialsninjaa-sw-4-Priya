package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksPageTest extends BaseTest {
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        laptopsAndNotebooksPage.hoverOnLaptopsAndNotebooks();
        laptopsAndNotebooksPage.hoverAndClickOnLaptopsAndNotebooks();
        //     laptopsAndNotebooksPage.verifyProductListGetArrangeHighToLow();
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        laptopsAndNotebooksPage.selectYourCurrency();
        laptopsAndNotebooksPage.hoverOnLaptopsAndNotebooks();
        laptopsAndNotebooksPage.hoverAndClickOnLaptopsAndNotebooks();
        laptopsAndNotebooksPage.arrangeProductsHighToLow();
        laptopsAndNotebooksPage.selectProductMacBook();
        String expectedText = "MacBook";
        String actualText = laptopsAndNotebooksPage.verifyTheTextMacBook();
        Assert.assertEquals(actualText, expectedText, "MacBook not display");
        laptopsAndNotebooksPage.clickOnAddToCartTab();
        String expectedText1 ="Success: You have added MacBook to your shopping cart!\n" +
                "×" ;
        String actualText1 = laptopsAndNotebooksPage.verifyTheMessageAfterAddToCart();
        Assert.assertEquals(actualText1, expectedText1, "Such message not display");
        laptopsAndNotebooksPage.clickOnLinkShoppingCart();
        String expectedText2 ="Shopping Cart" ;
        String actualText2 = laptopsAndNotebooksPage.verifyShoppingCart();
        Assert.assertEquals(actualText2, expectedText2, "Such message not display");
        String expectedText3 ="MacBook" ;
        String actualText3 = laptopsAndNotebooksPage.verifyMacBookText();
       // Assert.assertEquals(actualText3, expectedText3, "Such message not display");
        laptopsAndNotebooksPage.changeQuantity();
        laptopsAndNotebooksPage.clickOnUpdateTab();
        String expectedText4 = "Success: You have modified your shopping cart!\n" +
                "×"  ;
        String actualText4 = laptopsAndNotebooksPage.verifyBasketQuantityUpdateSuccess();
        Assert.assertEquals(actualText4, expectedText4, "Such message not display");
        String expectedText5 ="£737.45" ;
        String actualText5 = laptopsAndNotebooksPage.verifyBasketItemTotal();
        //Assert.assertEquals(actualText5, expectedText5, "Basket total does not match");
        laptopsAndNotebooksPage.clickOnCheckoutButton();
        String expectedText6 ="Checkout" ;
        String actualText6 = laptopsAndNotebooksPage.verifyCheckoutText();
        Assert.assertEquals(actualText6, expectedText6, "Such message not display");
        String expectedText7 ="New Customer" ;
        String actualText7 = laptopsAndNotebooksPage.verifyNewCustomerText();
        //Assert.assertEquals(actualText7, expectedText7, "Such message not display");
        laptopsAndNotebooksPage.clickOnGuestCheckoutRadioButton();
        laptopsAndNotebooksPage.clickOnContinue();
       // laptopsAndNotebooksPage.enterFirstName();
        laptopsAndNotebooksPage.enterLastName();
        laptopsAndNotebooksPage.enterEmail();
        laptopsAndNotebooksPage.enterTelephoneNumber();
        laptopsAndNotebooksPage.enterAddress();
        laptopsAndNotebooksPage.enterCityField();
        laptopsAndNotebooksPage.enterPostcode();
        laptopsAndNotebooksPage.enterCountryFromList();
        laptopsAndNotebooksPage.selectPaymentZone();
        laptopsAndNotebooksPage.selectContinueTab();
        laptopsAndNotebooksPage.insertYourComments();
        laptopsAndNotebooksPage.checkCheckBoxTermsAndConditions();
        laptopsAndNotebooksPage.selectContinueTab2();
        String expectedText8 ="Warning: Payment method required!" ;
        String actualText8 = laptopsAndNotebooksPage.verifyPaymentMethodRequiredMessage();
        Assert.assertEquals(actualText8, expectedText8, "Such message not display");


    }



    }

