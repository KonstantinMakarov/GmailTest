package com.epam.gmailtest.main;


import com.epam.gmailtest.step.Step;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    private final String gmailAutoReply = "forwarding-noreply@google.com";
    private final long fileSize = 1048576;
    private final long fileSizeMoreThan25Mb = 26214401;

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
        step.writeRandomMessageTo(USER2_LOGIN);                 //todo thinking about rename MainPage to InboxFolderPage
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
        Assert.assertEquals(twoMessagesInSpamFolder, true);
       logger.info("finished GM#1.1");
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
        step.confirmForwardFromUser2(gmailAutoReply);
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
        step.goToSettings();
        step.chooseTabForwardingAndPOP_IMAP();
        step.setRadiobuttonForwardACopyOfIncomingMailTo();
        step.goToSettings();
        step.chooseTabFilters();
        step.createANewFilterWithSettings(USER1_LOGIN);
        step.stopBrowser();

        step.initBrowser();
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.writeRandomMessageWithFileAttachTo(USER2_LOGIN, fileSize);
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
        logger.info("finished GM#1.2");
    }

    @Test(description = "GM#1.3", enabled = false)
    public void mainMailBoxPage(){
        logger.info("start GM#1.3");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.writeRandomMessageWithFileAttachTo(USER2_LOGIN, fileSizeMoreThan25Mb);
        Assert.assertTrue(step.isVisibleWarningMessageThatSizeOfFileIsBiggerThanNormal());
        logger.info("finished GM#1.3");
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
        logger.info("finished GM#1.5");
    }

    @Test(description = "GM#1.6", enabled = false)
    public void themes(){
        logger.info("start GM#1.6");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.goToSettings();
        step.chooseTabThemes();
        step.clickBeachTheme();
        Assert.assertTrue(step.isBackGroundChanged());
        logger.info("finished GM#1.6");
    }

    @Test(description = "GM#1.8", enabled = false)
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
        logger.info("finished GM#1.8");
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
        logger.info("finished GM#1.9");
    }

    @Test(description = "GM#1.10", enabled = false)
    public void deleteShortcut (){
        logger.info("start GM#1.10");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.clickTriangleTheLeftOfTheUsersShortcutName(parentShortcutName);
        step.clickRemoveLabel();
        Assert.assertTrue(step.areBothShortcutsPresentedInDialog(parentShortcutName, insertedShortcutName));
        step.clickDeleteButton();
        Assert.assertTrue(step.areBothShortcutsDeleted(parentShortcutName));
        logger.info("finished GM#1.10");
    }

    @Test(description = "GM#1.11", enabled = false)
    public void markInboxMessagesSpamThanMarkItAsNotSpam(){
        logger.info("start GM#1.11");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.markTopMessageLikeSpam();
        step.markMessageLike_Not_Spam();
        Assert.assertTrue(step.isMessageReturnToInbox());
        logger.info("finished GM#1.11");
    }

    @Test(description = "GM#1.12", enabled = false)
    public void checkingSignature(){
        logger.info("start GM#1.12");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.openTabGeneral();
        step.createSignature();
        Assert.assertTrue(step.isNewMessagesHasSignature());
        logger.info("finished GM#1.12");
    }

    @Test(description = "GM#1.13", enabled = false)
    public void checkStarSelection(){
        logger.info("start GM#1.13");
        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
        step.markMessageLikeStarred();
        Assert.assertTrue(step.isMessageInStarredFolder());
        logger.info("finished GM#1.13");
    }

    @AfterMethod(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
