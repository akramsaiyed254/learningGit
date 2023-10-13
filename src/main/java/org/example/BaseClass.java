package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseClass {

    protected WebDriver driver;

//    @Parameters("browser")
    @BeforeClass
  public void setup(String browser) {
//        if (browser.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase("safari")) {
//            WebDriverManager.safaridriver().setup();
//            driver = new SafariDriver();
//        } else {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }
//        driver.manage().window().maximize();
//        driver.get("http://formdepot.dev.radixweb.net/admin");
//

           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
   }
    //Methods

    //1. Print method
    public void print(String string) {
        System.out.println(string);
    }

    //2. Find method
    public WebElement find(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    //3. Click Method
    public void click(String locator) {
        find(locator).click();
    }

    //4. Enter Method
    public void type(String locator, String string) {
        find(locator).sendKeys(string);
    }

    //5. data reader
    public String data(String string) throws IOException {
        FileReader datareader = new FileReader("/Users/mohammadakram.saiyed/IdeaProjects/FormDepotAdmin/src/test/resources/data.properties");
        Properties props = new Properties();
        props.load(datareader);
        return props.getProperty(string);
    }

    public String xpath(String string) throws IOException {
        FileReader xpathreader = new FileReader("/Users/mohammadakram.saiyed/Downloads/LambdaTest_Playground/src/test/resources/xpath.properties");
        Properties props = new Properties();
        props.load(xpathreader);
        return props.getProperty(string);
    }

    //hover
    public void hover(String string) {
        Actions action = new Actions(driver);
        action.moveToElement(find(string)).perform();
    }

    //implicit Wait
    public void wait(int duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    //Thread Sleep
    public void sleep(int duration_in_ms) throws InterruptedException {
        Thread.sleep(duration_in_ms);
    }

    //Closing the browser
    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }




















    public int getRandomNumber(){
        int min = 1111;
        int max = 999999;
        return(int) (Math.random() * (max - min) + min);

    }

    public long getRandomPhone(){
        long min = 999911111;
        long max= 999988888;
        return (long) (Math.random()*(max-min) + min);
    }



}
