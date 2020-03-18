package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Using Statement.executeUpdate(String sql) to insert a record, modify record and delete record;(INSERT INTO, UPDATE, DELETE FROM)
 *
 * Statement.executeUpdate(String sql) would return a number, which represents the number of lines in the table is affected.
 */
public class JdbcDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","gaoyl1996");
            String insert = "INSERT INTO account(name, balance) VALUES ('Dan', 3000)";
            statement = connection.createStatement();
            int result = statement.executeUpdate(insert);
            System.out.println(result);
            if (result > 0){
                System.out.println("Insert Successfully!");
            }else{
                System.out.println("Insert failed");
            }
            result = 0;
            String modify = "UPDATE account SET balance = 1000 WHERE id = 3";
            result= statement.executeUpdate(modify);
            System.out.println(result);
            result = 0;
            String delete = "DELETE FROM account WHERE id BETWEEN 4 AND 5";
            result = statement.executeUpdate(delete);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null ) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null ) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
