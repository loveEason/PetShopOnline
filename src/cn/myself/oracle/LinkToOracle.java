package cn.myself.oracle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库的连接
 */
public class LinkToOracle {
    private static Connection connection;

    public static Connection getConnection(){
        try{
            //初始化，获取上下文对象
            InitialContext context = new InitialContext();
            //根据datasourceName获取DataSource
            DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/myoracle");
            //从数据源中获取连接
            try{
                connection = dataSource.getConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (NamingException e){
            e.printStackTrace();
        }
        return connection;
    }

}
