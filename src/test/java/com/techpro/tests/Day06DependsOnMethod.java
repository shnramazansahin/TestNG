package com.techpro.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Day06DependsOnMethod {
    //login->homepage-> search->result
    //homepage depends on loginn
    @Test
    public void login() {
        System.out.println("login");
        Assert.assertTrue(false); // on purpose to check
    }
    @Test(dependsOnMethods = "login") // success of the homepage depends on the login.
    public void homePage() {
        System.out.println("homepage");
    }
    @Test(priority = 3)
    public void search() {
        System.out.println("search");
    }
    @Test(priority = 4)
    public void result() {
        System.out.println("result");
    }
    @Test
    public void ZcheckOut() {
        System.out.println("this is to check what happens wo priotiry"); // it will run first
    }














}
