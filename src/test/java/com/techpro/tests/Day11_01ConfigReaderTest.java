package com.techpro.tests;

import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.TestBase;
import org.testng.annotations.Test;

public class Day11_01ConfigReaderTest extends TestBase {

    @Test
    public void googleTitile() {
        driver.get("https://www.google.com/"); // hard coded

        driver.get(ConfigReader.getProperty("url"));// this is same as above


    }
}
