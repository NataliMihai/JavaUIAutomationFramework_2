package com.mihainataliaqa.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;
    private static final String WEB_DRIVER_TYPE = "Chrome";

    private DriverManager() {
        switch (WEB_DRIVER_TYPE.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The CHROME Driver / browser is opened.");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The FIREFOX Driver / browser is opened.");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The EDGE Driver / browser is opened.");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The SAFARI Driver / browser is opened.");
                break;
            default:
            System.out.println("The browser is NOT definied! " + WEB_DRIVER_TYPE);

        }

    }

    /// metoda statica pentru a obtine instanta Singleton
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /// metoda publica pentru a obtine driverul web - browser
    public  WebDriver getDriver() {
        if (driver == null) {
            getInstance();
        }
        return driver;
    }

}
