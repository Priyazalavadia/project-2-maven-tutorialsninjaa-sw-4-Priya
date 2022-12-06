package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class MyAccountsPage extends Utility {

    By myAccount = By.xpath("//span[contains(text(),'My Account')]");
    By registerAccount = By.xpath("//h1[contains(text(),'Register Account')]");
    By returningCustomer = By.xpath("//h2[contains(text(),'Returning Customer')]");
    By firstNameField = By.id("input-firstname");
    By lastNameField = By.id("input-lastname");
    By emailField = By.id("input-email");
    By telephoneField = By.name("telephone");
    By passwordField = By.id("input-password");
    By confirmPasswordField = By.id("input-confirm");
    By privacyPolicyCheckBox = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By continueRegister = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    By accountHasBeenCreated = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continueRegister2 = By.xpath("//a[contains(text(),'Continue')]");
    By myAccountLink = By.xpath("//span[contains(text(),'My Account')]");
    By accountLogoutLink = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueLinkBottom = By.xpath("//a[contains(text(),'Continue')]");
    By loginLink = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");
    By myAccountLinkLoginPage = By.xpath("//span[contains(text(),'My Account')]");

    public MyAccountsPage() {
    }

    public void clickOnMyAccountTab() {
        this.clickOnElement(this.myAccount);
    }

    public String verifyTextRegisterCustomer() {
        return this.getTextFromElement(this.registerAccount);
    }

    public String verifyTextReturningCustomer() {
        return this.getTextFromElement(this.returningCustomer);
    }

    public void enterFirstName(String firstName) {
        this.sendTextToElement(this.firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        this.sendTextToElement(this.lastNameField, lastName);
    }

    public void enterEmail(String emailID) {
        this.sendTextToElement(this.emailField, emailID);
    }

    public void enterTelephoneNumber(String phoneNumber) {
        this.sendTextToElement(this.telephoneField, phoneNumber);
    }

    public void enterPassword(String password) {
        this.sendTextToElement(this.passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        this.sendTextToElement(this.confirmPasswordField, confirmPassword);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        this.clickOnElement(this.privacyPolicyCheckBox);
    }

    public void clickOnContinueRegister() {
        this.clickOnElement(this.continueRegister);
    }

    public String verifyTextAccountCreated() {
        return this.getTextFromElement(this.accountHasBeenCreated);
    }

    public void clickOnContinueRegister2() {
        this.clickOnElement(this.continueRegister2);
    }

    public void clickOnMyAccount() {
        this.clickOnElement(this.myAccountLink);
    }

    public String verifyTextAccountLoggedOut() {
        return this.getTextFromElement(this.accountLogoutLink);
    }

    public void clickOnContinueLinkBottom() {
        this.clickOnElement(this.continueLinkBottom);
    }

    public void clickOnLoginLink() {
        this.clickOnElement(this.loginLink);
    }

    public void clickOnMyAccountLinkLoginPage() {
        this.clickOnElement(this.myAccountLinkLoginPage);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));

        try {
            Iterator var3 = myAccountList.iterator();

            while(var3.hasNext()) {
                WebElement options = (WebElement)var3.next();
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException var5) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }

    }

    public static String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for(int i = 0; i < n; ++i) {
            int index = (int)((double)AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public void selectRadioButton() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//fieldset[3]//input"));
        Iterator var2 = radioButtons.iterator();

        while(var2.hasNext()) {
            WebElement e = (WebElement)var2.next();
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }
        }

    }
}


