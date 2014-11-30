package com.epam.gmailtest.page.settings;

import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Use for ...
 */
public class ThemesSettingsPage extends AbstractSettingsPage {

    @FindBy(xpath = "//span[text()='Beach']")
    private WebElement beachTheme;

    @FindBy(xpath = "//img[@class='ao0' and contains(@src, 'themes/beach2/bg_thu2')]")
    private WebElement beachBackGround;

    public ThemesSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickBeachTheme() {
        beachTheme.click();
    }

    public boolean isBackGroundChanged() {
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(beachBackGround));
        }
        catch (TimeoutException e){
            logger.info("beachBackGround is not found");
            return false;
        }
        catch (NoSuchContextException e){
            logger.info("beachBackGround is not found");
            return false;
        }
        return true;
    }
}
