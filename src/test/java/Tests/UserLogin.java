package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UserLogin {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","/Users/mohammadakram.saiyed/Downloads/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://formdepot.dev.radixweb.net/admin");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //driver.findElement(By.linkText("Forgot password?")).click();

        driver.findElement(By.name("username")).sendKeys("radixdt");
        driver.findElement(By.name("password")).sendKeys("FormDepot@23");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//
        String expectedString = "MGA/Advisor Management";
        String  actualString= driver.findElement(By.cssSelector(".MuiListItemText-root.css-tlelie-MuiListItemText-root")).getText();

        System.out.println(expectedString+" one");
        System.out.println(actualString+" two");
        System.out.println("HEY");


//        if(Objects.equals(actualString, expectedString))
//        {
//            System.out.println("User is on "+actualString);
//        }

                if(actualString.equals(expectedString))
        {
            System.out.println("User is on "+actualString);
        }



        String errorPopUP2 = driver.findElement(By.cssSelector("div[role='alert'] div:nth-child(2)")).getText();
        System.out.println("Coming");
        Thread.sleep(3000);
        System.out.println(errorPopUP2);



//        if(errorPopUP.size() != 0){
//            System.out.println("Pop up is Present "+errorPopUP2);
//        }
//else   {
//                       System.out.println("Pop up is Absent");
//        }










       //driver.quit();


    }
}
