package com.nopcommerce.demo.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("This is when Test Starts (onTestStarts)" + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("This is when Test is Successful" + iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("This is when Test is Failed" + iTestResult.getName());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("This is when test is Skipped" + iTestResult.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("This is when test failed but withing the success percentage" + iTestResult.getName());

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("This is when OnStart" + iTestContext.getName());

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
