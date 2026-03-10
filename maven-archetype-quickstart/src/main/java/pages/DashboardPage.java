package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By managerIdText = By.xpath("//td[contains(text(),'Manger Id')]");
    By logoutLink = By.linkText("Log out");

    // Verify Manager ID
    public boolean verifyManagerId() {
        return driver.findElement(managerIdText).isDisplayed();
    }

    // Logout Method (Click + Accept Alert)
    public void logout() {

        driver.findElement(logoutLink).click();
        driver.switchTo().alert().accept();

    }
}