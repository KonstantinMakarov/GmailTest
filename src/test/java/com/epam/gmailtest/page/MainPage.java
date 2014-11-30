package com.epam.gmailtest.page;

import com.epam.gmailtest.util.Util;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    private WebDriver driver;
    public static final Logger logger = Logger.getLogger(MainPage.class);

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement buttonCompose;

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

    @FindBy(xpath = "(//a[contains(text(), 'isolated')])[1]")
    private WebElement linkToAcceptForward;

    @FindBy(xpath = "//a[@class='J-Ke n0' and contains(@href, '#inbox')]")
    private WebElement buttonInbox;

    @FindBy(xpath = "//span[@class='Kj-JD-K7-K0']")
    private WebElement errorAttachAlert;

    @FindBy(xpath = "(//img[@goomoji='338'])[1]")
    private WebElement smileYellowLaughInMessage;

    @FindBy(xpath = "(//img[@goomoji='333'])[1]")
    private WebElement smilePinkLaughInMessage;

    @FindBy(xpath = "//div[@role='main']//tr[@class='zA zE' or @class='zA yO']")
    private List<WebElement> allMessages;

    @FindBy(xpath = "//div[@class='ya']")
    private WebElement deleteAllSpamMessageNow;

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
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(deleteAllSpamMessageNow));  //todo ждет элемента на другой странице
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

    public void clickForwardAcceptLink() {
        linkToAcceptForward.click();
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