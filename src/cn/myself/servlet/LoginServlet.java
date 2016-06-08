package cn.myself.servlet;

import cn.myself.basic.Customer;
import cn.myself.basic.ShoppingCart;
import cn.myself.basic.UserService;
import cn.myself.oracle.Customer_Oracle_TABLE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录处理Servlet
 */
public class LoginServlet extends HttpServlet {
    Customer customer = new Customer();
    UserService userService = new UserService();
    Customer_Oracle_TABLE customer_oracle_table = new Customer_Oracle_TABLE();
    String message = null;

    @Override
    public void init() throws ServletException{}

    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        res.setContentType("text/html;charset=gb2312");
        PrintWriter out = res.getWriter();

        int judge = userService.Login(account,password);
        switch (judge) {
            case 0:
                message = "Sorry,the account you input is not exist,please try another account.";
                req.setAttribute("message",message);
                req.getRequestDispatcher("index.jsp").forward(req,res);
                break;
            case 1:
                message = "Sorry,the password you input is wrong,please try another password.";
                req.setAttribute("message",message);
                req.getRequestDispatcher("index.jsp").forward(req,res);
                break;
            case 2:
                customer = customer_oracle_table.getCustomer(account);
                customer.setCart(new ShoppingCart());
                req.getSession().setAttribute("customer", customer);
                req.getRequestDispatcher("Pet_Shop_Page.jsp").forward(req,res);
                break;
            default:
                out.println("<h3>ERROR</h3>");
        }
    }

    @Override
    public void destroy(){super.destroy();}
}
