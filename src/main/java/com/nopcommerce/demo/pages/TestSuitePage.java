package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuitePage extends Utility {
    By computerLink = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
    By deskTopLink = By.xpath("//h2[@class='title']//a[contains(text(),'Desktops')]");
    By productTitle = By.xpath("//h2[@class='product-title']");
    By productOrderBy = By.id("products-orderby");
    By addToCartButton1 = By.xpath("//input[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']");
    By dropDownProcessor = By.xpath("//select[@id='product_attribute_1']");
    By dropDownRAM = By.xpath("//select[@id='product_attribute_2']");
    By radioBtnOS = By.xpath("//input[@id='product_attribute_4_9']");
    By radioBtnHdd = By.xpath("//input[@id='product_attribute_3_7']");
    By chkBoxMSOffice = By.xpath("//input[@id='product_attribute_5_10']");
    By chkBoxCommander = By.xpath("//input[@id='product_attribute_5_12']");
    By getAddToCartButton2 = By.xpath("//input[@id='add-to-cart-button-1']");
    By barNotificationDisplay = By.xpath("//body/div[@id='bar-notification']/div[1]");
    By shoppingCartLink = By.xpath("//span[contains(text(),'Shopping cart')]");
    By miniShoppingCartBtn = By.xpath("//div[@class='mini-shopping-cart']//div//input");
    By itemQtyField = By.xpath("//input[@class='qty-input']");
    By updateCartButton = By.xpath("//div[@class='cart-options']//div//input[@class='button-2 update-cart-button']");
    By actualdesktopMessage = By.xpath("//h1[contains(text(),'Desktops')]");
    By actualBuildYourOwnDeskTopMessage = By.xpath("//h1[contains(text(),'Build your own computer')]");
    By actualAmountVerify = By.xpath("//span[@class='price-value-1']");
    By actualShoppingCartMessage = By.xpath("//h1[contains(text(),'Shopping cart')]");
    By closeOption = By.xpath("//span[@class='close']");

    //Mouse hove on Computer Menu and click on desktop
    public void mouseHoverOnComputerAndClickDesktop() {
        Reporter.log("Registration Link Click " + computerLink.toString() + "<br>");
        mouseHoverToElement(computerLink);
        Reporter.log("DeskTop Link Click " + deskTopLink.toString() + "<br>");
        clickOnElement(deskTopLink);
    }

    //sort by position "Name: Z to A"
    public void sortProductsOrderByZToA() {
        Reporter.log("Sorting Z TO A " + productOrderBy.toString() + "<br>");
        selectByVisibleTextFromDropDown(productOrderBy, "Name: Z to A");

        //Getting list of web elements of product name
        List<WebElement> deskTopPCs = getListOfElements(productTitle);

        //Declaring the String List to store product name
        List<String> deskTopNames = new ArrayList<>();

        for (WebElement deskTop : deskTopPCs) {
            deskTopNames.add(deskTop.getText());
        }

        // Create the temp list of product name and sort it using Collections.sort method
        List<String> tempList = new ArrayList<>();
        tempList.addAll(deskTopNames);

        Collections.sort(tempList, Collections.reverseOrder());
        //System.out.println(deskTopNames);
        //System.o+ut.println(tempList);
        Assert.assertEquals(deskTopNames, tempList);
    }

    public void topMenuLinkSelection() throws InterruptedException {
        waitFor(2);
        Reporter.log("Click on Computer Link " + computerLink.toString() + "<br>");
        clickOnElement(computerLink); // Clicks on Computer link
        waitFor(2);
        Reporter.log("Click on DeskTop Link " + deskTopLink.toString() + "<br>");
        clickOnElement(deskTopLink);// clicks on Desktop Link
    }

    public String actualMessageDesktop() {
        Reporter.log("Actual Message on Desktop Page " + actualdesktopMessage + "<br>");
        return getTextFromElement(actualdesktopMessage);
    }

    public void deskTopPageAction() {
        Reporter.log("Sorts Product AtoZ" + productOrderBy.toString() + "<br>");
        waitFor(2);
        clickOnElement(productOrderBy); // clicks on Sort dropDown
        selectByVisibleTextFromDropDown(productOrderBy, "Name: A to Z");// selects AtoZ from dropdown
        Reporter.log("Clicks on Add to Cart Button " + addToCartButton1.toString() + "<br>");
        clickOnElement(addToCartButton1);

    }

    public String actualMessageBuildYourOwnDesktop() {
        Reporter.log("Actual Message on Build your commputer Page " + actualBuildYourOwnDeskTopMessage + "<br>");
        return getTextFromElement(actualBuildYourOwnDeskTopMessage);
    }

    public void buildYourOwnComputerSelectProcessor() throws InterruptedException {
        Reporter.log("Drop Down Processor " + dropDownProcessor.toString() + "<br>");
        waitFor(2);
        clickOnElement(dropDownProcessor); // clicks on dropdown processor
        waitUntilPresenceOfElementLocated(dropDownProcessor);
        selectByIndexFromDropDown(dropDownProcessor, 0); // selects the 0th Index for 2.2GB processor
    }

    public void buildYourOwnComputerSelectRAM() {
        Reporter.log("Drop Down for RAM " + dropDownRAM.toString() + "<br>");
        waitFor(2);
        clickOnElement(dropDownRAM); // clicks on RAM Dropdown
        waitFor(2);
        //waitUntilPresenceOfElementLocated(dropDownRAM);
        selectByVisibleTextFromDropDown(dropDownRAM, "8GB [+$60.00]");// selects 8GB RAM
    }

    public void buildYourOwnComputerRadioButton() throws InterruptedException {
        Reporter.log("Clicks on Radio Button - HDD " + radioBtnHdd.toString() + "<br>");
        clickOnElement(radioBtnHdd); // Clicks on Radio Button HDD - 400 GB
        Reporter.log("Clicks on Radio Button OS " + radioBtnOS.toString() + "<br>");
        clickOnElement(radioBtnOS);// Clicks on Radio Button OS - Vista Premium $60
    }

    public void buildYourOwnComputerCheckBox() throws InterruptedException {
        Reporter.log("Check Box Commander " + chkBoxCommander.toString() + "<br>");
        waitFor(2);
        clickOnElement(chkBoxCommander); // selects Commander CheckBox
    }

    public String actualAmountMessage() throws InterruptedException {
        Reporter.log("Acutal Amount Verify " + actualAmountVerify.toString() + "<br>");
        return getTextFromElement(actualAmountVerify);

    }

    public void buildYourOwnComputerAddToCartBtn() throws InterruptedException {
        Reporter.log("Add to Cart Button " + getAddToCartButton2.toString() + "<br>");
        waitFor(2);
        waitUntilElementToBeClickable(getAddToCartButton2);
        clickOnElement(getAddToCartButton2); // Clicks on ~Add to cart button

    }

    public void notificationDisplay() throws InterruptedException {
        Reporter.log("Bar Notification Display " + barNotificationDisplay.toString() + "<br>");
        waitFor(2);
        clickOnElement(barNotificationDisplay); // clicks on Bar Notification pop up

    }

    public void moveToShoppingCart() throws InterruptedException {
        Reporter.log("Mini Shopping Cart Button " + miniShoppingCartBtn.toString() + "<br>");
        waitFor(2);
        clickOnElement(closeOption);
        mouseHoverToElement(shoppingCartLink); // selects the shopping Cart Link
        clickOnElement(miniShoppingCartBtn);
    }

    public String actualMessageShoppingCart() {
        Reporter.log("Actual Shopping Cart Message " + actualdesktopMessage.toString() + "<br>") ;
        return getTextFromElement(actualShoppingCartMessage); // verfying ShoppingCart Message
    }

    public void amendQtyField() throws InterruptedException {
        Reporter.log("Item Field " + itemQtyField.toString() + "<br>");
        waitFor(2);
        clickOnElement(itemQtyField);// clicks in the item field
        clearText(itemQtyField); // clears the text from the field
        sendTextToElement(itemQtyField, "2"); // sends value to field
    }

    public void updateFinalCart() {
        Reporter.log("Update Cart Button " + updateCartButton.toString() + "<br>");
        clickOnElement(updateCartButton); // clicks update button


    }


}