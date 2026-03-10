package dbtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import database.DBConnection;

public class DBTest {

//    @Test
//    public void validateaccountsName() {
//
//        String dbName = DBConnection.getCustomerName(1);
//
//        System.out.println("Customer Name from DB: " + accounts.name);
//
//        Assert.assertEquals(dbName, "Alice");
//    }
	
	@Test
	public void validateCustomerName() {

	    String dbName = DBConnection.getCustomerName(101);

	    System.out.println("Customer Name from DB: " + dbName);

	    Assert.assertEquals(dbName, "Alice");
	}
	
	@Test
	public void validateBalance() {

	    int balance = DBConnection.getAccountBalance(101);
	    System.out.println(balance);
	    Assert.assertEquals(balance, 5000);
	}
}