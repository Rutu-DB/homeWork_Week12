package com.nopcommerce.demo.TestNG;

import org.testng.annotations.Test;

public class TestNGPriority {
    @Test(priority = 1)
    public void testMethod1() {
        System.out.println("TestNG_Priority -> testMethod1");
    }

    @Test (priority = 2)
    public void testMethod2() {
        System.out.println("TestNG_Priority -> testMethod2");
    }
    @Test (priority = -1)
    public void testMethod3() {
        System.out.println("TestNG_Priority -> testMethod3");
    }
    @Test()
    public void testMethod4() {
        System.out.println("TestNG_Priority -> testMethod4");
    }

}
