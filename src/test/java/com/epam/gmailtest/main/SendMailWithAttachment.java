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
public class SendMailWithAttachment {

    public final static Logger logger = Logger.getLogger(SendMailWithAttachment.class);

    private Step step;

    @BeforeClass(description = "Init browser")
    public void setStep(){
        step = new Step();
        step.initBrowser();
    }

    @Test(description = "GM#1.5", enabled = false)
    public void sendMailWithSomeAttachedEmoticons(){
        logger.info("start GM#1.5");
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.writeRandomMessageWithEmoticonAttachTo(UserEnum.User2.getEmail());
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(UserEnum.User2.getEmail(), UserEnum.User2.getPassword());
        Assert.assertTrue(step.isLetterFromUserWithEmoticonAttach(UserEnum.User1.getEmail()));
        logger.info("finished GM#1.5");
    }

    @AfterClass(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
