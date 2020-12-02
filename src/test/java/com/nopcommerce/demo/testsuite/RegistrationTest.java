package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    public String nEmail = randomEmail();

@Test
    public void verifyThatUserIsOnRegistrationPage(){
    homePage.clickonRegisterLink();
    String actualResult = registerPage.verifyRegisterPageMessage();
    Assert.assertEquals(actualResult,"Register");

}
@Test
    public void verifyRegistrationSuccessfully() throws InterruptedException {
    homePage.clickonRegisterLink();
    Thread.sleep(1000);
    registerPage.clickOnGender();
    registerPage.enterFirstName("Alpha");
    registerPage.enterLastName("Beta");
    registerPage.setDate();
    registerPage.setMonth();
    registerPage.setYear();
    registerPage.enterEmailId(nEmail);
    registerPage.enterCompanyField("Alpha Beta Ltd.");
    registerPage.clickOnNewsletterChkBox();
    registerPage.enterPassword("123456");
    registerPage.confirmPasswordField("123456");
    registerPage.clickonRegisterButton();
    String actualResult = registerPage.verifyRegisterSuccessMessage();
    Assert.assertEquals(actualResult,"Your registration completed");
}

}
