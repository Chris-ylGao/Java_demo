package druid;

import utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DruidUtils.createConnection();
            String sql = "DELETE FROM account WHERE name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Daniel");
            System.out.println(statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.closeResource(connection,statement);
        }
    }
}
