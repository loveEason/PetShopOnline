package cn.myself.servlet;

import cn.myself.basic.Customer;
import cn.myself.basic.Goods;
import cn.myself.basic.ShoppingCart;
import cn.myself.oracle.Goods_Oracle_TABLE;
import cn.myself.oracle.LinkToOracle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

/**
 * 支付处理Servlet
 */
public class BuyServlet extends HttpServlet {
    Connection connection = LinkToOracle.getConnection();
    String sql = null;
    PreparedStatement preparedStatement = null;

    public void createTri() {
        sql = "create or replace trigger tri_update" +
                "after update of inventory on PETS" +
                "for each row" +
                "declare t_id NUMBER;" +
                         "t_sales NUMBER;" +
                         "t_newSale NUMBER;" +
                "begin" +
                    "t_id := :new.id;"+
                    "update PETS set sales=2 where id=t_id;"+
//                    "t_newSale := :old.id - :new.id;" +
//                    "select sales+t_newSale into t_sales from PETS;" +
//                    "t_id := :new.id;" +
//                    "update PETS set sales=t_sales where id=t_id;" +
                "end tri_update;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
        Customer customer = (Customer)req.getSession().getAttribute("customer");
        ShoppingCart shoppingCart = customer.getCart();
        Set set = shoppingCart.getMap().keySet();
        if(set.size() == 0) {
            String message = "You didn't add any pets to your shopcart,please go back to pick someone.";
            req.setAttribute("message",message);
            req.getRequestDispatcher("Shop_Cart_Page.jsp").forward(req,res);
        }else{
            int keys = set.size();
            Iterator iterator = set.iterator();
            Goods_Oracle_TABLE goodsOracle_table = new Goods_Oracle_TABLE();
            Goods goods = new Goods();
            try{
                for(int i=0;i<keys;i++) {
                    if(iterator.hasNext()){
                        int key = (Integer)iterator.next();
                        goods = goodsOracle_table.getGoods(key);
                        sql = "update PETS set inventory=" + "'" + (goods.getInventory() - shoppingCart.getMap().get(key)) + "'" + "where id=" + "'" + key + "'";
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.executeUpdate();
                        //createTri();
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            shoppingCart.delete();
            customer.setCart(shoppingCart);
            try{
                preparedStatement.close();
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            String message = "Thank you! You have buy them.";
            req.setAttribute("message",message);
            req.getRequestDispatcher("Shop_Cart_Page.jsp").forward(req,res);
        }
    }
}
