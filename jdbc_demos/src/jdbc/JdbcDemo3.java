package jdbc;

import java.sql.*;

/**
 * Using Statement.selectQuery(String sql) to execute SELECT query.
 */
public class JdbcDemo3 {
    public static void main(String[] args) {
        ResultSet results = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_practice","root","gaoyl1996");
            String select = "SELECT * FROM account";
            statement = connection.createStatement();
            results = statement.executeQuery(select);

            // ResultSet.getXxx(int Index| String columnName): get data from resultSet. (Xxx is the data type of record)
            // Note: the index of column starts from 1;
            // ResultSet.next(): Moves the cursor froward one row from its current position.
            // if current line contain data,return true; otherwise, return false.
            while(results.next()) {
                int id = results.getInt(1);
                String name = results.getString("name");
                int balance = results.getInt("balance");
                System.out.println(id + "----" + name + "----" + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (results !=null){
                try{
                    results.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
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
