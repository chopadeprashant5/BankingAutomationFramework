package test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import listeners.TestListener;

import base.BaseClass;
import pages.LoginPage;
import pages.DashboardPage;
import config.ConfigReader;
import org.testng.annotations.DataProvider;
import utils.ExcelUtil;

@Listeners(TestListener.class)
public class LoginTest extends BaseClass {

    @Test
    public void loginTest() {

        ConfigReader config = new ConfigReader();
        LoginPage lp = new LoginPage(driver);

        lp.enterUsername(config.getUsername());
        lp.enterPassword(config.getPassword());
        lp.clickLogin();

    }

    @Test
    public void loginTest1() {

        ConfigReader config = new ConfigReader();
        LoginPage lp = new LoginPage(driver);

        lp.enterUsername(config.getUsername());
        lp.enterPassword(config.getPassword());
        lp.clickLogin();

        DashboardPage dp = new DashboardPage(driver);

        Assert.assertTrue(dp.verifyManagerId());

    }
    @DataProvider(name = "loginData")
    public Object[][] getData() {

        return ExcelUtil.getLoginData();
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        LoginPage lp = new LoginPage(driver);

        lp.enterUsername(username);
        lp.enterPassword(password);
        lp.clickLogin();
    }
    
}