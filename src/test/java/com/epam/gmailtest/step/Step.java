package com.epam.gmailtest.step;

import com.epam.gmailtest.page.LoginPage;
import com.epam.gmailtest.page.MainPage;
import com.epam.gmailtest.util.Util;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kanstantsin_Makarau on 10/9/2014.
 */

//todo более подробные логи
public class Step {
    public static final Logger logger = Logger.getLogger(Step.class);
    private WebDriver driver;
    private MainPage mainPage;

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void stopBrowser() {
        mainPage = null;                    //нужно ли это здесь?
        driver.quit();
        logger.info("Browser closed");
    }

    public void loginGmail(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(login, password);
    }

    private MainPage getMainPage() {
        if(null == mainPage){
            return mainPage = new MainPage(driver);
        }
        else{
            return mainPage;
        }
    }

    public void writeRandomMessageTo(String receiverLogin) {
        logger.info("try to write message..");
        getMainPage();
        mainPage.clickButtonCompose();
        mainPage.fillReceiver(receiverLogin);
        mainPage.fillSubject(Util.getRandomString(5));
        mainPage.fillMessage(Util.getRandomString(20));
        mainPage.clickButtonSend();
        logger.info("message was written");
    }

    public void markMessageLikeSpam(String email) {
        logger.info("try to mark message like spam..");
        getMainPage();
        WebElement spamMessage = mainPage.getUnreadMessagesFromUser(email).get(0);
        mainPage.tickMessage(spamMessage);
        mainPage.clickButtonToSpam();
        logger.info("message was marked");
    }

    public boolean doWeHaveTwoMessagesInSpamFolderFrom(String email) {
        logger.info("start checking spam folder..");
        getMainPage();
        mainPage.goToSpamFolder();
        List<WebElement> spammerMessages = mainPage.getUnreadMessagesFromUser(email);
        return spammerMessages.size() == 2;
    }

//    public void deleteSpamMessages() {
//        getMainPage();
//        mainPage.deleteSpamMessages();
//    }

    //----------------Task2--------------

    public void goToSettings(){
        getMainPage();
        mainPage.clickButtonSettings();
        mainPage.chooseSettingsInContextMenu();
    }

    public void chooseTabForwardingAndPOP_IMAP() {
        getMainPage();
        mainPage.chooseForwardingAndPOP_IMAP();
    }

    public void setForwardToUser3(String email) {
        getMainPage();
        mainPage.clickButtonAddAForwardingAddress();
        mainPage.addForwardLogin(email);
    }

