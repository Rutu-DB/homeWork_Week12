package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.TestSuitePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuite extends TestBase {
    HomePage homePage = new HomePage();
    TestSuitePage testSuitePage = new TestSuitePage();
    static String actualMessage;


    @Test(priority = 1)
    public void verifyProductSortedAlphabetically() throws InterruptedException {

        testSuitePage.topMenuLinkSelection();

        testSuitePage.sortProductsOrderByZToA();

    }

    @Test(priority = 2)
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        testSuitePage.topMenuLinkSelection(); // clicks computer link and clicks on desktop
        //verifying user is on Desktop page
        actualMessage = testSuitePage.actualMessageDesktop();
        Assert.assertEquals(actualMessage, "Desktops"); // verifying on DesktopPage
        // Moving on to DeskTop Page
        testSuitePage.deskTopPageAction(); // clicks on dropDown, selects A to Z and clicks on Add to cart button
        // verify user is on build your own computer page
        actualMessage = testSuitePage.actualMessageBuildYourOwnDesktop();
        Assert.assertEquals(actualMessage, "Build your own computer");
        // Selecting various Elements from build your own computer page
        testSuitePage.buildYourOwnComputerSelectProcessor(); // Selects 2.2GHz Processor
        testSuitePage.buildYourOwnComputerSelectRAM(); // selects 8GB RAM
        testSuitePage.buildYourOwnComputerRadioButton(); // Selects OS & HDD radio button
        testSuitePage.buildYourOwnComputerCheckBox();// Selects Microsoft Office and Commander CheckBox
        //verify Amount total is $1,475.00
        Thread.sleep(500);
        String actualMessage1 = testSuitePage.actualAmountMessage();
        Assert.assertEquals(actualMessage1, "$1,475.00");
        testSuitePage.buildYourOwnComputerAddToCartBtn();//clicks on Add to cart button
        testSuitePage.notificationDisplay();// verifying the notification popup
        testSuitePage.moveToShoppingCart();// clicks on Shopping cart Link and 'Go to Cart button'
        //verify User is on Shopping Cart Page
        actualMessage = testSuitePage.actualMessageShoppingCart();
        Assert.assertEquals(actualMessage, "Shopping cart");
        testSuitePage.amendQtyField(); // clears the field and amends the quantity to 2
        testSuitePage.updateFinalCart(); // Final Add to cart button


    }


}
