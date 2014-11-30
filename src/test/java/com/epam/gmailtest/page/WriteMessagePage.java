package com.epam.gmailtest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by Kanstantsin_Makarau on 11/27/2014.
 */
public class WriteMessagePage {

    Logger logger = Logger.getLogger(WriteMessagePage.class);

    private WebDriver driver;
    private Robot robot = null;

    @FindBy(xpath = "//textarea[@class='vO']")
    private WebElement inputMessageReceiver;

    @FindBy(xpath = "//input[@class='aoT']")
    private WebElement inputMessageSubject;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement inputMessageText;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement buttonSend;

    @FindBy(xpath = "//div[@class='a1 aaA aMZ']")
    private WebElement buttonAttachFiles;

    @FindBy(xpath = "//div[@command='+emoticon']")
    private WebElement buttonEmoticon;

    @FindBy(xpath = "(//div[@goomoji='338'])[1]")
    private WebElement smileYellowLaughInCompose;

    @FindBy(xpath = "(//div[@goomoji='333'])[1]")
    private WebElement smilePinkLaughInCompose;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-atl L3' and text()='Insert']")
    private WebElement buttonInsert;

    @FindBy(xpath = "//div[@class='gmail_signature']")
    private static WebElement signature;

    public WriteMessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void waitForLoadingFile() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='dQ']")));
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

    public static boolean isSignatureVisible() {
        return signature.isDisplayed();
    }
}
