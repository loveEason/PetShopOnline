package cn.myself.servlet;

import cn.myself.basic.Customer;
import cn.myself.basic.Goods;
import cn.myself.oracle.Goods_Oracle_TABLE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取指定商品信息Servlet
 */
public class GetPetServlet extends HttpServlet {
    Customer customer = new Customer();
    Goods goods = new Goods();
    Goods_Oracle_TABLE goodsOracle_table = new Goods_Oracle_TABLE();
    String accountNumber = null;

    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
        int i= Integer.parseInt(req.getParameter("id"));
        goods = goodsOracle_table.getGoods(i);
        customer = (Customer)req.getSession().getAttribute("customer");
        req.getSession().setAttribute("goods",goods);
        req.getRequestDispatcher("/Pet_Message_Page.jsp").forward(req,res);
    }

    @Override
    public void destroy(){
        super.destroy();
    }
}
