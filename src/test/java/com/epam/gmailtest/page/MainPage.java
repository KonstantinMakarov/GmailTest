package com.epam.gmailtest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;


/**
 * Created by Kanstantsin_Makarau on 10/9/2014.
 */
public class MainPage {
    private WebDriver driver;
    public static final Logger logger = Logger.getLogger(MainPage.class);


    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement buttonCompose;

    @FindBy(xpath = "//textarea[@class='vO']")
    private WebElement inputMessageReceiver;

    @FindBy(xpath = "//input[@class='aoT']")
    private WebElement inputMessageSubject;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement inputMessageText;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement buttonSend;

    @FindBy(xpath = "//div[@role='main']//tr[@class='zA zE']")
    private WebElement unreadMessage;

    @FindBy(xpath = "//div[@role='main']//tr[@class='zA yO']")
    private WebElement readMessage;

    @FindBy(xpath = "//div[@role='main']//tr[@class='zA yO'] | //div[@role='main']//tr[@class='zA zE']")
    private List<WebElement> allMessages;

    @FindBy(css = "div.T-Jo-auh")
    private WebElement checkBox;

    @FindBy(css = "div.asl.T-I-J3.J-J5-Ji")
    private WebElement buttonToSpam;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aFk T-I-ax7   ar7']")
    private WebElement button_Not_Spam;

    @FindBy(xpath = "//div[text()='Delete forever/..'")
    private WebElement buttonDelete;

    @FindBy(xpath = "//input[@class='gbqfif']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@class='gbqfb']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji ash T-I-ax7 L3']")
    private WebElement buttonSettings;

    @FindBy(xpath = "//div[@class='J-N aMS']")
    private WebElement buttonSettingsInner;

    @FindBy(xpath = "//a[text()='Forwarding and POP/IMAP']")
    private WebElement buttonForwardingAndPOP_IMAP;

    @FindBy(xpath = "//input[@value='Add a forwarding address']")
    private WebElement buttonAddAForwardingAddress;

    @FindBy(xpath = "//div[@class='Kj-JD-Jz' and contains(text(), 'a new forwarding email')]//input[@id]")
    private WebElement inputForwardLogin;

    @FindBy(xpath = "//button[@class='J-at1-auR']")
    private WebElement buttonNextInAddForwardingAddress;

    @FindBy(xpath = "//input[@value='Proceed']")
    private WebElement buttonProceedInAddForwardingAddress;

    @FindBy(xpath = "//button[@class='J-at1-auR']")
    private WebElement buttonOKInAddForwardingAddress;

    @FindBy(xpath = "(//a[contains(text(), 'isolated')])[1]")
    private WebElement linkToAcceptForward;

    @FindBy(xpath = "//span[text()='Forward a copy of incoming mail to ']/../..//input")
    private WebElement radiobuttonForwardACopyOfIncomingMailTo;

    @FindBy(xpath = "//div[@class='nH Tv1JD']//button[@guidedhelpid='save_changes_button']")
    private WebElement buttonSaveChanges;

    @FindBy(xpath = "//div[contains(text(), 'You are forwarding')]")
    private WebElement noticeYouAreForwardingYourEMail;

    @FindBy(xpath = "//a[text()='Filters']")
    private WebElement buttonFilters;

    @FindBy(xpath = "//span[@class='sA' and text()='Create a new filter']")
    private WebElement buttonCreateANewFilter;

    @FindBy(xpath = "//input[@class='ZH nr aQa']")
    private WebElement inputFilterFrom;

    @FindBy(xpath = "//label[text()='Has attachment']/../input")
    private WebElement checkBoxFilterHasAttachment;

    @FindBy(xpath = "//div[@class='acM']")
    private WebElement buttonCreateFilterWithThisSearch;

    @FindBy(xpath = "//label[text()='Delete it']/../input")
    private WebElement checkBoxFilterDeleteIt;

    @FindBy(xpath = "//label[text()='Always mark it as important']/../input")
    private WebElement checkBoxFilterAlwaysMarkItAsImportant;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji Zx acL T-I-atl L3']")
    private WebElement buttonCreateFilter;

    @FindBy(xpath = "//button[@class='J-at1-auR J-at1-atl' and @name='ok']")
    private WebElement buttonOkInConfirmDiscardChanges;

    @FindBy(xpath = "//div[@class='a1 aaA aMZ']")
    private WebElement buttonAttachFiles;

    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#inbox']")
    private WebElement buttonInbox;

    @FindBy(xpath = "//span[@class='Kj-JD-K7-K0']")
    private WebElement errorAttachAlert;

    @FindBy(xpath = "//div[@class='J-N-Jz' and text()='Themes'] ")
    private WebElement themesInContextMenu;

    @FindBy(xpath = "//a[text()='Themes']")
    private WebElement themesInSettings;

    @FindBy(xpath = "//div[@class='J-awr'] and text()='Display density'")
    private WebElement downDropList;

    @FindBy(xpath = "//div[@class='fZ']/a[text()='General']")
    private WebElement generalFormSettingsVisible;

