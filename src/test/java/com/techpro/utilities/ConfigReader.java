package com.techpro.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    // this class will read the configuration.properties file

    // create properties instance

    private static Properties properties;
    // this is the path of the configuration file


  static   {
      String path = "configuration.properties";
      //Opening configuration.properties file using the fileinpu
      try {
            FileInputStream  fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            //close the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // this method will get the key from properties file
    //And return the value as String


    public static String getProperty(String key) {
      return  properties.getProperty(key);

    }

}
