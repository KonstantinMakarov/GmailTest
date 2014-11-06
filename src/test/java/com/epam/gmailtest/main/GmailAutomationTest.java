package com.epam.gmailtest.main;


import com.epam.gmailtest.step.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

//   @Test(description = "GM#1.1")
//   public void user1CanMarkMessageAsSpamAndThenMessagesFromUser2WillGoToFolderSpam() {
//        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
//        step.writeRandomMessageTo(USER2_LOGIN);
//        step.stopBrowser();
//        step.initBrowser();
//
//        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
//        step.markMessageLikeSpam(USER1_LOGIN);
//        step.stopBrowser();
//        step.initBrowser();
//
//        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
//        step.writeRandomMessageTo(USER2_LOGIN);
//        step.stopBrowser();
//        step.initBrowser();
//
//        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
//        boolean twoMessagesInSpamFolder = step.doWeHaveTwoMessagesInSpamFolderFrom(USER1_LOGIN);
//        //step.deleteSpamMessages();              //этого нет в сценари
//        Assert.assertEquals(twoMessagesInSpamFolder, true);
//   }
//
//    @Test(description = "GM#1.2")
//    public void forwardBetweenUsers(){
//        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
//        step.goToSettings();
//        step.chooseTabForwardingAndPOP_IMAP();
//        step.setForwardToUser3(USER3_LOGIN);
//        step.stopBrowser();
//
//        step.initBrowser();
//        step.loginGmail(USER3_LOGIN, USER3_PASSWORD);
//        step.confirmForwardFromUser2("forwarding-noreply@google.com");
//        step.stopBrowser();
//
//        step.initBrowser();
//        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
//        step.goToSettings();
//        step.chooseTabForwardingAndPOP_IMAP();
//        step.setRadiobuttonForwardACopyOfIncomingMailTo();
//        step.goToSettings();
//        step.chooseTabFilters();
//        step.createANewFilterWithSettings(USER1_LOGIN); //todo универсальные settings
//        step.stopBrowser();
//
//        step.initBrowser();
//        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
//        step.writeRandomMessageWithFileAttachTo(USER2_LOGIN, 1048576);
//        step.writeRandomMessageTo(USER2_LOGIN);
//        step.stopBrowser();
//
//        step.initBrowser();
//        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
//        Assert.assertTrue(step.isLetterFromUser1WithAttach_InTrash_AndMarkAsImportant(USER1_LOGIN));
//        Assert.assertTrue(step.isLetterFromUser1WithoutAttach_InInbox_NotMarkAsImportant(USER1_LOGIN));
//        step.stopBrowser();
//
//        step.initBrowser();
//        step.loginGmail(USER3_LOGIN, USER3_PASSWORD);
//        Assert.assertTrue(step.isLetterFromUserWithoutAttachIsInInbox(USER1_LOGIN));
//    }
//
//    @Test(description = "GM#1.3")
//    public void mainMailBoxPage(){
//        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
//        step.writeRandomMessageWithFileAttachTo(USER2_LOGIN, 26214401);
//        //connect 10.6.103.68:27015
//        Assert.assertTrue(step.isVisibleWarningMessageThatSizeOfFileIsBiggerThanNormal());
//    }
//
//    @Test(description = "GM#1.6")
//    public void themes(){
//        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
//        step.goToSettings();
//        step.chooseTabThemes();
//        step.clickBeachTheme();
//        Assert.assertTrue(step.isBackGroundChanged());
//    }

//    @Test(description = "GM#1.5")
//    public void sendMailWithSomeAttachedEmoticons(){
//        step.loginGmail(USER1_LOGIN, USER1_PASSWORD);
//        step.writeRandomMessageWithEmoticonAttachTo(USER2_LOGIN);
//        step.stopBrowser();
//
//        step.initBrowser();
//        step.loginGmail(USER2_LOGIN, USER2_PASSWORD);
//        Assert.assertTrue(step.isLetterFromUserWithEmoticonAttach(USER1_LOGIN));
//    }


    @AfterMethod(description = "Stop browser")
    public void tearDown(){
        step.stopBrowser();
    }
}
