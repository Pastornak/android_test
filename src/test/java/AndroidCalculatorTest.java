import com.epam.lab.android.BO.CalculatorBO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidCalculatorTest {
    AppiumDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testCalculator(){
        driver.findElement(By.xpath("//*[@class='android.widget.Button' and @text='2']")).click();
        driver.findElement(By.xpath("//*[@class='android.widget.Button' and @text='+']")).click();
        driver.findElement(By.xpath("//*[@class='android.widget.Button' and @text='3']")).click();
        driver.findElement(By.xpath("//*[@class='android.widget.Button' and @text='=']")).click();
        Assert.assertEquals(5, Integer.parseInt(driver.findElement(By.xpath("//*[@resource-id = 'com.android.calculator2:id/result']")).getText()));
    }

    @Test
    public void testCalculatorWithBO(){
        CalculatorBO calculator = new CalculatorBO((AndroidDriver) driver);
        Assert.assertEquals(calculator.typeNumber(10).add(5).divide(3).getResult(), "5");
        Assert.assertEquals(calculator.typeNumber(3).divide(2).getResult(), "1,5");
        Assert.assertEquals(calculator.typeNumber(1).multiply(3).multiply(4).getResult(), "12");
        Assert.assertEquals(calculator.typeNumber(2).multiply(3).subtract(1).divide(2).getResult(), "2,5");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