    public void confirmForwardFromUser2(String email) {
        getMainPage();
        List<WebElement> messages = mainPage.getUnreadMessagesFromUser(email);
        messages.get(0).click();
        mainPage.clickForwardAcceptLink();

        String parentWindow = driver.getWindowHandle();
        for(String currentWindow : driver.getWindowHandles()){
            driver.switchTo().window(currentWindow);
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(
                            driver.findElement(By.xpath("//td[text()='Confirmation Success!']"))));
        logger.info("Confirmation Success");
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    public void setRadiobuttonForwardACopyOfIncomingMailTo() {
        mainPage.clickRadiobuttonForwardACopyOfIncomingMailTo();
        mainPage.clickButtonSaveChangesForwarding();
    }

    public void chooseTabFilters() {
        mainPage.clickButtonFilters();
    }

    public void createANewFilterWithSettings(String fromUser) {
        mainPage.clickButtonCreateANewFilter();
        mainPage.fillFiledFrom(fromUser);
        mainPage.tickHasAttachment();
        mainPage.clickButtonCreateFilterWithThisSearch();
        mainPage.clickButtonOkInConfirmDiscardChanges();
        mainPage.tickDeleteIt();
        mainPage.tickAlwaysMarkItAsImportant();
        mainPage.clickButtonCreateFilter();
    }

    public void writeRandomMessageWithFileAttachTo(String email, long fileSize) {
        logger.info("try to write message..");
        getMainPage();
        mainPage.clickButtonCompose();
        mainPage.fillReceiver(email);
        mainPage.fillSubject(Util.getRandomString(5));
        mainPage.fillMessage(Util.getRandomString(20));
        String filePath = Util.getFile(fileSize);
        mainPage.attachFile(filePath);
        if(fileSize < 26214401){
            mainPage.waitForLoadingFile();
            mainPage.clickButtonSend();
        }
        Util.deleteFile(filePath);
    }

    public boolean isLetterFromUser1WithAttach_InTrash_AndMarkAsImportant(String userEmail) {
        getMainPage();
        mainPage.goToBin();
        List<WebElement> trashMessages = mainPage.getUnreadMessagesFromUser(userEmail);
        return trashMessages.size() > 0 && (mainPage.isMessageMarkAsImportant(trashMessages.get(0)) &&
                                                mainPage.isMessageHasAttachment(trashMessages.get(0)));
    }

    public boolean isLetterFromUser1WithoutAttach_InInbox_NotMarkAsImportant(String userEmail) {
        getMainPage();
        mainPage.goToInbox();
        List<WebElement> inboxMessages = mainPage.getUnreadMessagesFromUser(userEmail);
        return inboxMessages.size() > 0 && (mainPage.isMessageMarkAs_Not_Important(inboxMessages.get(0)) &&
                                                (mainPage.isMessageHasAttachment(inboxMessages.get(0))==false));
    }

    public boolean isLetterFromUserWithoutAttachIsInInbox(String userEmail) {
        getMainPage();
        List<WebElement> inboxMessages = mainPage.getUnreadMessagesFromUser(userEmail);
        return inboxMessages.size() > 0 && (mainPage.isMessageHasAttachment(inboxMessages.get(0))==false);
    }

    public boolean isVisibleWarningMessageThatSizeOfFileIsBiggerThanNormal() {
        getMainPage();
        return mainPage.isVisibleAlertAttachLimit();
    }

    public void goToThemes() {
        getMainPage();
        mainPage.clickButtonSettings();
        mainPage.chooseThemesInContextMenu();
    }

    public void chooseTabThemes() {
        getMainPage();
        mainPage.clickTabThemes();
    }

    public void clickBeachTheme() {
        getMainPage();
        mainPage.clickBeachTheme();
    }

    public boolean isBackGroundChanged() {
        return mainPage.isBackGroundChanged();
    }

    public void writeRandomMessageWithEmoticonAttachTo(String email) {
        logger.info("try to write message..");
        getMainPage();
        mainPage.clickButtonCompose();
        mainPage.fillReceiver(email);
        mainPage.fillSubject(Util.getRandomString(5));
        mainPage.fillMessage(Util.getRandomString(20));
        mainPage.clickButtonEmoticon();
        mainPage.addSmiles();
        mainPage.clickButtonSend();
    }


    public boolean isLetterFromUserWithEmoticonAttach(String email) {
        logger.info("Check letter from user with emoticon attach");
        getMainPage();
        List<WebElement> messages = mainPage.getUnreadMessagesFromUser(email);

        return messages.size() > 0 && mainPage.isMessageHasSmileAttachment(messages.get(0));
    }

    public void markTopMessageLikeSpam() {
        logger.info("try to mark message like spam...");
        getMainPage();
        WebElement spamMessage = mainPage.getAllMessages().get(0);
        mainPage.tickMessage(spamMessage);
        mainPage.clickButtonToSpam();
        logger.info("message was marked");
    }

    public void markMessageLike_Not_Spam() {
        logger.info("try to mark message like NOT spam...");
        getMainPage();
        mainPage.goToSpamFolder();
        WebElement notSpamMessage = mainPage.getAllMessages().get(0);
        mainPage.tickMessage(notSpamMessage);
        mainPage.clickButton_Not_Spam();
        logger.info("message was marked");
    }


    public boolean isMessageReturnToInbox() {
        logger.info("Check message return to INBOX");
        getMainPage();
        mainPage.goToInbox();
        return mainPage.getAllMessages().get(0).isDisplayed();
    }

    public void openTabGeneral() {
        logger.info("Try to open general tab");
        getMainPage();
        mainPage.clickButtonSettings();
        mainPage.chooseSettingsInContextMenu();
        logger.info("general tab was opened");
    }

    public void createSignature() {
        logger.info("Try to create signature");
        getMainPage();
        mainPage.tickRadioButtonSignature();
        mainPage.createSignature(Util.getRandomString(15));
        mainPage.clickButtonSaveChangesGeneral();
        logger.info("Signature was created");
    }

    public boolean isNewMessagesHasSignature() {
        mainPage.clickButtonCompose();
        return mainPage.isSignatureVisible();
    }

    public void markMessageLikeStarred() {
        logger.info("Try to mark message like starred...");
        getMainPage();
        mainPage.clickOnStar();
        logger.info("Message was marked");
    }

    public boolean isMessageInStarredFolder() {
        logger.info("Check starred message:");
        getMainPage();
        mainPage.goToStarredFolder();
        return mainPage.isStarredMessageVisible();
    }

    public void clickTriangleTheLeftOfTheUsersShortcutName(String usersShortcutName) {
        logger.info("Try to click triangle the left of the users shortcut");
        getMainPage();
        mainPage.moveToShortcutButton(usersShortcutName);
        mainPage.clickTriangleOfShortcut(usersShortcutName);
        logger.info("Triangle was clicked");
    }

    public void clickAddSublable() {
        logger.info("Try to click button add Sublable");
        mainPage.clickButtonAddSublable();
    }

    public void inputNameOfInsertedShortcut(String insertedShortcutName) {
        logger.info("Try to input inserted shortcut name");
        mainPage.inputNameOfInsertedShortcut(insertedShortcutName);
        logger.info("Inserted shortcut name was entered");
    }

    public boolean isCheckBoxNEST_LABEL_UNDERChosen() {
        logger.info("Try to check NEST LABEL UNDER");
        return mainPage.isCheckBoxNEST_LABEL_UNDERChosen();
    }

    public boolean isParentShortcutEquals(String usersShortcutName) {
        logger.info("Try to check equals of parent and actual names of shortcuts");
        return mainPage.isParentShortcutEquals(usersShortcutName);
    }

    public void clickCreateShortcutButton() {
        logger.info("Try to click button CREATE");
        mainPage.clickCreateShortcutButton();
        logger.info("Button was clicked");
    }

    public boolean isInsertedShortcutVisible(String insertedShortcutName) {
        logger.info("Try to check visibility of inserted shortcut");
        return mainPage.isInsertedShortcutVisible(insertedShortcutName);
    }

    public void clickButtonLabelColor() {
        logger.info("Try to click button LABEL COLOR");
        getMainPage();
        mainPage.clickButtonLabelColor();
        logger.info("button LABEL COLOR was clicked");
    }

    public String chooseAndClickTheOneOfTheOfferedColours() {
        logger.info("Try to choose and click the one of the offered colours");
        return mainPage.clickTheOneOfTheOfferedColours();
    }

    public void chooseLabelAndItsSublabelsRadioButton() {
        logger.info("Try to click radiobutton LabelAndItsSublabels");
        mainPage.chooseLabelAndItsSublabelsRadioButton();
        logger.info("radiobutton was clicked");
    }

    public void clickButtonSetColour() {
        logger.info("Try to click button SET COLOUR");
        mainPage.clickButtonSetColour();
        logger.info("button SET COLOUR");
    }

    public boolean isBackgroundColorsOfShortCutEquals(String parentShortcutName, String backgroundColor) {
        logger.info("Check equals of background colors of shortcut");
        return mainPage.isBackgroundColorsOfShortCutEquals(parentShortcutName, backgroundColor);
    }
}
