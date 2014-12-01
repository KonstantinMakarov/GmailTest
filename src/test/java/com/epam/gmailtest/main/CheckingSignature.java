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
public class CheckingSignature {

    public final static Logger logger = Logger.getLogger(CheckingSignature.class);

    private Step step;

    @BeforeClass(description = "Init browser")
    public void setStep(){
        step = new Step();
        step.initBrowser();
    }

    @Test(description = "GM#1.12", enabled = false)
    public void checkingSignature(){
        logger.info("start GM#1.12");
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.openTabGeneral();
        step.createSignature();
        Assert.assertTrue(step.isNewMessagesHasSignature());
        logger.info("finished GM#1.12");
    }

    @AfterClass(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
