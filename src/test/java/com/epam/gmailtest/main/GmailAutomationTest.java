package com.epam.gmailtest.main;


import com.epam.gmailtest.step.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Kanstantsin_Makarau on 10/9/2014.
 */
public class GmailAutomationTest {
    private Step step;
    private final String USER1_LOGIN = "epamlab.user1@gmail.com";
    private final String USER1_PASSWORD = "labuser1";
    private final String USER2_LOGIN = "epamlab.user2@gmail.com";
    private final String USER2_PASSWORD = "labuser2";
    private final String USER3_LOGIN = "epamlab.user3@gmail.com";
    private final String USER3_PASSWORD = "labuser3";

    @BeforeMethod(description = "Init browser")
    public void setStep(){
        step = new Step();
        step.initBrowser();
    }

    @Test
    public void user1CanMarkMessageAsSpamAndThenMessagesFromUser2WillGoToFolderSpam() throws InterruptedException {
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.writeMessage(USER2_LOGIN);
        step.stopBrowser();
        step.initBrowser();
        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
    }

    @AfterMethod(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
