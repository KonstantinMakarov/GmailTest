package com.epam.gmailtest.page.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralSettingsPage extends AbstractSettingsPage {

    @FindBy(xpath = "(//input[@name='sx_sg'])[2]")
    private WebElement radioButtonSignature;

    @FindBy(xpath = "(//div[@class='Am Al editable Xp0HJf-LW-avf'])[1]")
    private WebElement signatureTextAria;

    @FindBy(xpath = "//div[@class='nH f2 hCyPr']//button[@guidedhelpid='save_changes_button']")
    private WebElement buttonSaveChangesGeneral;

    public GeneralSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void tickRadioButtonSignature() {
        logger.info("Try to tick radiobutton signature..");
        radioButtonSignature.click();
        logger.info("Radiobutton signature was ticked");
    }

    public void createSignature(String signature) {
        logger.info("Try to set signature..");
        signatureTextAria.sendKeys(signature);
        logger.info("Signature was set");
    }

    public void clickButtonSaveChangesGeneral() {
        logger.info("Try to click button SAVE CHANGES..");
        buttonSaveChangesGeneral.click();
        new WebDriverWait(driver, 1);
        logger.info("Button SAVE CHANGES was clicked");
    }
}
