package jdbc;

import utils.JdbcUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * JdbcDemo5: based on JdbcDemo4, get user's name and password from keyboard and check whether user login successfully.
 */
public class JdbcDemo5 {
    public static void main(String[] args) {
        boolean over  = false;
        while(!over) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the user name");
            String user = sc.nextLine();
            System.out.println("Please enter the password");
            String password = sc.nextLine();
            //boolean flag = new JdbcDemo5().login(user, password);
            boolean flag = new JdbcDemo5().login2(user, password);
            if (flag) {
                System.out.println("Successful!");
                over = true;
            } else {
                System.out.println("Error, please retry");
            }
        }
    }

    public boolean login(String user, String password){
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        try {
            connection = JdbcUtils.createConnection();
            statement = connection.createStatement();
            String check = "SELECT * FROM users WHERE name = '" + user + "' AND password = '" + password + "'";
            results = statement.executeQuery(check);
            return results.next();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeResource(connection,statement,results);
        }
        return  false;
    }

    /**
     * Use preparedStatement to check whether there is a record match the users' input;
     * @param user
     * @param password
     * @return
     */
    public boolean login2(String user, String password){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connection = JdbcUtils.createConnection();
            // Using '?' instead of actual value
            String check = "SELECT * FROM users WHERE name = ? AND password = ?" ;
            //Note: different from createStatement(), when creating preparedStatement, sql query should be passed by parameter.
            statement = connection.prepareStatement(check);
            //PreparedStatement.setXxx(int index, Xxx value):
            statement.setString(1,user);
            statement.setString(2, password);
            //Note: different from Statement, when executing preparedStatement, there is no need to pass sql query again.
            results = statement.executeQuery();
            return results.next();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.closeResource(connection,statement,results);
        }
        return  false;
    }
}
