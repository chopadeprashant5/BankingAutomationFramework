package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.DashboardPage;
import config.ConfigReader;

public class LogoutTest extends BaseClass {

    @Test
    public void logoutTest() {

        ConfigReader config = new ConfigReader();

        LoginPage lp = new LoginPage(driver);

        lp.enterUsername(config.getUsername());
        lp.enterPassword(config.getPassword());
        lp.clickLogin();

        DashboardPage dp = new DashboardPage(driver);

        dp.logout();
    }
}