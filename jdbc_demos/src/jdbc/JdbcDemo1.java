package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Step1: copy connector jar package into libs directory and add this directory as library;

        //Step2: register a Driver
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //Step3: connect to db
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","gaoyl1996");

        //Step4: define sql query
        String sql = "UPDATE account SET balance = 500  WHERE id =1";


        //Step5: crate a statement object
        Statement statement = connection.createStatement();

        //Step6: execute sql statement
        int count = statement.executeUpdate(sql);

        //Step7: deal with result
        System.out.println(count);

        //Step8: close resource
        statement.close();
        connection.close();
    }
}
