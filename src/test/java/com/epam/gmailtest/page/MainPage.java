package com.epam.gmailtest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kanstantsin_Makarau on 10/9/2014.
 */
public class MainPage {
    WebDriver driver;
    Logger logger = Logger.getLogger(MainPage.class);

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    private WebElement buttonSent;

    @FindBy(xpath = "//form[@id=':e7']//textarea[@id=':g4']")
    private WebElement inputReceiver;

    @FindBy(xpath = "//form[@id=':e7']//input[@id=':fp']")
    private WebElement inputSubject;

    @FindBy(xpath = "//body[class='editable LW-avf']")
    private WebElement inputMessage;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendMessage(String receiverLogin, String subject, String message) throws InterruptedException {
        buttonSent.click();
        inputReceiver.sendKeys(receiverLogin);
        inputSubject.sendKeys(subject);
        driver.switchTo().frame(10);
        inputMessage.sendKeys(message);
        Thread.sleep(10000);
    }
}
