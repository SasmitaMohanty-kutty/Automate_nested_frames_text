//package demo;

//public class Automate_frame {
  
//}
package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_frame {
    WebDriver driver;
    public Automate_frame(){
         System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public void framestext(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftElement = driver.findElement(By.tagName("body"));
        String leftText = leftElement.getText();
        System.out.println(leftText);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleElement = driver.findElement(By.tagName("body"));
        String middleText = middleElement.getText();
        System.out.println(middleText);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightElement = driver.findElement(By.tagName("body"));
        String rightText = rightElement.getText();
        System.out.println(rightText);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomElement = driver.findElement(By.tagName("body"));
        String bottomText = bottomElement.getText();
        System.out.println(bottomText);
        driver.switchTo().defaultContent();



    }
    
}
