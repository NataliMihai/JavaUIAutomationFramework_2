package com.mihainataliaqa;

import com.mihainataliaqa.managers.DriverManager;
import org.openqa.selenium.WebDriver;
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

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.point.md");
      //  Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(currentWindowName);
        manager.getDriver().get("https://www.stiri.md");
       // Thread.sleep(2000);
        driver.quit();

        System.out.println("The driver is closed...");
        

    }
}