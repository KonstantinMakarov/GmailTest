package com.epam.gmailtest.main;


import com.epam.gmailtest.step.Step;
import org.apache.log4j.Logger;
import org.testng.Assert;
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
    private final String parentShortcutName = "My shortcut";
    private final String insertedShortcutName = "My inserted shortcut";

    public final static Logger logger = Logger.getLogger(GmailAutomationTest.class);

    @BeforeMethod(description = "Init browser")
    public void setStep(){
        step = new Step();
        step.initBrowser();
    }

   @Test(description = "GM#1.1", enabled = false)
   public void user1CanMarkMessageAsSpamAndThenMessagesFromUser2WillGoToFolderSpam() {
        logger.info("start GM#1.1");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.writeRandomMessageTo(USER2_LOGIN);
        step.stopBrowser();
        step.initBrowser();

        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
        step.markMessageLikeSpam(USER1_LOGIN);
        step.stopBrowser();
        step.initBrowser();

        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.writeRandomMessageTo(USER2_LOGIN);
        step.stopBrowser();
        step.initBrowser();

        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
        boolean twoMessagesInSpamFolder = step.doWeHaveTwoMessagesInSpamFolderFrom(USER1_LOGIN);
        //step.deleteSpamMessages();              //этого нет в сценари
        Assert.assertEquals(twoMessagesInSpamFolder, true);
   }

    @Test(description = "GM#1.2", enabled = false)
    public void forwardBetweenUsers(){
        logger.info("start GM#1.2");
        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
        step.goToSettings();
        step.chooseTabForwardingAndPOP_IMAP();
        step.setForwardToUser3(USER3_LOGIN);
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(USER3_LOGIN, USER3_PASSWORD);
        step.confirmForwardFromUser2("forwarding-noreply@google.com");
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
        step.goToSettings();
        step.chooseTabForwardingAndPOP_IMAP();
        step.setRadiobuttonForwardACopyOfIncomingMailTo();
        step.goToSettings();
        step.chooseTabFilters();
        step.createANewFilterWithSettings(USER1_LOGIN); //todo универсальные settings
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.writeRandomMessageWithFileAttachTo(USER2_LOGIN, 1048576);
        step.writeRandomMessageTo(USER2_LOGIN);
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
        Assert.assertTrue(step.isLetterFromUser1WithAttach_InTrash_AndMarkAsImportant(USER1_LOGIN));
        Assert.assertTrue(step.isLetterFromUser1WithoutAttach_InInbox_NotMarkAsImportant(USER1_LOGIN));
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(USER3_LOGIN, USER3_PASSWORD);
        Assert.assertTrue(step.isLetterFromUserWithoutAttachIsInInbox(USER1_LOGIN));
    }

    @Test(description = "GM#1.3", enabled = false)
    public void mainMailBoxPage(){
        logger.info("start GM#1.3");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.writeRandomMessageWithFileAttachTo(USER2_LOGIN, 26214401);
        //connect 10.6.103.68:27015
        Assert.assertTrue(step.isVisibleWarningMessageThatSizeOfFileIsBiggerThanNormal());
    }

    @Test(description = "GM#1.5", enabled = false)
    public void sendMailWithSomeAttachedEmoticons(){
        logger.info("start GM#1.5");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.writeRandomMessageWithEmoticonAttachTo(USER2_LOGIN);
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
        Assert.assertTrue(step.isLetterFromUserWithEmoticonAttach(USER1_LOGIN));
    }

    @Test(description = "GM#1.6", enabled = false)
    public void themes(){
        logger.info("start GM#1.6");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.goToSettings();
        step.chooseTabThemes();
        step.clickBeachTheme();
        Assert.assertTrue(step.isBackGroundChanged());
    }

    @Test(description = "GM#1.8", enabled = false)      //увести мышку из браузера
    public void createShortcut(){
        logger.info("start GM#1.8");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.clickTriangleTheLeftOfTheUsersShortcutName(parentShortcutName);
        step.clickAddSublable();
        step.inputNameOfInsertedShortcut(insertedShortcutName);
        Assert.assertTrue(step.isCheckBoxNEST_LABEL_UNDERChosen());
        Assert.assertTrue(step.isParentShortcutEquals(parentShortcutName));
        step.clickCreateShortcutButton();
        Assert.assertTrue(step.isInsertedShortcutVisible(insertedShortcutName));
    }

    @Test(description = "GM#1.9", enabled = false)
    public void changeShortcut(){
        logger.info("GM#1.9");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.clickTriangleTheLeftOfTheUsersShortcutName(parentShortcutName);
        step.clickButtonLabelColor();
        String backgroundColor = step.chooseAndClickTheOneOfTheOfferedColours();
        step.chooseLabelAndItsSublabelsRadioButton();
        step.clickButtonSetColour();
        Assert.assertTrue(step.isBackgroundColorsOfShortCutEquals(parentShortcutName, backgroundColor));
    }

    @Test(description = "GM#1.10")
    public void deleteShortcut (){
        logger.info("GM#1.10");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
    }

    @Test(description = "GM#1.11", enabled = false)
    public void markInboxMessagesSpamThanMarkItAsNotSpam(){
        logger.info("start GM#1.11");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.markTopMessageLikeSpam();
        step.markMessageLike_Not_Spam();
        Assert.assertTrue(step.isMessageReturnToInbox());
    }

    @Test(description = "GM#1.12", enabled = false)
    public void checkingSignature(){
        logger.info("start GM#1.12");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.openTabGeneral();
        step.createSignature();
        Assert.assertTrue(step.isNewMessagesHasSignature());
    }

    @Test(description = "GM#1.13", enabled = false)
    public void checkStarSelection(){
        logger.info("start GM#1.13");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.markMessageLikeStarred();
        Assert.assertTrue(step.isMessageInStarredFolder());
    }

    @AfterMethod(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
