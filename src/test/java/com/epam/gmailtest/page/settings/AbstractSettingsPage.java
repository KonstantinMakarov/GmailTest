package com.epam.gmailtest.page.settings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Use for ...
 */
public abstract class AbstractSettingsPage {
    Logger logger = Logger.getLogger(AbstractSettingsPage.class);

    protected WebDriver driver;

    @FindBy(xpath = "//a[text()='Forwarding and POP/IMAP']")
    private WebElement buttonForwardingAndPOP_IMAP;

    @FindBy(xpath = "//a[text()='Filters']")
    private WebElement buttonFilters;

    @FindBy(xpath = "//a[text()='Themes']")
    private WebElement themesInSettings;

    public AbstractSettingsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseForwardingAndPOP_IMAP() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(buttonForwardingAndPOP_IMAP));
        buttonForwardingAndPOP_IMAP.click();
    }

    public void clickButtonFilters() {
        buttonFilters.click();
    }

    public void clickTabThemes() {
        themesInSettings.click();
    }
}