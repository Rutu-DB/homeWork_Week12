package com.nopcommerce.demo.TestNG;

import org.testng.annotations.*;

public class TestNGDemo {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am in before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am in after method");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am in before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am in after test");
    }

    @Test
    public void test1(){
        System.out.println("I am in test1");
    }

    @Test
    public void test2(){
        System.out.println("I am in test2");
    }

    @Test
    public void test3(){
        System.out.println("I am in test3");
    }


}
