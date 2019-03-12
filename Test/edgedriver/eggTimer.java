package edgedriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import static java.lang.Thread.*;

public class eggTimer {
    WebDriver obj;

    @Before
    public void setup() {

        System.setProperty("webdriver.ie.driver", "C:\\MicrosoftWebDriver.exe");
        obj = new InternetExplorerDriver();
        obj.manage().window().maximize();
    }


    @Test
    public void countdownTimer() throws InterruptedException {

        /*
        Example:Integration tests
        enter "3 seconds" in the textfield
        press "Go"
        after 3 seconds a popup should appear with the text "Time Expired!"
         */
        obj.get("http://e.ggtimer.com/");
        WebElement startTimer= obj.findElement(By.xpath("//input[@name='start_a_timer']"));
        startTimer.clear();
        startTimer.sendKeys("3 seconds");
         obj.findElement(By.xpath(("//input[@id='timergo']"))).click();
        Thread.sleep(6000);
        Alert popup = obj.switchTo().alert();
        String alertMessage;
        alertMessage = obj.switchTo().alert().getText();
        obj.switchTo().alert().getText();
        System.out.println(alertMessage);
        popup.accept();
        /*
        Test case :3
        */
        obj.navigate().back();
        WebElement optionsBeta = obj.findElement(By.xpath(("//a[@class='strong']")));
        optionsBeta.click();
        Thread.sleep(1000);
        WebElement alertBoxOff = obj.findElement(By.xpath("//*[@id='options']/form/ul[3]/li[2]/input"));
        alertBoxOff.click();
        WebElement applyButton= obj.findElement(By.xpath("//a[@class='simplemodal-close']"));
        Thread.sleep(6000);
        applyButton.click();
        startTimer = obj.findElement(By.xpath("//input[@name='start_a_timer']"));

        startTimer.clear();
        startTimer.sendKeys("50 seconds");
        obj.findElement(By.xpath(("//input[@id='timergo']"))).click();
        //Thread.sleep(6000);

        WebDriverWait wait = new WebDriverWait(obj, 50);
        try{
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = obj.switchTo().alert();
            alert.accept();
        }
        catch (Exception e){
            System.out.println("No alert");
        }
        /*
        Test case :4
         */
        obj.navigate().back();
        optionsBeta = obj.findElement(By.xpath(("//a[@class='strong']")));
        optionsBeta.click();
        Thread.sleep(1000);
        alertBoxOff = obj.findElement(By.xpath("//*[@id='options']/form/ul[3]/li[2]/input"));
        alertBoxOff.click();
        applyButton= obj.findElement(By.xpath("//a[@class='simplemodal-close']"));
        Thread.sleep(6000);
        applyButton.click();
        String ExampleUsageLink=Keys.chord(Keys.CONTROL,Keys.RETURN);
        obj.findElement(By.xpath(("//a[@title='1 hour timer']"))).sendKeys(ExampleUsageLink);
        ArrayList<String> tabs =new ArrayList<>(obj.getWindowHandles());
        obj.switchTo().window(tabs.get(1));

    }
    @After
    public void shutDown()
    {
        obj.quit();
    }
}










