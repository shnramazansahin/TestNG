package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day10_1FileExist {

    @Test
    public void isExist() {

        String path = "C:\\Users\\User\\Desktop\\flower.jpg";
        // we need java to deal with Files

        boolean exist=  Files.exists(Paths.get(path));
        Assert.assertTrue(exist);






    }
}
