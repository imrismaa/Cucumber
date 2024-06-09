package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By username_field = new By.ById("user-name");
    private By password_field = new By.ById("password");
    private By login_button = new By.ByName("login-button");

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLoginData(String username, String password) {
        driver.findElement(username_field).sendKeys(username);
        driver.findElement(password_field).sendKeys(password);
    }

    public InventoryPage click_login() {
        driver.findElement(login_button).click();
        return new InventoryPage(driver);
    }
}
