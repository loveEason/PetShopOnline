package cn.myself.oracle;

import cn.myself.basic.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 从数据库中获取用户信息
 */
public class Customer_Oracle_TABLE {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private Customer customer = new Customer();

    public Customer_Oracle_TABLE() {
        this.connection = LinkToOracle.getConnection();
    }

    public Customer getCustomer(String accountnumber) {
        try{
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from USERS where accountNumber = "+"'"+accountnumber+"'");
            if(resultSet.next()) {
                customer.setName(resultSet.getString("name"));
                customer.setSex(resultSet.getString("sex"));
                customer.setAccountNumber(resultSet.getString("accountNumber"));
                customer.setPassword(resultSet.getString("password"));
            }
            return customer;
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
