package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    public static Connection connection;

    public static Connection getConnection() {

        try {

            String url = "jdbc:mysql://localhost:3307/banking";
            String username = "root";
            String password = "Secret123";

            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return connection;
    }

    public static String getCustomerName(int id) {

        String name = "";

        try {

            Connection con = getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT name FROM accounts WHERE account_id=" + id);

            while (rs.next()) {

                name = rs.getString("name");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return name;
    }
    
    public static int getAccountBalance(int id) {

        int balance = 0;

        try {

            Connection con = getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT balance FROM accounts WHERE account_id=" + id);

            while (rs.next()) {

                balance = rs.getInt("balance");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return balance;
    }
}
