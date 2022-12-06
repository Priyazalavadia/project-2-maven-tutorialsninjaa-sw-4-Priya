package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class HomePage extends Utility {

    By desktopTab = By.linkText("Desktops");
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By components = By.linkText("Components");
    By componentsText = By.xpath("//h2[contains(text(),'Components')]");

    public HomePage() {
    }

    public void clickOnDesktopTab() {
        this.mouseHoverToElementAndClick(this.desktopTab);
    }

    public String verifyTextDesktop() {
        return this.getTextFromElement(this.desktopText);
    }

    public void clickOnLaptopsAndNotebooksTab() {
        this.mouseHoverToElementAndClick(this.laptopsAndNotebooks);
    }

    public String verifyTextLaptopsAndNotebooks() {
        return this.getTextFromElement(this.laptopsAndNotebooksText);
    }

    public void clickOnComponentsTab() {
        this.mouseHoverToElementAndClick(this.components);
    }

    public String verifyTextComponents() {
        return this.getTextFromElement(this.componentsText);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));

        try {
            Iterator var3 = topMenuList.iterator();

            while(var3.hasNext()) {
                WebElement element = (WebElement)var3.next();
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException var5) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }

    }
}
