package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class LoginPage extends Utility {
    By emailField = By.id("Email");
    By passwordField = By.name("Password");
    By loginBtn = By.xpath("//input[@value='Log in']");
    By welcomeText = By.xpath("//h1[text()='Welcome, Please Sign In!']");
    By loginErrorMessage = By.xpath("//div[@class = 'message-error validation-summary-errors']");
    By loginSuccessful = By.xpath("//h2[contains(text(),'Welcome to our store')]");

    public void enterEmailId(String email) {
        Reporter.log("Enter Email " + email + "to Email Field " + emailField.toString() + "<br>");
        sendTextToElement(emailField, email);
    }

    public void enterPasswordField(String password) {
        Reporter.log("Enter Password " + password + " to Password Field " + passwordField.toString() + "<br>");
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Login Button click" + loginBtn.toString() + " <br>");
        clickOnElement(loginBtn);
    }

    public String getWelcomeText() throws InterruptedException {
        Reporter.log("Welcome Text " + welcomeText.toString() + "<br>");
        Thread.sleep(500);
        return getTextFromElement(welcomeText);

    }

    public String getErrorMessage() throws InterruptedException {
        Reporter.log("Login Error " + loginErrorMessage.toString() + " <br>");
        Thread.sleep(500);
        return getTextFromElement(loginErrorMessage);

    }

    public String getLoginSuccessfulMsg() {
        Reporter.log("Login Successful Text " + loginSuccessful.toString() + " <br>");
        return getTextFromElement(loginSuccessful);
    }

    public void loginToApplication(String email, String password) {
        enterEmailId(email);
        enterPasswordField(password);
        clickOnLoginButton();
    }


}
