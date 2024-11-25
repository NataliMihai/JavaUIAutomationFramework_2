package com.mihainataliaqa;

import com.mihainataliaqa.managers.DriverManager;
import com.mihainataliaqa.managers.RandomDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    // public static void main(String[] args) {

    ///     System.out.println("Hello world!");
    //
    public static void main(String[] args) throws InterruptedException {
        DriverManager.getInstance().getDriver().get("https://www.google.com/");
        //  Thread.sleep(5000);
        //  DriverManager.getInstance().getDriver().quit();

        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();
        System.out.println("This driver is on URL : " + driver.getCurrentUrl());

        String currentWindowName = driver.getWindowHandle();

        //Open new window and navigate to them
        driver.switchTo().newWindow(WindowType.TAB);
        ///  driver.get("https://www.point.md");
        //  Thread.sleep(2000);
        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("This driver is on URL : " + driver.getCurrentUrl());
        //  Thread.sleep(5000);

        WebElement myAccounyDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccounyDropDownIcon.click();

        /// definim un obiect Register - submeniul butonului MyAccount
        WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerLink.click();
        //Thread.sleep(2000);
        // print the URL of new page
        System.out.println("This driver is on URL : " + driver.getCurrentUrl());

        /// introducem text in checkbox Firstname
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        ///firstNameInput.sendKeys("Vasilica");
        firstNameInput.sendKeys(RandomDataManager.getRandomFirstName()); // Firstname creata automat Random

        /// introducem text in checkbox Lastname
        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        //lastNameInput.sendKeys("Buzdugan");
        lastNameInput.sendKeys(RandomDataManager.getRandomLastName()); // Lastname creata automat Random

        /// introducem text in checkbox email
        WebElement emailInput = driver.findElement(By.id("input-email"));
        // emailInput.sendKeys("exdeemail@gmail.com"); // manual
       // emailInput.sendKeys(RandomDataManager.getRandomEmail()); // adresa creata automat Random
        // sau  cu afisarea email
        String emailData = RandomDataManager.getRandomEmail();
        System.out.println("The EMAIL is: "+emailData);
        emailInput.sendKeys(emailData);

        /// introducem text in checkbox parola
        WebElement paswInput = driver.findElement(By.cssSelector("#input-password"));
        // paswInput.sendKeys("Parola123!");
       /// paswInput.sendKeys(RandomDataManager.getRandomPasw()); // parola creata automat Random
        // sau  cu afisarea parolei
        String passwordData = RandomDataManager.getRandomPasw();
        System.out.println("The PASSWORD is: "+passwordData);
        paswInput.sendKeys(passwordData);

        /// apasam butonul PrivacyPolice
        WebElement privacyToggleBar = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        privacyToggleBar.click();

        /// apasam butonul Continue
        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        Thread.sleep(2000);

        driver.close();

        driver.switchTo().window(currentWindowName);
        manager.getDriver().get("https://www.stiri.md");
        System.out.println("This driver is on URL : " + driver.getCurrentUrl());
        // Thread.sleep(2000);
        driver.quit();

        System.out.println("The driver is closed...");


    }
}