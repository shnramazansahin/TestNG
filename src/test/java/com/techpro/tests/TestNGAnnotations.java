package com.techpro.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {
    /*
    if you would like to run with a specif order,put () after @Test and type in priority
     */


    @BeforeMethod
    public void setUp() {
        System.out.println("this is before method");
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("test one ");

    }
    @Ignore
    @Test(priority = 4)
    public void test2(){
        System.out.println("test two ");

    }
    @Test(priority = 2)
    public void test3(){
        System.out.println("test one");

    }
    @Test(priority = 3)
    public void test4(){
        System.out.println("test fourth");

    }
    @AfterMethod
    public void tearDown() {
        System.out.println("this is after method");
    }




























}