    @FindBy(xpath = "//span[text()='Beach']")
    private WebElement beachTheme;

    @FindBy(xpath = "//img[@class='ao0' and contains(@src, 'themes/beach2/bg_thu2')]")
    private WebElement beachBackGround;

    @FindBy(xpath = "//div[@command='+emoticon']")
    private WebElement buttonEmoticon;

    @FindBy(xpath = "(//div[@goomoji='338'])[1]")
    private WebElement smileYellowLaughInCompose;

    @FindBy(xpath = "(//img[@goomoji='338'])[1]")
    private WebElement smileYellowLaughInMessage;

    @FindBy(xpath = "(//div[@goomoji='333'])[1]")
    private WebElement smilePinkLaughInCompose;

    @FindBy(xpath = "(//img[@goomoji='333'])[1]")
    private WebElement smilePinkLaughInMessage;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-atl L3' and text()='Insert']")
    private WebElement buttonInsert;

    private final String labelImportant = "(//div[@class='pH'])[1]";

    private final String label_Not_Important = "(//div[@class='pH-A7'])[1]";

    private final String labelHasAttach = "(//img[@alt='Attachment'])[1]";

    private Robot robot = null;



    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void deleteSpamMessages() {
        //todo почистить за собой
        logger.info("try to delete messages from our spammer...");
        List<WebElement> readMessages = readMessage.findElements(By.xpath("//span[@email='epamlab.user1@gmail.com']"));
        for(WebElement currentMessage : readMessages){
            currentMessage.findElement(By.xpath("/../..//td[@class='oZ-x3 xY']")).click();      //Spam checkbox !НЕ РАБОТАЕТ!
        }
        buttonDelete.click();
        logger.info("Spam messages from our spammer was deleted");
    }

