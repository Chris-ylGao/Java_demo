package jdbc;

import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JdbcDemo6: simulate the process of transfer money by Transaction
 */
public class JdbcDemo6 {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement transfer = null;
        PreparedStatement receive = null;
        try {
            connection = JdbcUtils.createConnection();
            // Start Transaction
            connection.setAutoCommit(false);
            String transferSql = "UPDATE account SET balance = balance - ? WHERE id = ?";
            String receiveSql = "UPDATE account SET balance = balance + ? WHERE id = ?";
            transfer = connection.prepareStatement(transferSql);
            receive = connection.prepareStatement(receiveSql);
            transfer.setInt(1,500);
            transfer.setInt(2,1);
            receive.setInt(1,500);
            receive.setInt(2,2);
            transfer.executeUpdate();
            receive.executeUpdate();
            // commit transaction
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }finally {
            JdbcUtils.closeResource(connection,transfer);
            JdbcUtils.closeResource(null, receive);
        }
    }
}
