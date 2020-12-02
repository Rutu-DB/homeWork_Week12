package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage= new RegisterPage();
    public String nEmail = randomEmail();

    @Test (priority = 1)
    public void verifyUserShouldNavigateToLoginPage() throws InterruptedException {
        homePage.clickonLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage);
        registerPage.registerUsingMandatoryField(nEmail);
    }

    @Test(priority = 2)
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
       // System.out.println("pass");
        homePage.clickonLoginLink();
        Thread.sleep(500);
        loginPage.enterEmailId(nEmail);
        loginPage.enterPasswordField("123456");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Welcome to our store";
        String actualMessage = loginPage.getLoginSuccessfulMsg();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test(priority = 3)
    public void verifyUserShouldNotLoginSuccessfullyWithInValidCredentials() throws InterruptedException {
        System.out.println("pass");
        homePage.clickonLoginLink();
        Thread.sleep(500);
        loginPage.enterEmailId("betatest123@me.com");
        loginPage.enterPasswordField("123456");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
