package com.epam.gmailtest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
    private WebDriver driver;
    public Logger logger = Logger.getLogger(MainPage.class);

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement buttonWrite;

    @FindBy(xpath = "//textarea[@class='vO']")
    private WebElement inputReceiver;

    @FindBy(xpath = "//input[@class='aoT']")
    private WebElement inputSubject;

    @FindBy(xpath = "//body[@class='editable LW-avf']")
    private WebElement inputMessage;

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
    private WebElement inputFind;

    @FindBy(xpath = "//button[@class='gbqfb']")
    private WebElement buttonSearch;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeMessage(String receiverLogin, String subject, String message) throws InterruptedException {
        logger.info("try to write message...");
        buttonWrite.click();
        inputReceiver.sendKeys(receiverLogin);
        inputSubject.sendKeys(subject);
        driver.switchTo().frame(10);
        inputMessage.sendKeys(message);
        driver.switchTo().parentFrame();
        buttonSend.click();
        logger.info("message was written");
    }

    public void markMessageLikeSpam() {
        logger.info("try to mark message like spam...");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(unreadMessage));
        unreadMessage.findElement(By.cssSelector("div.T-Jo-auh")).click();      //Inbox checkbox
        buttonToSpam.click();
        logger.info("massage was marked");
    }

    public boolean checkSpamFolder() {
        logger.info("start checking spam folder...");
        inputFind.sendKeys("in:spam");
        buttonSearch.click();
        try {
            //todo должен искать два сообщения
            List<WebElement> unreadSpamMessages = unreadMessage.findElements(By.xpath("//span[@email='epamlab.user1@gmail.com']"));
            logger.info("Found messages from spammer : " + unreadSpamMessages);
            if(unreadSpamMessages.size()>1){
                return true;
            }
            else return false;
        }
        catch(Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    public void deleteSpamMessages() {
        logger.info("try to delete messages from our spammer...");
        List<WebElement> readMessages = readMessage.findElements(By.xpath("//span[@email='epamlab.user1@gmail.com']"));
        for(WebElement currentMessage : readMessages){
            currentMessage.findElement(By.xpath("/../..//td[@class='oZ-x3 xY']")).click();      //Spam checkbox
        }
        buttonDelete.click();
        logger.info("Spam messages from our spammer was deleted");
    }
}
