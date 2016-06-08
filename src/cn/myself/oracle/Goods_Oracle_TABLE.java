package cn.myself.oracle;

import cn.myself.basic.Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 从数据库中获取宠物商品数据
 */
public class Goods_Oracle_TABLE extends LinkToOracle {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private Goods goods = new Goods();
    private int id;

    public Goods_Oracle_TABLE() {
        this.connection = LinkToOracle.getConnection();
    }

    public Goods getGoods(int id) {
        try{
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from PETS where id = "+"'"+id+"'");
            if(resultSet.next()) {
                goods.setId(id);
                goods.setName(resultSet.getString(2));
                goods.setEat(resultSet.getString(3));
                goods.setDrink(resultSet.getString(4));
                goods.setLive(resultSet.getString(5));
                goods.setHobby(resultSet.getString(6));
                goods.setPrice(resultSet.getFloat(7));
                goods.setInventory(resultSet.getInt(8));
            }
            return goods;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
