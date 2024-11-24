package com.mihainataliaqa;

import com.mihainataliaqa.managers.DriverManager;
import com.mihainataliaqa.managers.RandomDataManager;
import com.mihainataliaqa.pageobjects.AccountPage;
import com.mihainataliaqa.pageobjects.HomePage;
import com.mihainataliaqa.pageobjects.LoginPage;
import com.mihainataliaqa.pageobjects.RegisterPage;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import org.openqa.selenium.WebDriver;

public class TestRunnerWithPageObjects {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

       // RegisterPage registerPage = new RegisterPage(driver);
        //registerPage.completeRegisterForm("Andrei", "Secu", "email@gmail.com", "ThePasw1234");

        // Generate Random Data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String pasw = RandomDataManager.getRandomPasw();

        //Actions on the Register page
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completeRegisterForm(firstName, lastName, email, pasw);

        registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueBtn();

        Thread.sleep(2000);

        //  Account page related actions
        AccountPage accountPage = new AccountPage(driver);
        accountPage.logoutFromTheAccount();

        homePage.navigateToLoginPage();

        Thread.sleep(2000);

        //  Login page related actions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLoginForm(email,pasw);
        loginPage.clickTheLoginBtn();

        Thread.sleep(5000);

        driver.quit();

    }


}
