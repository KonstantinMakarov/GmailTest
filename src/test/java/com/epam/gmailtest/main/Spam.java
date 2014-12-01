package com.epam.gmailtest.main;

import com.epam.gmailtest.entity.UserEnum;
import com.epam.gmailtest.step.Step;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Kanstantsin_Makarau on 12/1/2014.
 */
public class Spam {

    public final static Logger logger = Logger.getLogger(Spam.class);

    private Step step;

    @BeforeClass(description = "Init browser")
    public void setStep(){
        step = new Step();
        step.initBrowser();
    }

    @Test(description = "GM#1.1", enabled = false)
    public void user1CanMarkMessageAsSpamAndThenMessagesFromUser2WillGoToFolderSpam() {
        logger.info("start GM#1.1");
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.writeRandomMessageTo(UserEnum.User2.getEmail());  //todo thinking about rename MainPage to InboxFolderPage
        step.stopBrowser();
        step.initBrowser();

        step.loginGmail(UserEnum.User2.getEmail(), UserEnum.User2.getPassword());
        step.markMessageLikeSpam(UserEnum.User1.getEmail());
        step.stopBrowser();
        step.initBrowser();

        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.writeRandomMessageTo(UserEnum.User2.getEmail());
        step.stopBrowser();
        step.initBrowser();

        step.loginGmail(UserEnum.User2.getEmail(), UserEnum.User2.getPassword());
        boolean twoMessagesInSpamFolder = step.doWeHaveTwoMessagesInSpamFolderFrom(UserEnum.User1.getEmail());
        Assert.assertEquals(twoMessagesInSpamFolder, true);
        logger.info("finished GM#1.1");
    }

    @Test(description = "GM#1.11", enabled = false)
    public void markInboxMessagesSpamThanMarkItAsNotSpam(){
        logger.info("start GM#1.11");
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.markTopMessageLikeSpam();
        step.markMessageLike_Not_Spam();
        Assert.assertTrue(step.isMessageReturnToInbox());
        logger.info("finished GM#1.11");
    }

    @AfterClass(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
