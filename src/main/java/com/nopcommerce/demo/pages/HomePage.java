package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class HomePage extends Utility {
    By loginLink = By.linkText("Log in");
    By registerLink = By.xpath("//a[contains(text(),'Register')]");

    // This method clicks on Login Link
    public void clickonLoginLink(){
        Reporter.log("Clicking on Login Link " + loginLink.toString() + "<br>");
        clickOnElement(loginLink);
    }
    // This method clicks on Register Link

    public void clickonRegisterLink(){
        Reporter.log("Clicking on Register Link " + registerLink.toString() + "<br>");
        clickOnElement(registerLink);
    }

}
