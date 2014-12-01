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
public class MainMailBoxPage {

    public final static Logger logger = Logger.getLogger(MainMailBoxPage.class);

    private Step step;
    private final long fileSizeMoreThan25Mb = 26214401;

    @BeforeClass(description = "Init browser")
    public void setStep(){
        step = new Step();
        step.initBrowser();
    }

    @Test(description = "GM#1.3", enabled = false)
    public void attachFileBiggerThan25Mb(){
        logger.info("start GM#1.3");
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.writeRandomMessageWithFileAttachTo(UserEnum.User2.getEmail(), fileSizeMoreThan25Mb);
        Assert.assertTrue(step.isVisibleWarningMessageThatSizeOfFileIsBiggerThanNormal());
        logger.info("finished GM#1.3");
    }

    @AfterClass(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
