package com.epam.lab.android.PO;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPO {
    private Wait wait;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/welcome_tour_got_it']")
    private WebElement gotIt;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/owner']")
    private WebElement owner;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/action_done']")
    private WebElement done;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/compose_button']")
    private WebElement writeEmail;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/to']")
    private WebElement to;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/subject']")
    private WebElement subject;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/body_wrapper']")
    private WebElement text;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/send']")
    private WebElement send;
    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/snackbar_main_content']")
    private WebElement emailSentNotification;

    public GmailPO(AndroidDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    public GmailPO clickGotIt(){
        gotIt.click();
        return this;
    }

    public GmailPO waitForOwnerAccountToAppear(){
        wait.until(ExpectedConditions.visibilityOf(owner));
        return this;
    }

    public GmailPO clickDone(){
        done.click();
        return this;
    }

    public GmailPO clickWriteEmail(){
        writeEmail.click();
        return this;
    }

    public GmailPO fillTo(String toText){
        to.click();
        to.sendKeys(toText);
        to.click();
        return this;
    }

    public GmailPO fillSubject(String subjectText){
        subject.sendKeys(subjectText);
        return this;
    }

    public GmailPO fillText(String textText){
        text.sendKeys(textText);
        return this;
    }

    public GmailPO clickSendEmail(){
        send.click();
        return this;
    }

    public GmailPO waitForSentEmailNotificationToDisappear(){
        wait.until(ExpectedConditions.invisibilityOf(emailSentNotification));
        return this;
    }
}
