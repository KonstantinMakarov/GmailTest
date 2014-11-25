package com.epam.gmailtest.page;

import com.epam.gmailtest.util.Util;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

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

    @FindBy(css = "div.T-Jo-auh")
    private WebElement checkBox;

    @FindBy(css = "div.asl.T-I-J3.J-J5-Ji")
    private WebElement buttonToSpam;

    @FindBy(xpath = "//div[@role='button' and text()='Not spam']")
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
    private WebElement buttonSaveChangesForwarding;

    @FindBy(xpath = "//div[@class='nH f2 hCyPr']//button[@guidedhelpid='save_changes_button']")
    private WebElement buttonSaveChangesGeneral;

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

    @FindBy(xpath = "//a[@class='J-Ke n0' and contains(@href, '#inbox')]")
    private WebElement buttonInbox;

    @FindBy(xpath = "//span[@class='Kj-JD-K7-K0']")
    private WebElement errorAttachAlert;

    @FindBy(xpath = "//div[@class='J-N-Jz' and text()='Themes'] ")
    private WebElement themesInContextMenu;

    @FindBy(xpath = "//a[text()='Themes']")
    private WebElement themesInSettings;

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

    @FindBy(xpath = "//div[@role='main']//tr[@class='zA zE' or @class='zA yO']")
    private List<WebElement> allMessages;

    @FindBy(xpath = "//span[@class='x2']")
    private WebElement deleteAllSpamMessageNow;

    @FindBy(xpath = "(//input[@name='sx_sg'])[2]")
    private WebElement radioButtonSignature;

    @FindBy(xpath = "(//div[@class='Am Al editable Xp0HJf-LW-avf'])[1]")
    private WebElement signatureTextAria;

    @FindBy(xpath = "//div[@class='gmail_signature']")
    private WebElement signature;

    @FindBy(xpath = "(//div[@role='main']//span[@class='aXw T-KT'])[1]")
    private WebElement star;

    @FindBy(xpath = "//a[@class='J-Ke n0' and contains(@href, '#starred')]")
    private WebElement starredFolder;

    @FindBy(xpath = "//div[text()='Add sublabel']")
    private WebElement buttonAddSublabel;

    @FindBy(xpath = "//input[@class='xx']")
    private WebElement inputNameOfInsertedShortcutField;

    @FindBy(xpath = "//input[@class='ajJ' and @value='1']")
    private WebElement CheckBoxNEST_LABEL_UNDERIsChosen;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement buttonCreateInsertedShortcut;

    @FindBy(xpath = "//a[@title='My inserted shortcut']")
    private WebElement buttonInsertedShortcut;

    @FindBy(xpath = "//div[@class='J-N-Jz']/span/..")
    private WebElement buttonLabelColour;

    @FindBy(xpath = "(//td[@id='JA-Kn-Jr-Kw-Jn0']/div)[1]")
    private WebElement firstOfOfferedColours;

    @FindBy(xpath = "//label[contains(text(), 'Label ')]/../input")
    private WebElement radioButtonLabelAndItsSublabels;

    @FindBy(xpath = "//button[text()='Set colour']")
    private WebElement buttonSetColour;

    @FindBy(xpath = "//div[text()='Remove label' and @class='J-N-Jz']")
    private WebElement buttonRemoveLabel;

    @FindBy(xpath = "//button[text()='Delete']")
    private WebElement buttonDeleteInShortcutDialog;

    @FindBy(xpath = "(//div[@class='n3'])[1]//a")
    private List<WebElement> leftShortcuts;

    private final String labelImportant = "(//div[@class='pH'])[1]";

    private final String label_Not_Important = "(//div[@class='pH-A7'])[1]";

    private final String labelHasAttach = "(//img[@alt='Attachment'])[1]";

    private Robot robot = null;



    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButtonCompose() {
        logger.info("try to click button Compose..");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonCompose));
        buttonCompose.click();
        logger.info("button compose is clicked");
    }

    public void fillReceiver(String receiverLogin) {
        logger.info("try to fill receiver field..");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(inputMessageReceiver));
        inputMessageReceiver.sendKeys(receiverLogin);
        logger.info("receiver field is filled");
    }

    public void fillSubject(String subject) {
        logger.info("try to fill subject field..");
        inputMessageSubject.sendKeys(subject);
        logger.info("subject field is filled");
    }

    public void fillMessage(String message) {
        logger.info("try to fill message field..");

        inputMessageText.sendKeys(message);

        logger.info("message field is filled");
    }

    public void clickButtonSend() {
        logger.info("try to click button Send..");
        buttonSend.click();
        logger.info("button send is clicked");
    }

    public void tickMessage(WebElement message) {

        logger.info("try to tick message..");

        message.findElement(By.xpath("(//div[@role='main']//td[@class='oZ-x3 xY'])[1]")).click();  //Inbox checkbox
        logger.info("message is ticked");
    }

    public void clickButtonToSpam() {
        logger.info("try to click button ToSpam..");
        buttonToSpam.click();
        logger.info("button ToSpam is clicked");
    }

    public void goToSpamFolder() {
        logger.info("try to GoToSpamFolder..");
        inputSearch.sendKeys("in:spam");
        buttonSearch.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(deleteAllSpamMessageNow));
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
        logger.info("Try to click button settings");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonSettings));
        buttonSettings.click();
        logger.info("button settings was clicked");
    }

    public void chooseSettingsInContextMenu() {
        logger.info("Try to click SETTINGS in context menu");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(buttonSettingsInner));
        buttonSettingsInner.click();
        logger.info("SETTINGS in context menu was clicked");
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

    public void clickButtonSaveChangesForwarding() {
        buttonSaveChangesForwarding.click();
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
        catch(TimeoutException | NoSuchElementException e){
            logger.info("Confirm discard changes is invisible. Try to go on..");
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
        logger.info("Check message has smile attachment");
        if(!isMessageHasAttachment(message)) return false;
        message.click();
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(smilePinkLaughInMessage));
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(smileYellowLaughInMessage));
        }
        catch(TimeoutException | NoSuchContextException e){
            logger.info("smile not found");
        }
        return true;
    }

    public List<WebElement> getAllMessages() {
        logger.info("All messages size = " + allMessages.size());
        return allMessages;
    }

    public void clickButton_Not_Spam() {
        logger.info("Try to click button 'Not Spam'..");
        button_Not_Spam.click();
        logger.info("button was clicked");
    }

    public void tickRadioButtonSignature() {
        logger.info("Try to tick radiobutton signature..");
        radioButtonSignature.click();
        logger.info("Radiobutton signature was ticked");
    }

    public void createSignature(String signature) {
        logger.info("Try to set signature..");
        signatureTextAria.sendKeys(signature);
        logger.info("Signature was set");
    }

    public boolean isSignatureVisible() {
        logger.info("Check visibility of signature");
        return signature.isDisplayed();
    }

    public void clickButtonSaveChangesGeneral() {
        logger.info("Try to click button SAVE CHANGES..");
        buttonSaveChangesGeneral.click();
        new WebDriverWait(driver, 1);
        logger.info("Button SAVE CHANGES was clicked");
    }

    public void clickOnStar() {
        logger.info("Try to click star..");
        star.click();
        logger.info("star was clicked");
    }

    public void goToStarredFolder() {
        logger.info("Go to STARRED folder");
        starredFolder.click();
    }

    public boolean isStarredMessageVisible() {
        logger.info("Try to find starred message..");
        return !getAllMessages().isEmpty();
    }

    public void clickTriangleOfShortcut(String parentShortcutName) {
        String shortcutXPath = getShortcutXPath(parentShortcutName);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(shortcutXPath)));

        StringBuilder stringBuilderPath = new StringBuilder(shortcutXPath);
        stringBuilderPath.append("/../../..//div[@class='p6']");    //треугольник
        action.click(driver.findElement(By.xpath(stringBuilderPath.toString()))).build().perform();
    }

    public void clickButtonAddSublable() {
        buttonAddSublabel.click();
    }

    public void inputNameOfInsertedShortcut(String insertedShortcutName) {
        inputNameOfInsertedShortcutField.sendKeys(insertedShortcutName);
    }

    public boolean isCheckBoxNEST_LABEL_UNDERChosen() {
        return CheckBoxNEST_LABEL_UNDERIsChosen.isDisplayed();
    }

    public boolean isParentShortcutEquals(String usersShortcutName) {
        StringBuilder stringBuilderPath = new StringBuilder();
        stringBuilderPath.append("//option[@value='");
        stringBuilderPath.append(usersShortcutName);
        stringBuilderPath.append("']");
        return driver.findElement(By.xpath(stringBuilderPath.toString())).isDisplayed();
    }

    public void clickCreateShortcutButton() {
        buttonCreateInsertedShortcut.click();
    }

    public boolean isInsertedShortcutVisible(String insertedShortcutName) {
        StringBuilder stringBuilderPath = new StringBuilder();
        stringBuilderPath.append("//a[@title='");
        stringBuilderPath.append(insertedShortcutName);
        stringBuilderPath.append("']");
        return driver.findElement(By.xpath(stringBuilderPath.toString())).isDisplayed();
    }

    public void clickButtonLabelColor() {
        buttonLabelColour.click();
    }

    public String clickTheOneOfTheOfferedColours() {
        firstOfOfferedColours.click();
        return Util.hexColorCode(firstOfOfferedColours.getAttribute("style"));
    }

    public void chooseLabelAndItsSublabelsRadioButton() {
        radioButtonLabelAndItsSublabels.click();
    }

    public void clickButtonSetColour() {
        buttonSetColour.click();
    }

    public boolean isBackgroundColorsOfShortCutEquals(String parentShortcutName, String expectedBackgroundColor) {
        StringBuilder triangleColorPath = new StringBuilder(getShortcutXPath(parentShortcutName));

        triangleColorPath.append("/../../..//div[@class='p6' and @style='");
        triangleColorPath.append(expectedBackgroundColor);
        triangleColorPath.append("']");
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(triangleColorPath.toString())));
        }
        catch (TimeoutException e){
            logger.info("Colors aren't same");
            return false;
        }
        catch (NoSuchElementException e){
            logger.info("Colors aren't same");
            return false;
        }
        return true;
    }

    private String getShortcutXPath(String parentShortcutName) {
        StringBuilder stringBuilderPath = new StringBuilder();
        stringBuilderPath.append("//a[contains(text(), '");
        stringBuilderPath.append(parentShortcutName);
        stringBuilderPath.append("')]");
        return stringBuilderPath.toString();
    }

    public void clickButtonRemoveLabel() {
        buttonRemoveLabel.click();
    }

    public boolean isParentShortcutPresentedInDialog(String parentShortcutName) {
        StringBuilder xpathBuilder = new StringBuilder("//span[@class='ajP' and text()='");
        xpathBuilder.append(parentShortcutName);
        xpathBuilder.append("']");
        return driver.findElement(By.xpath(xpathBuilder.toString())).isDisplayed();
    }

    public boolean isInsertedShortcutPresentedInDialog(String insertedShortcutName) {
        StringBuilder xpathBuilder = new StringBuilder("//span[@class='ajP' and text()='");
        xpathBuilder.append(insertedShortcutName);
        xpathBuilder.append("']");
        return driver.findElement(By.xpath(xpathBuilder.toString())).isDisplayed();
    }

    public void clickButtonDeleteInShortcutDialog() {
        buttonDeleteInShortcutDialog.click();
    }

    public boolean areBothShortcutsDeleted(String parentShortcutName) {
        String shortcutXPath = getShortcutXPath(parentShortcutName);
        try{
            new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(shortcutXPath)));
            return true;
        }
        catch (NoSuchElementException e){
            logger.info("Shortcuts are absent");
            return true;
        }
        catch (TimeoutException e){
            logger.info("Shortcuts weren't removed");
            return false;
        }
    }
}