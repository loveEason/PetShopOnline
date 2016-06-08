<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/23
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cn.myself.basic.Customer" %>
<%@ page import="cn.myself.basic.ShoppingCart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet Shop Page</title>
</head>
<body style="background-image: url(<%=request.getContextPath()+"/background.jpg"%>)">
<%
    Customer customer = (Customer)(session.getAttribute("customer"));

    String[] urls = {"/icon/dog.png", "/icon/cat.png", "/icon/turtle.png",
        "/icon/parrot.png", "/icon/hamster.png", "/icon/squirrel.png",
        "/icon/rabbit.png", "/icon/snake.png", "/icon/lizard.png",
        "/icon/fish.png", "/icon/myna.png", "/icon/canary.png",};
%>
<table style="position: relative; left:400px; top:10px">
  <tr>
    <th height="30" style="margin-top:10px;margin-left:20px">Welcome!<%= customer.getName()%></th>
    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
    <th>
      <form action="index.jsp" method="post"><input type="submit" name="logoutButton" value="Logout" /></form>
    </th>
  </tr>
  <tr>
    <th style="margin-top:10px;margin-left:20px">Here are pet-goods in our shop.</th>
    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
    <th>
      <form action="Shop_Cart_Page.jsp" method="post"><input type="submit" name="shopcartButton" value="ShopCart" /></form>
    </th>
  </tr>
</table>
<br /><br /><br />
<table style="position: relative; left:400px;">
  <tr>
    <% for(int i=1;i<=3;i++) {%>
        <td><a href="/PetShop/GetPetServlet?id=<%=i%>"><img src=<%=request.getContextPath()+urls[i-1]%> /></a></td>
    <%
        }
    %>
  </tr>
  <tr>
      <% for(int i=4;i<=6;i++) {%>
      <td><a href="/PetShop/GetPetServlet?id=<%=i%>"><img src=<%=request.getContextPath()+urls[i-1]%> /></a></td>
      <%
          }
      %>
  </tr>
  <tr>
      <% for(int i=7;i<=9;i++) {%>
      <td><a href="/PetShop/GetPetServlet?id=<%=i%>"><img src=<%=request.getContextPath()+urls[i-1]%> /></a></td>
      <%
          }
      %>
  </tr>
</table>
</body>
</html>
