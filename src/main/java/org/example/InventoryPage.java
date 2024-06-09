package org.example;

import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWebUrl() {
        return driver.getCurrentUrl();
    }
}
