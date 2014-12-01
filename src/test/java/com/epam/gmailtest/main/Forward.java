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
public class Forward {

    public final static Logger logger = Logger.getLogger(Forward.class);

    private Step step;
    private final String gmailAutoReply = "forwarding-noreply@google.com";
    private final long fileSize = 1048576;

    @BeforeClass(description = "Init browser")
    public void setStep(){
        step = new Step();
        step.initBrowser();
    }

    @Test(description = "GM#1.2", enabled = false)
    public void forwardBetweenUsers(){
        logger.info("start GM#1.2");
        step.loginGmail(UserEnum.User2.getEmail(), UserEnum.User2.getPassword());
        step.goToSettings();
        step.chooseTabForwardingAndPOP_IMAP();
        step.setForwardToUser3(UserEnum.User3.getEmail());
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(UserEnum.User3.getEmail(), UserEnum.User3.getPassword());
        step.confirmForwardFromUser2(gmailAutoReply);
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(UserEnum.User2.getEmail(), UserEnum.User2.getPassword());
        step.goToSettings();
        step.chooseTabForwardingAndPOP_IMAP();
        step.setRadiobuttonForwardACopyOfIncomingMailTo();
        step.goToSettings();
        step.chooseTabFilters();
        step.createANewFilterWithSettings(UserEnum.User1.getEmail());
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.writeRandomMessageWithFileAttachTo(UserEnum.User2.getEmail(), fileSize);
        step.writeRandomMessageTo(UserEnum.User2.getEmail());
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(UserEnum.User2.getEmail(), UserEnum.User2.getPassword());
        Assert.assertTrue(step.isLetterFromUser1WithAttach_InTrash_AndMarkAsImportant(UserEnum.User1.getEmail()));
        Assert.assertTrue(step.isLetterFromUser1WithoutAttach_InInbox_NotMarkAsImportant(UserEnum.User1.getEmail()));
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(UserEnum.User3.getEmail(), UserEnum.User3.getPassword());
        Assert.assertTrue(step.isLetterFromUserWithoutAttachIsInInbox(UserEnum.User1.getEmail()));
        logger.info("finished GM#1.2");
    }

    @AfterClass(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
