package com.mihainataliaqa;

import com.mihainataliaqa.managers.DriverManager;
import com.mihainataliaqa.managers.RandomDataManager;
import com.mihainataliaqa.pageobjects.AccountPage;
import com.mihainataliaqa.pageobjects.HomePage;
import com.mihainataliaqa.pageobjects.LoginPage;
import com.mihainataliaqa.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunitTests {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("The execution test starts. This method is run before all tests from this class");
    }

    @BeforeEach
    public void beforeEachTest() {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        registerPage = new RegisterPage(driver);
    }


    @Test
    @DisplayName("User is redirected to Account Page when registering with valid data (Executed TEST nr.1)")

    public void registerFlowWithValidDtaRedirectsTheUserToAccountPage() throws InterruptedException {

        // Generate Random Data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String pasw = RandomDataManager.getRandomPasw();

        //Actions on the Register page
        registerPage.completeRegisterForm(firstName, lastName, email, pasw);

        registerPage.enableTheToggleBar(); // cream un bag
        registerPage.clickOnTheContinueBtn();

        // Thread.sleep(1000);

        boolean urlContainSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainSuccessKeyword, "The URL of the page contain the Success keyword");

        //  Account page related actions
        AccountPage accountPage = new AccountPage(driver);
        accountPage.logoutFromTheAccount();

        homePage.navigateToLoginPage();

        // Thread.sleep(1000);

        //  Login page related actions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLoginForm(email, pasw);
        loginPage.clickTheLoginBtn();

        //  Thread.sleep(2000);
    }

    @Test
    @DisplayName("User is redirected to Account Page when registering without acepting the terms and conditions (Executed TEST nr.2)")

    public void userRemainOnRegisterPageWhenRegisteringWithoutAcceptingPrivacyRules() throws InterruptedException {


        // Generate Random Data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String pasw = RandomDataManager.getRandomPasw();

        //Actions on the Register page
        registerPage.completeRegisterForm(firstName, lastName, email, pasw);

        ////registerPage.enableTheToggleBar(); // cream un bag
        registerPage.clickOnTheContinueBtn();

        //  Assertions.assertTrue(driver.getCurrentUrl().contains("register_jhbkjnlkm;lk") , "The Page URL has the keyword register");
        Assertions.assertTrue(driver.getCurrentUrl().contains("register"), "The Page URL has the keyword register");
    }

    @Test
    @DisplayName("Navigate to Login page from Register page (Executed TEST nr.3)")
    public void navigeteToLoginPageFromRegisterPage() {
        registerPage.navigateToLoginPage();

        Assertions.assertTrue(driver.getCurrentUrl().contains("login"), "The page Login has open");
    }


    @AfterEach
    public void afterEachTestExecution() {
        DriverManager.getInstance().quiteTheDriver();
    }

    @AfterAll
    public static void afterExecution() {
        System.out.println("The execution test is terminated. This method is executed after all the tests from this class");
    }


//
//    @Test
//    @DisplayName("The registration of a new user with valid data is succesful")
//    public void registerUserWithValidData() throws InterruptedException {
//
//
//    }
//
//    @Test
//    @DisplayName("User remains on Register Page when he/she uses invalid password for register flow")
//    public void registerUserWithValidData() throws InterruptedException {
//
//
//    }
//


}
