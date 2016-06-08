package cn.myself.basic;

import cn.myself.oracle.LinkToOracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 用户系统
 */
public class UserService {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private Customer customer = new Customer();
    private PreparedStatement prepStmt = null;
    private String sql = null;

    public UserService() {
        this.connection = LinkToOracle.getConnection();
    }

    //注册
    public boolean Register(Customer customer) {
        try{
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from USERS where accountNumber = "+"'"+customer.getAccountNumber()+"'");
            if(resultSet.next()) {
                System.out.println("该用户名已存在！");
                return false;
            }else {
                statement.executeUpdate("insert into USERS values("+"'"+customer.getName()+"'"+","+"'"+customer.getSex()+"'"+"," +
                        "'"+customer.getAccountNumber()+"'"+","+"'"+customer.getPassword()+"'"+")");
                System.out.println("注册成功！");
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    //登陆
    public int Login(String accountnumber,String password){
        try{
            sql = "select * from USERS where accountNumber ="+"'"+accountnumber+"'";
            prepStmt = connection.prepareStatement(sql);
            resultSet = prepStmt.executeQuery();
            if(resultSet.next() == false) {
                System.out.println("用户名不存在！");
                return 0;
            }else if(!resultSet.getString("password").equals(password)){
                System.out.println("密码错误！");
                return 1;
            }else{
                System.out.println("登陆成功！");
                return 2;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 3;
        }
    }

    //退出
    public boolean Logout(int id) {
        customer = null;
        return true;
    }
}
