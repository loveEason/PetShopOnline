<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/22
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>PetShopOnLine</title>
  </head>
  <body style="background-image: url(<%=request.getContextPath()+"/background.jpg"%>)">
  <%
    String message = (String)request.getAttribute("message");
    if(message == null) message = " ";

    if(message.equals("Sorry,the password you input is wrong,please try another password.") ||
            message.equals("Sorry,the account you input is not exist,please try another account.")) {
  %>
  <h5 style="position:relative; left:500px; top:150px; color: red"><%=message%></h5>
  <%
    }else{
  %>
  <h5 style="position:relative; left:500px; top:150px; color: green"><%=message%></h5>
  <%
    }
  %>
    <table style="position: relative; left:550px; top:200px">
      <form action="/PetShop/LoginServlet" method="post">
        <tr>
          <th>Account:   </th>
          <th><input type="text" name="account" /></th>
        </tr>
        <tr>
          <th>Password:   </th>
          <th><input type="password" name="password" /></th>
        </tr>
        <tr></tr>
        <tr>
          <th style="margin-top:10px">
            <input type="submit" name="loginButton" value="Login" />
          </th>
      </form>
      <form action="Register_Page.jsp" method="post">
          <th>
            <input type="submit" name="registerButton" value="Register" />
          </th>
        </tr>
      </form>
    </table>
  </body>
</html>
