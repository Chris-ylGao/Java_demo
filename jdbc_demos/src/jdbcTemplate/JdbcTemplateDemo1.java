package jdbcTemplate;

import domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.DruidUtils;

import java.util.List;
import java.util.Map;

/**
 * JdbcTemplateDemo1:
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        // using JdbcTemplate.update() to implement insert, delete and update(DML query);
        String sql;
        sql= "UPDATE account SET balance = ? WHERE id =?" ;
        System.out.println(template.update(sql,2000,1));
        sql= "INSERT INTO account(name, balance) VALUES(?,?)" ;
        System.out.println(template.update(sql,"Mark", 100));
        sql= "DELETE FROM account WHERE name =?" ;
        System.out.println(template.update(sql,"Mark"));

        /**
         * Jdbc.queryForMap(sql): select query(key - header, values - row)
         * Note: only suit for situation that matches one record
         */
        sql = "Select * FROM account WHERE id =?";
        Map<String,Object> map = template.queryForMap(sql,1);
        System.out.println(map);

        /**
         * List<Map> to store multiple records select from DB;
         */
        sql = "Select * FROM account";
        List<Map<String,Object>> list = template.queryForList(sql);
        System.out.println(list);

        /**
         * Select records from DB and encapsulate it as Account object
         * new BeanPropertyRowMapper<Object>(Object.class)
         */
        List<Account> accounts = template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accounts) {
            System.out.println(account);
        }

        /**
         * get the number of record.
         * JdbcTemplate.queryForObject(sql,Long.class)
         */
        sql = "SELECT COUNT(id) FROM account";
        System.out.println(template.queryForObject(sql,Long.class));
    }
}
