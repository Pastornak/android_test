package com.epam.lab.android.BO;

import com.epam.lab.android.PO.GmailPO;
import io.appium.java_client.android.AndroidDriver;

public class GmailBO {
    private GmailPO gmailPO;

    public GmailBO(AndroidDriver driver){
        gmailPO = new GmailPO(driver);
    }

    public GmailBO signIn(){
        gmailPO.clickGotIt().waitForOwnerAccountToAppear().clickDone();
        return this;
    }

    public GmailBO writeEmail(String to, String subject, String text){
        gmailPO.clickWriteEmail().fillTo(to).fillSubject(subject).fillText(text);
        return this;
    }

    public GmailBO sendWrittenEMail(){
        gmailPO.clickSendEmail().waitForSentEmailNotificationToDisappear();
        return this;
    }
}
