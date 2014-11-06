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
        logger.info("try to write message...");
        getMainPage();
        mainPage.clickButtonCompose();
        mainPage.fillReceiver(receiverLogin);
        mainPage.fillSubject(Util.getRandomString(5));
        mainPage.fillMessage(Util.getRandomString(20));
        mainPage.clickButtonSend();
        logger.info("message was written");
    }

    public void markMessageLikeSpam(String email) {
        logger.info("try to mark message like spam...");
        getMainPage();
        WebElement spamMessage = mainPage.getUnreadMessagesFromUser(email).get(0);
        mainPage.tickMessageFromSpammer(spamMessage);
        mainPage.clickButtonToSpam();
        logger.info("message was marked");
    }

    public boolean doWeHaveTwoMessagesInSpamFolderFrom(String email) {
        logger.info("start checking spam folder...");
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
        mainPage.clickButtonSaveChanges();
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
        logger.info("try to write message...");
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
        getMainPage();
        List<WebElement> messages = mainPage.getUnreadMessagesFromUser(email);

        return messages.size() > 0 && mainPage.isMessageHasSmileAttachment(messages.get(0));
    }
}
