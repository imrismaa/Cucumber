package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.InventoryPage;
import org.example.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginStepDef {
    WebDriver driver;
    void setupChromeDriver() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    @Given("User is on the login page")
    public void navigateToLoginPage() {
        setupChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @When("User submit valid credentials")
    public void submitValidCredentials() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.setLoginData("standard_user", "secret_sauce");
        login.click_login();
    }
    @Then("User should be redirected to the dashboard")
    public void loginSuccessful() throws InterruptedException {
        InventoryPage inventory = new InventoryPage(driver);
        String actualUrl = inventory.getWebUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
