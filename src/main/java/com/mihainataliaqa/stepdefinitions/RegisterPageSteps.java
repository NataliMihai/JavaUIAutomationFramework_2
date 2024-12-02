package com.mihainataliaqa.stepdefinitions;

import com.mihainataliaqa.managers.DriverManager;
import com.mihainataliaqa.managers.RandomDataManager;
import com.mihainataliaqa.pageobjects.HomePage;
import com.mihainataliaqa.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @And("^the register form is populated with data$")
    public void theRegisterFormIsPopulatedWithData() {

        // Generate Random Data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String pasw = RandomDataManager.getRandomPasw();

        //Actions on the Register page
        registerPage.completeRegisterForm(firstName, lastName, email, pasw);

    }

    @And("the privacy toggle bar is enabled")
    public void thePrivacyToogleBarIsEnabled() {
        registerPage.enableTheToggleBar();
    }

    @When("the continueButton is clicked")
    public void theContinueButtonIsClicked() {
        registerPage.clickOnTheContinueBtn();
    }
}
