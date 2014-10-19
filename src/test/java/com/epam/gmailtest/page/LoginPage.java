package com.epam.gmailtest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kanstantsin_Makarau on 10/9/2014.
 */
public class LoginPage {
    WebDriver driver;
    private static final Logger logger = Logger.getLogger(LoginPage.class);

    private  final String BASE_URL = "https://gmail.com";
    @FindBy(id = "Email")
    private WebElement inputLogin;

    @FindBy(id = "Passwd")
    private WebElement inputPassword;

    @FindBy(id = "signIn")
    private WebElement buttonSubmit;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        logger.info("try to open LoginPage...");
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened!");
    }


    public void login(String login, String password) {
        logger.info(login + " is trying to sing up...");
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Login performed");
    }
}
