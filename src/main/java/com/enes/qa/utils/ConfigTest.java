package com.enes.qa.utils;

public class ConfigTest {

    public static void main(String[] args) {

        System.out.println(
                ConfigReader.getProperty("url")
        );

        System.out.println(
                ConfigReader.getProperty("browser")
        );
    }
}