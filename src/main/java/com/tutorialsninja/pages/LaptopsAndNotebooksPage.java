package com.tutorialsninja.pages;

import com.google.common.base.Verify;
import com.tutorialsninja.utility.Utility;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    By laptopsAndNotebooksTab = By.linkText("Laptops & Notebooks");

    By allLaptopsAndNotebooksOptionFromTab = By.linkText("Show All Laptops & Notebooks");

    By sortByTab = By.xpath("//select[@id='input-sort']");

    By productMacBookTab = By.linkText("MacBook");

    By productMacBookText = By.xpath("//h1[contains(text(),'MacBook')]");

    By addToCartTab = By.xpath("//button[@id='button-cart']");

    By cartSuccessfullyAdded = By.xpath("//div[contains(text(),'Success: You have added ')]");

    By shoppingCartInSuccessMessage = By.xpath("//a[contains(text(),'shopping cart')]");

    By shoppingCartTextInBasket = By.xpath("//a[contains(text(),'Shopping Cart')]");
    By macBookTextInCart = By.xpath("//a[contains(text(),'Shopping Cart')]");
    By updateTab = By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]");
    By quantityUpdateSuccess = By.xpath("//body/div[@id='checkout-cart']/div[1]");
    By basketTotal = By.xpath("//td[contains(text(),'£737.45')]");
    By checkoutButton = By.xpath("//a[contains(text(),'Checkout')]");
    By checkoutText = By.xpath("//h1[contains(text(),'Checkout')]");
    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");
    By guestCheckoutRadioButton = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]");
    By continueTab = By.xpath("//input[@id='button-account']");
    By firstNameField = By.name("firstname");
    By lastNameField = By.name("lastname");
    By emailField = By.id("input-payment-email");
    By telephoneField = By.name("telephone");
    By addressField = By.name("address_1");
    By cityField = By.name("city");
    By postcodeField = By.name("postcode");
    By paymentCountryField = By.id("input-payment-country");
    By selectYourCountry = By.xpath("//option[contains(text(),'United Kingdom')]");
    By inputPaymentZone = By.id("input-payment-zone");
    By selectYourRegion = By.xpath("//option[contains(text(),'Greater London')]");
    By mandatoryFieldContinueTab = By.xpath("//input[@id='button-register']");
    By commentsSection = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]");
    By termsAndConditionCheckBox = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]");
    By continueTabInPaymentMethod = By.xpath("//input[@id='button-payment-method']");
    By warningMessagePaymentMethod = By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]");

    public LaptopsAndNotebooksPage() {
    }

    public void selectYourCurrency() {
        this.clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        Iterator var2 = currencyList.iterator();

        while(var2.hasNext()) {
            WebElement e = (WebElement)var2.next();
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }

    }

    public void hoverOnLaptopsAndNotebooks() {
        this.mouseHoverToElement(this.laptopsAndNotebooksTab);
    }

    public void hoverAndClickOnLaptopsAndNotebooks() {
        this.mouseHoverToElementAndClick(this.allLaptopsAndNotebooksOptionFromTab);
    }

    public void arrangeProductsHighToLow() {
        this.clickOnElement(this.sortByTab);
        this.selectByVisibleTextFromDropDown(this.sortByTab, "Price (High > Low)");
    }

    public void selectProductMacBook() {
        this.clickOnElement(this.productMacBookTab);
    }

    public String verifyTheTextMacBook() {
        return this.getTextFromElement(this.productMacBookText);
    }

    public void clickOnAddToCartTab() {
        this.clickOnElement(this.addToCartTab);
    }

    public String verifyTheMessageAfterAddToCart() {
        return this.getTextFromElement(this.cartSuccessfullyAdded);
    }

    public void clickOnLinkShoppingCart() {
        this.clickOnElement(this.shoppingCartInSuccessMessage);
    }

    public String verifyShoppingCart() {
        return this.getTextFromElement(this.shoppingCartTextInBasket);
    }

    public String verifyMacBookText() {
        return this.getTextFromElement(this.macBookTextInCart);
    }

    public void changeQuantity() {
        Actions actions = new Actions(driver);
        this.clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        actions.sendKeys(new CharSequence[]{Keys.BACK_SPACE}).perform();
        actions.sendKeys(new CharSequence[]{Keys.DELETE}).perform();
        actions.sendKeys(new CharSequence[]{"2"}).perform();
    }

    public void clickOnUpdateTab() {
        this.clickOnElement(this.updateTab);
    }

    public String verifyBasketQuantityUpdateSuccess() {
        return this.getTextFromElement(this.quantityUpdateSuccess);
    }

    public String verifyBasketItemTotal() {
        return this.getTextFromElement(this.basketTotal);
    }

    public void clickOnCheckoutButton() {
        this.clickOnElement(this.checkoutButton);
    }

    public String verifyCheckoutText() {
        return this.getTextFromElement(this.checkoutText);
    }

    public String verifyNewCustomerText() {
        return this.getTextFromElement(this.newCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton() {
        this.clickOnElement(this.guestCheckoutRadioButton);
    }

    public void clickOnContinue() {
        this.clickOnElement(this.continueTab);
    }

    public void enterFirstName() {
        this.sendTextToElement(this.firstNameField, "abc");
    }

    public void enterLastName() {
        this.sendTextToElement(this.lastNameField, "xyz");
    }

    public void enterEmail() {
        this.sendTextToElement(this.emailField, "abcxyz@gmail.com");
    }

    public void enterTelephoneNumber() {
        this.sendTextToElement(this.telephoneField, "01234567890");
    }

    public void enterAddress() {
        this.sendTextToElement(this.addressField, "100 Camrose Avenue");
    }

    public void enterCityField() {
        this.sendTextToElement(this.cityField, "London");
    }

    public void enterPostcode() {
        this.sendTextToElement(this.postcodeField, "HA8 5DD");
    }

    public void enterCountryFromList() {
        this.clickOnElement(this.paymentCountryField);
        this.clickOnElement(this.selectYourCountry);
    }

    public void selectPaymentZone() {
        this.clickOnElement(this.inputPaymentZone);
        this.clickOnElement(this.selectYourRegion);
    }

    public void selectContinueTab() {
        this.clickOnElement(this.mandatoryFieldContinueTab);
    }

    public void insertYourComments() {
        this.sendTextToElement(this.commentsSection, "Thank you");
    }

    public void checkCheckBoxTermsAndConditions() {
        this.clickOnElement(this.termsAndConditionCheckBox);
    }

    public void selectContinueTab2() {
        this.clickOnElement(this.continueTabInPaymentMethod);
    }

    public String verifyPaymentMethodRequiredMessage() {
        return this.getTextFromElement(this.warningMessagePaymentMethod);
    }
}
