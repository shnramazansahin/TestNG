package com.techpro.tests;

import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Day11_02FirstDriverClass {


    @Test
    public void firstDriverTest() {

        Driver.getDriver().get(ConfigReader.getProperty("qa_environment"));


    }
}
