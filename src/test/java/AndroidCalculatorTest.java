import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidCalculatorTest {
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='1']")
    private AndroidElement oneButton;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='2']")
    private AndroidElement twoButton;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='3']")
    private AndroidElement threeButton;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='+']")
    private AndroidElement plusButton;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='=']")
    private AndroidElement equalsButton;
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.android.calculator2:id/result']")
    private AndroidElement result;

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
        //wait.until(ExpectedConditions.visibilityOf(twoButton));
        //twoButton.click();
        driver.findElement(By.xpath("//*[@class='android.widget.Button' and @text='2']")).click();
        //plusButton.click();
        driver.findElement(By.xpath("//*[@class='android.widget.Button' and @text='+']")).click();
        //threeButton.click();
        driver.findElement(By.xpath("//*[@class='android.widget.Button' and @text='3']")).click();
        //equalsButton.click();
        driver.findElement(By.xpath("//*[@class='android.widget.Button' and @text='=']")).click();
        //wait.until(ExpectedConditions.visibilityOf(result));
        //Assert.assertEquals(5, Integer.parseInt(result.getText()));
        Assert.assertEquals(5, Integer.parseInt(driver.findElement(By.xpath("//*[@resource-id = 'com.android.calculator2:id/result']")).getText()));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
