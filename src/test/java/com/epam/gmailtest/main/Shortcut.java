package com.epam.gmailtest.main;

import com.epam.gmailtest.entity.UserEnum;
import com.epam.gmailtest.step.Step;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Kanstantsin_Makarau on 12/1/2014.
 */
public class Shortcut {

    public final static Logger logger = Logger.getLogger(Shortcut.class);

    private Step step;
    private final String parentShortcutName = "My shortcut";
    private final String insertedShortcutName = "My inserted shortcut";

    @BeforeClass(description = "Init Step")
    public void setStep(){
        step = new Step();
    }

    @BeforeMethod(description = "Init browser")
    public void setUp(){
        step.initBrowser();
    }

    @Test(description = "GM#1.8", enabled = false)
    public void createShortcut(){
        logger.info("start GM#1.8");
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.clickTriangleTheLeftOfTheUsersShortcutName(parentShortcutName);
        step.clickAddSublable();
        step.inputNameOfInsertedShortcut(insertedShortcutName);
        Assert.assertTrue(step.isCheckBoxNEST_LABEL_UNDERChosen());
        Assert.assertTrue(step.isParentShortcutEquals(parentShortcutName));
        step.clickCreateShortcutButton();
        Assert.assertTrue(step.isInsertedShortcutVisible(insertedShortcutName));
        logger.info("finished GM#1.8");
    }

    @Test(description = "GM#1.9", dependsOnMethods = {"createShortcut"}, enabled = false)
    public void changeShortcut(){
        logger.info("GM#1.9");
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.clickTriangleTheLeftOfTheUsersShortcutName(parentShortcutName);
        step.clickButtonLabelColor();
        String backgroundColor = step.chooseAndClickTheOneOfTheOfferedColours();
        step.chooseLabelAndItsSublabelsRadioButton();
        step.clickButtonSetColour();
        Assert.assertTrue(step.isBackgroundColorsOfShortCutEquals(parentShortcutName, backgroundColor));
        logger.info("finished GM#1.9");
    }

    @Test(description = "GM#1.10", dependsOnMethods = {"changeShortcut"}, enabled = false)
    public void deleteShortcut (){
        logger.info("start GM#1.10");
        step.loginGmail(UserEnum.User1.getEmail(), UserEnum.User1.getPassword());
        step.clickTriangleTheLeftOfTheUsersShortcutName(parentShortcutName);
        step.clickRemoveLabel();
        Assert.assertTrue(step.areBothShortcutsPresentedInDialog(parentShortcutName, insertedShortcutName));
        step.clickDeleteButton();
        Assert.assertTrue(step.areBothShortcutsDeleted(parentShortcutName));
        logger.info("finished GM#1.10");
    }

    @AfterMethod(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
