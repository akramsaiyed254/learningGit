package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.setProperty("webdriver.chrome.driver","/Users/mohammadakram.saiyed/Downloads/chromedriver-mac-x64/chromedriver");
       //webdriver.chrome.driver
        //Invoking chrome browser
        //WebDriver driver = new ChromeDriver();

        //Invoking firefox browser

        WebDriver driver = new FirefoxDriver();

        System.setProperty("webdriver.gecko.driver","/Users/mohammadakram.saiyed/Downloads/geckodriver");


        driver.get("http://formdepot.dev.radixweb.net/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
}