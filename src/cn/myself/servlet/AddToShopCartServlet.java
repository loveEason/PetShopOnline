package cn.myself.servlet;

import cn.myself.basic.Customer;
import cn.myself.basic.Goods;
import cn.myself.basic.ShoppingCart;
import cn.myself.oracle.Goods_Oracle_TABLE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加至购物车Servlet
 */
public class AddToShopCartServlet extends HttpServlet {
    Customer customer = new Customer();
    ShoppingCart shoppingCart = new ShoppingCart();
    Goods_Oracle_TABLE goodsOracle_table = new Goods_Oracle_TABLE();
    Goods goods = new Goods();
    String message = null;
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
        customer = (Customer)req.getSession().getAttribute("customer");
        shoppingCart = customer.getCart();
        int id = Integer.parseInt(req.getParameter("id"));
        goods = goodsOracle_table.getGoods(id);
        int numbers;
        if(req.getParameter("numbers") == "") {
            numbers = 0;
        }else{
            numbers = Integer.parseInt(req.getParameter("numbers"));
        }
        if(numbers > goods.getInventory()) {
            message = "Sorry,the inventory about"+goods.getName()+" is not enough,please input lower number.";
            req.setAttribute("message",message);
            req.getSession().setAttribute("goods",goods);
            req.getRequestDispatcher("/Pet_Message_Page.jsp").forward(req,res);
        }else if(numbers == 0) {
            message = "Sorry,please input a number more than 0.";
            req.setAttribute("message",message);
            req.getSession().setAttribute("goods",goods);
            req.getRequestDispatcher("/Pet_Message_Page.jsp").forward(req,res);
        }else {
                message = "Succeed to add to shopcart.";
                req.setAttribute("message",message);
                shoppingCart.add(id,numbers);
                req.getRequestDispatcher("/Pet_Message_Page.jsp").forward(req,res);
        }
    }
}
