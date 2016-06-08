package cn.myself.servlet;

import cn.myself.basic.Customer;
import cn.myself.basic.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册处理Servlet
 */
public class RegisterServlet extends HttpServlet {
    String message = null;
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
        String name = req.getParameter("name");
        String account = req.getParameter("accountNumber");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password_again");
        if (!password.equals(password2)) {
            message = "Two passwords are different!Please input again!";
            req.setAttribute("message",message);
            req.getRequestDispatcher("/Register_Page.jsp").forward(req,res);
        } else {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setAccountNumber(account);
            customer.setPassword(password);
            UserService userService = new UserService();
            boolean judge = userService.Register(customer);
            if (judge) {
                message = "Succeed to Register!Now you can login!";
                req.setAttribute("message",message);
                req.getRequestDispatcher("/index.jsp").forward(req,res);
            } else {
                message = "Account already exists! Please use another account!";
                req.setAttribute("message",message);
                req.getRequestDispatcher("/Register_Page.jsp").forward(req,res);
            }
        }
    }
}
