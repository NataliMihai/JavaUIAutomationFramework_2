package com.mihainataliaqa.pageobjects;

import com.mihainataliaqa.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailNameInput;

    @FindBy(css = "#input-password")
    private WebElement paswNameInput;

    @FindBy(css = "input[value='1'][name='agree']")
    private WebElement privacyToogleBar;

    @FindBy(css = "button[type='submit']")
    private WebElement contitueButton;

    public void completeRegisterForm(String firstName, String lastName, String email, String pasw) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailNameInput.sendKeys(email);
        paswNameInput.sendKeys(pasw);
        System.out.println("The Form register was completed with EMAIL: " + email + " and PASSWORD: " + pasw);
    }

    public void enableTheToggleBar() {
        ScrollManager.scrollToElement(privacyToogleBar);
        privacyToogleBar.click();
    }

    public void clickOnTheContinueBtn() {
        ScrollManager.scrollToElement(contitueButton);
        contitueButton.click();
    }
}
