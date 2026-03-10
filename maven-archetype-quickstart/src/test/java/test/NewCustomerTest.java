package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.NewCustomerPage;
import config.ConfigReader;

public class NewCustomerTest extends BaseClass {

    @Test
    public void addNewCustomer() {

        ConfigReader config = new ConfigReader();

        LoginPage lp = new LoginPage(driver);

        lp.enterUsername(config.getUsername());
        lp.enterPassword(config.getPassword());
        lp.clickLogin();

        NewCustomerPage nc = new NewCustomerPage(driver);

        nc.clickNewCustomer();

        nc.enterCustomerName("John");
        nc.selectGender();
        nc.enterDOB("01011990");
        nc.enterAddress("New York Street");
        nc.enterCity("New York");
        nc.enterState("NY");
        nc.enterPin("123456");
        nc.enterMobile("9999999999");
        nc.enterEmail("john" + System.currentTimeMillis() + "@gmail.com");
        nc.enterPassword("test123");

        nc.clickSubmit();
    }
}