    public void clickButtonCompose() {
        logger.info("try to click button Compose...");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonCompose));
        buttonCompose.click();
        logger.info("button compose is clicked");
    }

    public void fillReceiver(String receiverLogin) {
        logger.info("try to fill receiver field...");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(inputMessageReceiver));
        inputMessageReceiver.sendKeys(receiverLogin);
        logger.info("receiver field is filled");
    }

    public void fillSubject(String subject) {
        logger.info("try to fill subject field...");
        inputMessageSubject.sendKeys(subject);
        logger.info("subject field is filled");
    }

    public void fillMessage(String message) {
        logger.info("try to fill message field...");

        inputMessageText.sendKeys(message);

        logger.info("message field is filled");
    }

    public void clickButtonSend() {
        logger.info("try to click button Send...");
        buttonSend.click();
        logger.info("button send is clicked");
    }

    public void tickMessageInInbox(WebElement message) {

        logger.info("try to tick message...");

        message.findElement(By.xpath("(//td[@class='oZ-x3 xY'])[1]")).click();  //Inbox checkbox
        logger.info("message is ticked");
    }

    public void tickMessageInSpam(WebElement message) {

        logger.info("try to tick message...");

        message.findElement(By.xpath("(//div[@class='oZ-jc T-Jo J-J5-Ji'])[1]")).click();  //Inbox checkbox
        logger.info("message is ticked");
    }

    public void clickButtonToSpam() {
        logger.info("try to click button ToSpam...");
        buttonToSpam.click();
        logger.info("button ToSpam is clicked");
    }

    public void goToSpamFolder() {
        logger.info("try to GoToSpamFolder...");
        inputSearch.sendKeys("in:spam");
        buttonSearch.click();
        logger.info("in SpamFolder");
    }

    public List<WebElement> getUnreadMessagesFromUser(String email) {
        StringBuilder xpathEmail = new StringBuilder();
        xpathEmail.append("//span[@email='").append(email).append("']/../../..");

        logger.info("try to find messages from user...");
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(unreadMessage.findElement(By.xpath(xpathEmail.toString()))));
        List<WebElement> unreadMessages = unreadMessage.findElements(By.xpath(xpathEmail.toString()));
        logger.info("found: " + unreadMessages.size() + " messages");

        return unreadMessages;
    }

    public void clickButtonSettings() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonSettings));
        buttonSettings.click();
    }

    public void chooseSettingsInContextMenu() {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(buttonSettingsInner));
        buttonSettingsInner.click();
    }

    public void chooseForwardingAndPOP_IMAP() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(buttonForwardingAndPOP_IMAP));
        buttonForwardingAndPOP_IMAP.click();
    }

    public void clickButtonAddAForwardingAddress() {
        buttonAddAForwardingAddress.click();
    }

    public void addForwardLogin(String email) {
        inputForwardLogin.sendKeys(email);
        buttonNextInAddForwardingAddress.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ds']")));
        buttonProceedInAddForwardingAddress.click();
        driver.switchTo().defaultContent();
        buttonOKInAddForwardingAddress.click();
    }

    public void clickForwardAcceptLink() {
        linkToAcceptForward.click();
    }

    public void clickRadiobuttonForwardACopyOfIncomingMailTo() {
        radiobuttonForwardACopyOfIncomingMailTo.click();
    }

    public void clickButtonSaveChanges() {
        buttonSaveChanges.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(noticeYouAreForwardingYourEMail));
    }

    public void clickButtonFilters() {
        buttonFilters.click();
    }

    public void clickButtonCreateANewFilter() {
        buttonCreateANewFilter.click();
    }

    public void fillFiledFrom(String fromUser) {
        inputFilterFrom.sendKeys(fromUser);
    }

    public void tickHasAttachment() {
        checkBoxFilterHasAttachment.click();
    }

    public void clickButtonCreateFilterWithThisSearch() {
        buttonCreateFilterWithThisSearch.click();
    }

    public void tickDeleteIt() {
        checkBoxFilterDeleteIt.click();
    }

    public void tickAlwaysMarkItAsImportant() {
        checkBoxFilterAlwaysMarkItAsImportant.click();
    }

    public void clickButtonCreateFilter() {
        buttonCreateFilter.click();
    }

    public void clickButtonOkInConfirmDiscardChanges() {
        try{
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(buttonOkInConfirmDiscardChanges));
            buttonOkInConfirmDiscardChanges.click();
        }
        catch(TimeoutException e){
            logger.info("Confirm discard changes is invisible. Try to go on...");
        }
        catch(NoSuchElementException e){
            logger.info("Confirm discard changes is invisible. Try to go on...");
        }
    }

    public void attachFile(String filePath) {
        logger.info(filePath);
        buttonAttachFiles.click();
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        try {
            robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        } catch (AWTException e) {
            logger.error("JavaRobot problems");
        }
    }

    public void goToBin() {
        inputSearch.sendKeys("in:trash ");

        buttonSearch.click();
    }

    public boolean isMessageMarkAsImportant(WebElement message) {
        try {
            new WebDriverWait(driver, 5
            ).until(ExpectedConditions.visibilityOf(message.findElement(By.xpath(labelImportant))));
        }
        catch (TimeoutException e){
            return false;
        }
        catch(NoSuchElementException e){
            return false;
        }
        return true;
    }

    public void goToInbox() {
        buttonInbox.click();
    }

    public boolean isMessageMarkAs_Not_Important(WebElement message) {
        try {
            new WebDriverWait(driver, 5
                ).until(ExpectedConditions.visibilityOf(message.findElement(By.xpath(label_Not_Important))));
        }
        catch (TimeoutException e){
            return false;
        }
        catch(NoSuchElementException e){
            return false;
        }
        return true;
    }

    public boolean isMessageHasAttachment(WebElement message) {
        try {
            new WebDriverWait(driver, 5
            ).until(ExpectedConditions.visibilityOf(message.findElement(By.xpath(labelHasAttach))));
        }
        catch (TimeoutException e) {
            return false;
        }
        catch(NoSuchElementException e){
            return false;
        }
        return true;
    }

    public boolean isVisibleAlertAttachLimit() {
        try{
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(errorAttachAlert));
        }
        catch(TimeoutException e){
            return false;
        }
        catch(NoSuchContextException e){
            return false;
        }
        return true;
    }

    public void waitForLoadingFile() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='dQ']")));
    }

    public void chooseThemesInContextMenu() {
        themesInContextMenu.click();
    }

    public void clickTabThemes() {
        themesInSettings.click();
    }

    public boolean isDownDropListVisible() {
        return downDropList.isDisplayed();
    }

    public boolean isGeneralFormSettingsVisible() {
        return generalFormSettingsVisible.isDisplayed();
    }

    public void clickBeachTheme() {
        beachTheme.click();
    }

    public boolean isBackGroundChanged() {
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(beachBackGround));
        }
        catch (TimeoutException e){
            logger.info("beachBackGround is not found");
            return false;
        }
        catch (NoSuchContextException e){
            logger.info("beachBackGround is not found");
            return false;
        }
        return true;
    }

    public void clickButtonEmoticon() {
        buttonEmoticon.click();
    }

    public void addSmiles() {
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_SHIFT);
            smileYellowLaughInCompose.click();
            smilePinkLaughInCompose.click();
            robot.keyRelease(KeyEvent.VK_SHIFT);
            buttonInsert.click();
        } catch (AWTException e) {
            logger.info("JavaRobot fail");
        }
    }


    public boolean isMessageHasSmileAttachment(WebElement message) {
        if(!isMessageHasAttachment(message)) return false;
        message.click();
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(smilePinkLaughInMessage));
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(smileYellowLaughInMessage));
        }
        catch(TimeoutException e){
            logger.info("smile not found");
        }
        catch(NoSuchContextException e){
            logger.info("smile not found");
        }
        return true;
    }

    public List<WebElement> getAllMessages() {
        List<WebElement> allMessages = unreadMessage.findElements(By.xpath("."));
        allMessages.addAll(readMessage.findElements(By.xpath(".")));
        return allMessages;
    }

    public void clickButton_Not_Spam() {
        button_Not_Spam.click();
    }
}