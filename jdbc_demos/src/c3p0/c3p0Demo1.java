package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * c3p0Demo1：use c3p0 data source to get connection
 *
 * Note: c3p0 config file should be placed in the src directory.
 */
public class c3p0Demo1 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // create connection poll, if there is no parameter, default-config would be implemented.
            // ComboPooledDataSource(String namedConfig): to implement self-defined config.
            dataSource = new ComboPooledDataSource();
            // get connection from poll
            connection = dataSource.getConnection();
            System.out.println(connection);

            String sql  = "SELECT name FROM account WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close(); // return this connection to the connection pool(data source)
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
