package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    HomePage homePage = new HomePage();


    By gender = By.xpath("//label[contains(text(),'Male')]");
    By firstName = By.xpath("//input[@id='FirstName']");
    By lastName = By.xpath("//input[@id='LastName']");
    By selectDate = By.xpath("//select[@name='DateOfBirthDay']//option[contains(text(),'11')]");
    By selectMonth = By.xpath("//select[@name='DateOfBirthMonth']//option[contains(text(),'November')]");
    By selectYear = By.xpath("//select[@name='DateOfBirthYear']//option[contains(text(),'2011')]");
    By emailField = By.xpath("//input[@id='Email']");
    By company = By.xpath("//input[@id='Company']");
    By newsLetter = By.xpath("//input[@id='Newsletter']");
    By password = By.xpath("//input[@id='Password']");
    By confirmPwd = By.xpath("//input[@id='ConfirmPassword']");
    By registerButton = By.xpath("//input[@id='register-button']");
    By registerMessage = By.xpath("//h1[contains(text(),'Register')]");
    By registerSuccessMessage = By.xpath("//div[contains(text(),'Your registration completed')]");

    //  public void registration() {

    public void clickOnGender() {
        Reporter.log("Gender " + gender.toString() + " <br>");
        clickOnElement(gender);
    }

    public void enterFirstName(String fName) {
        Reporter.log("First Name: " + fName + " to First Name Field " + firstName.toString()+ " <br>" );
        clickOnElement(firstName);
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lName) {
        Reporter.log("Last Name " + lName + " to Last Name Field  " + lastName.toString() + " <br>");
        sendTextToElement(lastName, lName);
    }

    public void setDate() {
        Reporter.log("Date: " + selectDate.toString() + " <br>");
        clickOnElement(selectDate);
    }

    public void setMonth() {
        Reporter.log("Month : " + selectMonth.toString() + " <br>");
        clickOnElement(selectMonth);
    }

    public void setYear() {
        Reporter.log("Date: " + selectYear.toString() + " <br>");
        clickOnElement(selectYear);
    }

    public void enterEmailId(String emailId) {
        Reporter.log(" Email Id: " +emailId+ " to Email ID Field " + emailField.toString() + " <br>");
        clickOnElement(emailField);
        sendTextToElement(emailField, emailId);
    }

    public void enterCompanyField(String companyName) {
        Reporter.log("Company Name " + company.toString() + "<br>");
        clickOnElement(company);
        sendTextToElement(company, companyName);
    }

    public void clickOnNewsletterChkBox() {
        Reporter.log("News Letter " + newsLetter.toString() + "<br>");
        clickOnElement(newsLetter);
    }

    public void enterPassword(String password1) {
        Reporter.log("Password Field : " + password.toString() + "<br>");
        clickOnElement(password);
        sendTextToElement(password, password1);
    }

    public void confirmPasswordField(String password2) {
        Reporter.log("Confirm Password " + confirmPwd.toString() + "<br>");
        clickOnElement(confirmPwd);
        sendTextToElement(confirmPwd, password2);
    }

    public void clickonRegisterButton() {
        Reporter.log("Registration Button Click " + registerButton.toString() + "<br>");
        clickOnElement(registerButton);

    }

    public String verifyRegisterPageMessage (){
        Reporter.log("Registration Message " + registerMessage.toString() + "<br>");
        return getTextFromElement(registerMessage);

    }

    public String verifyRegisterSuccessMessage(){
        return getTextFromElement(registerSuccessMessage);
    }

    public void registerUsingMandatoryField(String newEmail) throws InterruptedException {
        homePage.clickonRegisterLink();
        Thread.sleep(500);
        enterFirstName("Alpha");
        enterLastName("Beta");
        enterEmailId(newEmail);
        enterPassword("123456");
        confirmPasswordField("123456");
        clickonRegisterButton();
    }
}
