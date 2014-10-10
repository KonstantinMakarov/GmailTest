package com.epam.gmailtest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Kanstantsin_Makarau on 10/9/2014.
 */
public class MainPage {
    private WebDriver driver;
    private String email;
    public Logger logger = Logger.getLogger(MainPage.class);

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement buttonWrite;

    @FindBy(xpath = "//textarea[@class='vO']")
    private WebElement inputReceiver;

    @FindBy(xpath = "//input[@class='aoT']")
    private WebElement inputSubject;

    @FindBy(xpath = "//body[@id=':aa']")
    private WebElement inputMessage;

    @FindBy(xpath = "//div[@id=':8y']")
    private WebElement buttonSend;

    @FindBy(xpath = "//tr[@id=':8f']")
    private WebElement linkOpenLastMessageFromSpammer;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji nN T-I-ax7 T-I-Js-Gs T-I-Js-IF ar7 T-I-Zf-aw2']")
    private WebElement buttonToSpam;

    @FindBy(xpath = "//span[@class='J-Ke n4 ah9 aiu air']")
    private WebElement buttonMore;

    @FindBy(xpath = "//a[@class='J-Ke n0 aBU']")
    private WebElement buttonSpamFolder;

    @FindBy(xpath = "//tr[@class='oZ-x3 xY']")
    private WebElement spamMessageTable;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeMessage(String receiverLogin, String subject, String message) throws InterruptedException {
        buttonWrite.click();
        inputReceiver.sendKeys(receiverLogin);
        inputSubject.sendKeys(subject);
        driver.switchTo().frame(10);
        inputMessage.sendKeys(message);
        driver.switchTo().parentFrame();
        buttonSend.click();
    }

    public void markMessageLikeSpam() {

        linkOpenLastMessageFromSpammer.click();
        buttonToSpam.click();
    }

    public boolean checkSpamFolder() {
        buttonMore.click();
        buttonSpamFolder.click();
        List<WebElement> spammerMessages = spamMessageTable.findElements(By.xpath("//span[@email='epamlab.user1@gmail.com']"));
        if(spammerMessages.size() > 1){
            return true;
        }
        return false;
    }
}
