package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnDesktopTab();
        homePage.selectMenu("Show All Desktops");
        String expectedText = "Desktops";
        String actualText = homePage.verifyTextDesktop();
        Assert.assertEquals(actualText, expectedText, "Not navigate to Desktop page");


    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.clickOnLaptopsAndNotebooksTab();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedText1 = "Laptops & Notebooks";
        String actualText1 = homePage.verifyTextLaptopsAndNotebooks();
        Assert.assertEquals(actualText1, expectedText1, "Not navigate to Laptops and Notebooks page");

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        homePage.clickOnComponentsTab();
        homePage.selectMenu("Show All Components");
        String expectedText2 = "Components";
        String actualText2 = homePage.verifyTextComponents();
        Assert.assertEquals(actualText2, expectedText2, "Not navigate to page");

    }
}
