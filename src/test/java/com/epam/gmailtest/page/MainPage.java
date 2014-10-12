package com.epam.gmailtest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//div[@id=':8y']")
    private WebElement buttonSend;

    @FindBy(xpath = "//tr[@class='zA zE']")
    private WebElement unreadMessage;

    //todo
    @FindBy(xpath = "//div[@class='asa']")
    private WebElement buttonToSpam;

    @FindBy(xpath = "//input[@id='gbqfq']")
    private WebElement inputFind;

    @FindBy(xpath = "//button[@id='gbqfb']")
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
        logger.info("message written");
    }

    public void markMessageLikeSpam() {
        logger.info("try to mark message like spam...");
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(unreadMessage));
        unreadMessage.click();
        buttonToSpam.click();
        logger.info("massage marked");
    }

    public boolean checkSpamFolder() {
        logger.info("start checking spam folder...");
        inputFind.sendKeys("in:spam");
        buttonSearch.click();
        try {
            logger.info("Found message from spammer : " +
                    unreadMessage.findElement(By.xpath("//span[@email='epamlab.user1@gmail.com']")));
            return true;
        }
        catch(Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }
}
