package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAccountsPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.tutorialsninja.pages.MyAccountsPage.getAlphaNumericString;

public class MyAccountsTest extends BaseTest {
    MyAccountsPage myAccountsPage= new MyAccountsPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccountsPage.clickOnMyAccountTab();
        myAccountsPage.selectMyAccountOptions("Register");
        String expectedText = "Register Account";
        String actualText = myAccountsPage.verifyTextRegisterCustomer();
        Assert.assertEquals(actualText, expectedText, "Such text not display");

    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccountsPage.clickOnMyAccountTab();
        myAccountsPage.selectMyAccountOptions("Login");
        String expectedText = "Returning Customer";
        String actualText = myAccountsPage.verifyTextReturningCustomer();
        Assert.assertEquals(actualText, expectedText, "Login page not displayed");

    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccountsPage.clickOnMyAccountTab();
        myAccountsPage.selectMyAccountOptions("Register");
        myAccountsPage.enterFirstName("prime" + getAlphaNumericString(4));
        myAccountsPage.enterLastName("test" + getAlphaNumericString(4));
        myAccountsPage.enterEmail("prime" + getAlphaNumericString(4) + "@gmail.com");
        myAccountsPage.enterTelephoneNumber("01234567890");
        myAccountsPage.enterPassword("test123");
        myAccountsPage.enterConfirmPassword("test123");
        myAccountsPage.selectRadioButton();
        myAccountsPage.clickOnPrivacyPolicyCheckBox();
        myAccountsPage.clickOnContinueRegister();
        String expectedText1 = "Your Account Has Been Created!";
        String actualText1 = myAccountsPage.verifyTextAccountCreated();
        Assert.assertEquals(actualText1, expectedText1, "Such message not displayed");
        myAccountsPage.clickOnContinueRegister2();
        myAccountsPage.clickOnMyAccount();
        myAccountsPage.selectMyAccountOptions("Logout");
        String expectedText2 = "Account Logout";
        String actualText2 = myAccountsPage.verifyTextAccountLoggedOut();
        Assert.assertEquals(actualText2, expectedText2, "Such message not displayed");
        myAccountsPage.clickOnContinueLinkBottom();

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccountsPage.clickOnMyAccountTab();
        myAccountsPage.selectMyAccountOptions("Login");
        myAccountsPage.enterEmail("prime" + getAlphaNumericString(4) + "@gmail.com");
        myAccountsPage.enterPassword("test123");
        myAccountsPage.clickOnLoginLink();
        myAccountsPage.clickOnMyAccountLinkLoginPage();
        myAccountsPage.selectMyAccountOptions("Logout");
        String expectedText3 = "Account Logout";
        String actualText3 = myAccountsPage.verifyTextAccountLoggedOut();
        Assert.assertEquals(actualText3, expectedText3, "Such message not displayed");
        myAccountsPage.clickOnContinueLinkBottom();
        myAccountsPage.clickOnLoginLink();
        myAccountsPage.clickOnMyAccountLinkLoginPage();
    }
}
