package com.epam.gmailtest.main;


import com.epam.gmailtest.entity.UserEnum;
import com.epam.gmailtest.step.Step;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckStarSelection {

    public final static Logger logger = Logger.getLogger(CheckStarSelection.class);

    private Step step;

    @BeforeClass(description = "Init browser")
    public void setStep(){
        step = new Step();
        step.initBrowser();
    }

    @Test(description = "GM#1.13", enabled = false)
    public void checkStarSelection(){
        logger.info("start GM#1.13");
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.markMessageLikeStarred();
        Assert.assertTrue(step.isMessageInStarredFolder());
        logger.info("finished GM#1.13");
    }

    @AfterClass(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
