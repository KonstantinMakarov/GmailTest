package com.epam.gmailtest.step;

import com.epam.gmailtest.page.LoginPage;
import com.epam.gmailtest.page.MainPage;
import com.epam.gmailtest.util.Util;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kanstantsin_Makarau on 10/9/2014.
 */
public class Step {
    public Logger logger = Logger.getLogger(Step.class);
    private WebDriver driver;
    private MainPage mainPage;

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    public void writeMessage(String receiverLogin) throws InterruptedException {
        getMainPage();
        mainPage.writeMessage(receiverLogin, Util.getRandomString(5), Util.getRandomString(20));
    }

    public void markMessageLikeSpam() {
        getMainPage();
        mainPage.markMessageLikeSpam();
    }

    public boolean checkNewMessageInSpamFolder() {
        getMainPage();
        return mainPage.checkSpamFolder();
    }

    public void deleteSpamMessages() {
        getMainPage();
        mainPage.deleteSpamMessages();
    }

    private MainPage getMainPage() {
        if(null == mainPage){
            return mainPage = new MainPage(driver);
        }
        else{
            return mainPage;
        }
    }
}
