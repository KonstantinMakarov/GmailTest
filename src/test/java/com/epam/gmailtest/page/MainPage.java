package com.epam.gmailtest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Kanstantsin_Makarau on 10/9/2014.
 */
public class MainPage {
    private static MainPage mainPage = null;
    private WebDriver driver;
    public static final Logger logger = Logger.getLogger(MainPage.class);

    public static MainPage getInstance(WebDriver driver){
        if(null == mainPage){
            return mainPage = new MainPage(driver);
        }
        else{
            return mainPage;
        }
    }

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

    @FindBy(xpath = "//tr[@class='zA zE']")
    private WebElement unreadMessage;

    @FindBy(xpath = "//tr[@class='zA yO']")
    private WebElement readMessage;

    @FindBy(css = "div.T-Jo-auh")
    private WebElement checkBox;

    @FindBy(css = "div.asl.T-I-J3.J-J5-Ji")
    private WebElement buttonToSpam;

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

    @FindBy(xpath = "//a[@class='f0 ou' and text()='Filters']")
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

    private MainPage(WebDriver driver) {
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
        buttonCompose.click();
        logger.info("button compose is clicked");
    }

    public void fillReceiver(String receiverLogin) {
        logger.info("try to fill receiver field...");
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

    public void tickMessageFromSpammer(WebElement message) {

        logger.info("try to tick message...");

        message.findElement(By.xpath("(//div[@class='T-Jo-auh'])[1]")).click();  //Inbox checkbox
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
        xpathEmail.append("//span[@email='").append(email).append("']/../..");

        logger.info("try to find messages from user...");
        new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(unreadMessage.findElement(By.xpath(xpathEmail.toString()))));
        List<WebElement> unreadMessages = unreadMessage.findElements(By.xpath(xpathEmail.toString()));
        logger.info("found: " + unreadMessages.size() + " messages");

        return unreadMessages;
    }

    public void clickButtonSettings() {
        buttonSettings.click();
    }

    public void chooseSettingsInContextMenu() {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(buttonSettingsInner));
        buttonSettingsInner.click();
    }

    public void chooseForwardingAndPOP_IMAP() {
        new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(buttonForwardingAndPOP_IMAP));
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
        catch(NoSuchElementException e){
            logger.info("Confirm discard changes is invisible. Try to go on...");
        }
    }

    public void attachFile(String filePath) {
        logger.info("" + filePath);
        buttonAttachFiles.click();

    }
}