package com.epam.gmailtest.page.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Use for ...
 */
public class ForwardingAndPOP_IMAP extends AbstractSettingsPage {

    @FindBy(xpath = "//input[@value='Add a forwarding address']")
    private WebElement buttonAddAForwardingAddress;

    @FindBy(xpath = "//div[@class='Kj-JD-Jz' and contains(text(), 'a new forwarding email')]//input[@id]")
    private WebElement inputForwardLogin;

    @FindBy(xpath = "//button[@class='J-at1-auR']")
    private WebElement buttonNextInAddForwardingAddress;

    @FindBy(xpath = "//input[@value='Proceed']")
    private WebElement buttonProceedInAddForwardingAddress;

    @FindBy(xpath = "//button[@class='J-at1-auR']")
    private WebElement buttonOKInAddForwardingAddress;

    @FindBy(xpath = "//span[text()='Forward a copy of incoming mail to ']/../..//input")
    private WebElement radiobuttonForwardACopyOfIncomingMailTo;

    @FindBy(xpath = "//div[@class='nH Tv1JD']//button[@guidedhelpid='save_changes_button']")
    private WebElement buttonSaveChangesForwarding;

    @FindBy(xpath = "//div[contains(text(), 'You are forwarding')]")
    private WebElement noticeYouAreForwardingYourEMail;

    public ForwardingAndPOP_IMAP(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickButtonAddAForwardingAddress() {
        buttonAddAForwardingAddress.click();
    }

    public void addForwardLogin(String email) {
        inputForwardLogin.sendKeys(email);
        buttonNextInAddForwardingAddress.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ds']")));
        buttonProceedInAddForwardingAddress.click();
        driver.switchTo().defaultContent();
        buttonOKInAddForwardingAddress.click();
    }

    public void clickRadiobuttonForwardACopyOfIncomingMailTo() {
        radiobuttonForwardACopyOfIncomingMailTo.click();
    }

    public void clickButtonSaveChangesForwarding() {
        buttonSaveChangesForwarding.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(noticeYouAreForwardingYourEMail));
    }
}
