package com.mihainataliaqa.pageobjects;

import com.mihainataliaqa.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logoutBtn;

    public  void  logoutFromTheAccount() {
        ScrollManager.scrollToElement(logoutBtn);
        logoutBtn.click();
        System.out.println("The user is logged out");

    }
}
