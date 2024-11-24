package com.mihainataliaqa.managers;

import org.openqa.selenium.*;

public class ScrollManager {

    public static void scrollToElement(WebElement element) {
        //This section will scroll down to the button we want to clic privacyToggleBar

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getInstance().getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
