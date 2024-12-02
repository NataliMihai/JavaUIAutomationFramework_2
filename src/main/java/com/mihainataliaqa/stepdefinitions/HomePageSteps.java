package com.mihainataliaqa.stepdefinitions;

import com.mihainataliaqa.managers.DriverManager;
import com.mihainataliaqa.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("The Home Page is displayed")
    public void theHomePageIsDisplayed() {
         System.out.println("Code from first step (1)");
        driver.get("https://tekwillacademy-opencart.online/");
    }

    @And("Register Page is accessed from the Home Page buttons")
    public void registerPageIsAccessedFromTheHomePageButtons() {
        System.out.println("Code from second step (2)");
        homePage.navigateToRegisterPage();
    }

}

