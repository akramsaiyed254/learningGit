package Tests;

import org.example.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.example.BaseClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AdminPanelLogin extends BaseClass {
    By btn1 = By.xpath("");


    @Test
    public  void adminPanel() throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver","/Users/mohammadakram.saiyed/Downloads/chromedriver-mac-x64/chromedriver");
//        WebDriver driver = new ChromeDriver();

       // driver.manage().window().maximize();

        driver.get("http://formdepot.dev.radixweb.net/admin");

        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("radixdt");
        driver.findElement(By.name("password")).sendKeys("JeffCollin@1");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://formdepot.dev.radixweb.net/admin/dashboard/user");

        driver.findElement(By.xpath("//button[contains(text(),'Add New User')]")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://formdepot.dev.radixweb.net/admin/dashboard/user/addEditMGAUserPage");


        String username = String.valueOf(getRandomNumber());
        Long Phone = getRandomPhone();

        driver.findElement(By.xpath("//*/form/div[1]/div/input")).sendKeys("First Name" +username);
        driver.findElement(By.xpath("//*/form/div[2]/div/input")).sendKeys("Last Name" +username);
        driver.findElement(By.xpath("//*/form/div[3]/div/input")).sendKeys("testuser" +username);
        driver.findElement(By.xpath("//*/form/div[4]/div/input")).sendKeys("testuser" +username+"@yopmail.com");
        driver.findElement(By.xpath("//*/form/div[5]/div[2]/div/input")).sendKeys("9" +Phone);
        driver.findElement(By.xpath("//*/form/div[6]/div//input")).sendKeys("Test Address line 1, Test Address Line 2");
        driver.findElement(By.xpath("//*/form/div[7]/div//input")).sendKeys("A1B2C3");

        Select country = new Select(driver.findElement(By.xpath("//*/form/div[8]/div[1]/select")));
        country.selectByVisibleText("canada");
        Thread.sleep(1000);

        Select province = new Select(driver.findElement(By.xpath("//*/form/div[8]/div[2]/select")));
        province.selectByVisibleText("Nova Scotia");

        driver.findElement(By.xpath("//*/form/div[8]/div[3]//input")).sendKeys("Test City");
        Thread.sleep(4000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Actions actions = new Actions(driver);
//     actions.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Submit')]")));
//
//        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
//
//        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(1000);

       driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
       Thread.sleep(5000);
       //System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"http://formdepot.dev.radixweb.net/admin/dashboard/user");

//        driver.findElement(By.xpath("//div/nav/div/div/div/div[2]/ul/a[4]/div[2]")).click();
//        Thread.sleep(4000);
//        Assert.assertEquals(driver.getCurrentUrl(),"http://formdepot.dev.radixweb.net/admin/dashboard/formManagementPage");
//
//
//        driver.findElement(By.xpath("//div[1]/button[1]/span[1]/*[1]")).click();



        //driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();





        //driver.findElement(By.xpath("//*/form/div[5]/div[2]/div/input")).sendKeys("");

        Thread.sleep(3000);


    }


}
