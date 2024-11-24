package com.mihainataliaqa.managers;

import org.openqa.selenium.*;

public class ScrollManager {

    public static void scrollToElement(WebDriver driver, WebElement element) {
        //This section will scroll down to the button we want to clic privacyToggleBar
        WebElement privacyToggleBar = driver.findElement(By.name("agree"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getInstance().getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
