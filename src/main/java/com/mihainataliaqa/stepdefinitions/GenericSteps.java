package com.mihainataliaqa.stepdefinitions;

import com.mihainataliaqa.managers.DriverManager;
import com.mihainataliaqa.pageobjects.RegisterPage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the Url contains the following keyword {string}")
    public void theUrlContainsTheFollowingKeyword(String collectedKeyWord) throws InterruptedException {
        Thread.sleep(1000);

        boolean containKeyWord = driver.getCurrentUrl().contains(collectedKeyWord);
        Assertions.assertTrue(containKeyWord, "The url contans:" + collectedKeyWord);
    }
}
