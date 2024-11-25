package com.mihainataliaqa.managers;

import org.openqa.selenium.*;

public class ScrollManager {

        //This section will scroll down to the button we want to clic privacyToggleBar
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getInstance().getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
        try {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
