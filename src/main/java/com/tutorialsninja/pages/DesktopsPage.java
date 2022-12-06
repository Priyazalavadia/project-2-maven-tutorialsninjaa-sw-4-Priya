package com.tutorialsninja.pages;

import com.google.common.base.Verify;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.reporters.jq.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DesktopsPage extends Utility {
    //2.1 Mouse hover on Desktops Tab. and click
    By desktopTab = By.linkText("Desktops");
    //2.2 Click on “Show All Desktops”
    By desktopElement = By.linkText("Show All Desktops");
    //2.3 Select Sort By position "Name: A to Z"
    By sortOrderByAToZ = By.id("input-sort");
    //2.4 Select product “HP LP3065
    By selectProduct = By.xpath("//a[contains(text(),'HP LP3065')]");
    //2.5 Verify the Text "HP LP3065"
    By productText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    //2.8 Click on “Add to Cart” button
    By addToCartTab = By.xpath("//button[@id='button-cart']");
    //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    By successfullyAddedToCartText = By.xpath("//div[@id='content']//h1");
    // 2.10 Click on link “shopping cart” display into success message
    By clickOnMessageBanner = By.xpath("//a[contains(text(),'shopping cart')]");
    //2.12 Verify the Product name "HP LP3065"
    By productNameDisplayed = By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
    //2.13 Verify the Delivery Date "2022-11-30
    By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    //2.14 Verify the Model "Product21"
    By productModel = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    //2.15 Verify the Todat "£74.73"
    By orderTotal = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    public DesktopsPage() {
    }

    public void verifyProductArrangeInDescendingOrder() {
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList();
        Iterator var3 = products.iterator();

        while(var3.hasNext()) {
            WebElement e = (WebElement)var3.next();
            originalProductsName.add(e.getText());
        }

        System.out.println(originalProductsName);
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        this.selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList();
        Iterator var7 = products.iterator();

        while(var7.hasNext()) {
            WebElement e = (WebElement)var7.next();
            afterSortByZToAProductsName.add(e.getText());
        }

        System.out.println(afterSortByZToAProductsName);
    }

    public void hoverAndClickOnDesktopsTab() {
        this.mouseHoverToElement(this.desktopTab);
        this.clickOnElement(this.desktopElement);
    }

    public void setSortOrderByAToZ() {
        this.selectByVisibleTextFromDropDown(this.sortOrderByAToZ, "Name (A - Z)");
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

    public void setSelectProduct() {
        this.clickOnElement(this.selectProduct);
    }

    public String getProductText() {
        return this.getTextFromElement(this.productText);
    }

    public void pickDate() {
        String year = "2023";
        String month = "November";
        String date = "30";
        this.clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));

        while(true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
                Iterator var9 = allDates.iterator();

                while(var9.hasNext()) {
                    WebElement e = (WebElement)var9.next();
                    if (e.getText().equalsIgnoreCase(date)) {
                        e.click();
                        break;
                    }
                }

                return;
            }

            this.clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
        }
    }

    public void addProductToCart() {
        this.clickOnElement(this.addToCartTab);
    }

    public void goToCartByClickOnBanner() {
        this.clickOnElement(this.clickOnMessageBanner);
    }

    public String productAddedToCartDisplayed() {
        return this.getTextFromElement(this.successfullyAddedToCartText);
    }

    public String verifyProductNameDisplayed() {
        return this.getTextFromElement(this.productNameDisplayed);
    }

    public String verifyDeliveryDate() {
        return this.getTextFromElement(this.deliveryDate);
    }

    public String verifyProductModel() {
        return this.getTextFromElement(this.productModel);
    }

    public String verifyOrderTotal() {
        return this.getTextFromElement(this.orderTotal);
    }
}
