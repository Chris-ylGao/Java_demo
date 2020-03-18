package druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        // load properties by classLoader and Properties
        Properties properties =new Properties();
        ClassLoader classLoader = DruidDemo1.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("druid.properties");
        properties.load(in);
        // create connection pool
        // Different from c3p0,
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        String sql = "INSERT INTO account(name, balance) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"Daniel");
        preparedStatement.setInt(2,500);
        int result = preparedStatement.executeUpdate();
        System.out.println(result);
    }
}
