package stepdefinitions;

import base.BaseClass;
import pages.LoginPage;
import pages.DashboardPage;
import config.ConfigReader;

import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass {

    LoginPage lp;
    DashboardPage dp;
    ConfigReader config;

    @Given("user is on login page")
    public void user_is_on_login_page() {

        setup();
        lp = new LoginPage(driver);
        config = new ConfigReader();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {

        lp.enterUsername(config.getUsername());
        lp.enterPassword(config.getPassword());
        lp.clickLogin();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        dp = new DashboardPage(driver);
        dp.verifyManagerId();
        tearDown();
    }
}