package com.mihainataliaqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-password")
    private WebElement paswlInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    public void completeLoginForm(String email, String pasword){
        emailInput.sendKeys(email);
        paswlInput.sendKeys(pasword);

    }

    public void clickTheLoginBtn(){
        loginBtn.click();
    }

}
