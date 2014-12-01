package com.epam.gmailtest.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kanstantsin_Makarau on 12/1/2014.
 */
public class ConfirmationSuccessPage {

    public final static Logger logger = Logger.getLogger(ConfirmationSuccessPage.class);

    private WebDriver driver;
    @FindBy(xpath = "//td[text()='Confirmation Success!']")
    private WebElement conformationSuccess;

    public ConfirmationSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void insurance() {
        String parentWindow = driver.getWindowHandle();
        for(String currentWindow : driver.getWindowHandles()){
            driver.switchTo().window(currentWindow);
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(conformationSuccess));
        logger.info("Confirmation Success");
        driver.switchTo().window(parentWindow);
    }
}
