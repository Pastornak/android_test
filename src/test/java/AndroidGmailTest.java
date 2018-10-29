import com.epam.lab.android.BO.GmailBO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidGmailTest {
    private AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage", "com.google.android.gm");
        capabilities.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testGmailBO(){
        GmailBO gmail = new GmailBO((AndroidDriver)driver);
        gmail.signIn()
                .writeEmail("yurapaster@gmail.com", "Android Test", "Sent by Android test")
                .sendWrittenEMail();
    }

    @Test
    public void testGmail() {
        findByResourceID("com.google.android.gm:id/welcome_tour_got_it").click();
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//*[@resource-id='com.google.android.gm:id/owner']")));
        findByResourceID("com.google.android.gm:id/action_done").click();
        findByResourceID("com.google.android.gm:id/compose_button").click();
        findByResourceID("com.google.android.gm:id/to").click();
        findByResourceID("com.google.android.gm:id/to").sendKeys("yurapaster@gmail.com");
        findByResourceID("com.google.android.gm:id/to").click();
        findByResourceID("com.google.android.gm:id/subject").sendKeys("Android Test");
        findByResourceID("com.google.android.gm:id/body_wrapper").sendKeys("Sent by Android test");
        findByResourceID("com.google.android.gm:id/send").click();
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.invisibilityOf(
                findByResourceID("com.google.android.gm:id/snackbar_main_content")));
    }

    private WebElement findByResourceID(String id){
        return driver.findElement(By.xpath("//*[@resource-id='" + id + "']"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
