package jdbc;

import domain.Account;
import utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;

public class JdbcDemo4 {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
    ResultSet results = null;
    Connection connection = null;
    Statement statement = null;
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice", "root", "gaoyl1996");
            connection = JdbcUtils.createConnection();
            String select = "SELECT * FROM account";
            statement = connection.createStatement();
            results = statement.executeQuery(select);

            // ResultSet.getXxx(int Index| String columnName): get data from resultSet. (Xxx is the data type of record)
            // Note: the index of column starts from 1;
            // ResultSet.next(): Moves the cursor froward one row from its current position.
            // if current line contain data,return true; otherwise, return false.
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString("name");
                int balance = results.getInt("balance");
                Account account = new Account(id, name, balance);
                accounts.add(account);
            }
            for (Account account : accounts) {
                System.out.println(account);
            }
        }catch(SQLException e){
        e.printStackTrace();
    } finally{
        JdbcUtils.closeResource(connection,statement,results);
    }
}
}
