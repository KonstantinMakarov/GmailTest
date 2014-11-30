package com.epam.gmailtest.page.settings;

import org.openqa.selenium.NoSuchElementException;
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
public class FilterSettingsPage extends AbstractSettingsPage {

    @FindBy(xpath = "//span[@class='sA' and text()='Create a new filter']")
    private WebElement buttonCreateANewFilter;

    @FindBy(xpath = "//input[@class='ZH nr aQa']")
    private WebElement inputFilterFrom;

    @FindBy(xpath = "//label[text()='Has attachment']/../input")
    private WebElement checkBoxFilterHasAttachment;

    @FindBy(xpath = "//div[@class='acM']")
    private WebElement buttonCreateFilterWithThisSearch;

    @FindBy(xpath = "//button[@class='J-at1-auR J-at1-atl' and @name='ok']")
    private WebElement buttonOkInConfirmDiscardChanges;

    @FindBy(xpath = "//label[text()='Delete it']/../input")
    private WebElement checkBoxFilterDeleteIt;

    @FindBy(xpath = "//label[text()='Always mark it as important']/../input")
    private WebElement checkBoxFilterAlwaysMarkItAsImportant;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji Zx acL T-I-atl L3']")
    private WebElement buttonCreateFilter;

    public FilterSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickButtonCreateANewFilter() {
        buttonCreateANewFilter.click();
    }

    public void fillFiledFrom(String fromUser) {
        inputFilterFrom.sendKeys(fromUser);
    }

    public void tickHasAttachment() {
        checkBoxFilterHasAttachment.click();
    }

    public void clickButtonCreateFilterWithThisSearch() {
        buttonCreateFilterWithThisSearch.click();
    }


    public void clickButtonOkInConfirmDiscardChanges() {
        try{
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(buttonOkInConfirmDiscardChanges));
            buttonOkInConfirmDiscardChanges.click();
        }
        catch(TimeoutException | NoSuchElementException e){
            logger.info("Confirm discard changes is invisible. Try to go on..");
        }
    }

    public void tickDeleteIt() {
        checkBoxFilterDeleteIt.click();
    }

    public void tickAlwaysMarkItAsImportant() {
        checkBoxFilterAlwaysMarkItAsImportant.click();
    }

    public void clickButtonCreateFilter() {
        buttonCreateFilter.click();
    }
}
