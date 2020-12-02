package com.nopcommerce.demo.TestNG;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

//@Listeners(TestNGListeners.class)
public class TestNGListnersDemo {


    @Test
    public void test1(){
        System.out.println("I am in Test1");
    }

    @Test
    public void test2(){
        System.out.println("I am in Test2");
        Assert.fail();
    }

    @Test
    public void test3() {
        System.out.println("I am in Test3");
        throw new SkipException("This test is skipped");
    }

}
