<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/23
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="cn.myself.basic.Customer" %>
<%@ page import="cn.myself.basic.ShoppingCart" %>
<%@ page import="cn.myself.oracle.LinkToOracle" %>
<%@ page import="cn.myself.basic.Goods" %>
<%@ page import="cn.myself.oracle.Goods_Oracle_TABLE" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop Cart Page</title>
</head>
<%
  Customer customer = (Customer)session.getAttribute("customer");
  ShoppingCart shoppingCart = customer.getCart();
  Set set = shoppingCart.getMap().keySet();
  int keys = set.size();
  Iterator iterator = set.iterator();
  Goods_Oracle_TABLE goodsOracle_table = new Goods_Oracle_TABLE();
  Goods goods = new Goods();
  float prices = 0;
  String message = (String)request.getAttribute("message");
  if(message == null) message=" ";
%>
<body style="background-image: url(<%=request.getContextPath()+"/background.jpg"%>)">
  <form action="Pet_Shop_Page.jsp" method="post"><input type="submit" name="backButton" value="<--Back" style="float:left" /></form>
  <%
    if(message.equals("Thank you! You have buy them.")) {
  %>
  <h5 style="position:relative; left:400px; top:10px; color: green"><%=message%></h5>
  <%
    }else{
  %>
  <h5 style="position:relative; left:400px; top:10px; color: red"><%=message%></h5>
  <%
    }
  %>
  <h5 style="position:relative; left:400px; top:50px">Here are your shopping list:</h5>
  <%
    for(int i=0;i<keys;i++) {
      if(iterator.hasNext()) {
        int key = (Integer)iterator.next();
        goods = goodsOracle_table.getGoods(key);
        prices += goods.getPrice()*shoppingCart.getMap().get(key);
  %>
        <h6 style="position: relative; left: 400px; top: 60px">
          <%=goods.getName()%>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=shoppingCart.getMap().get(key)%>
        </h6>
  <%
      }
    }
  %>
  <form action="/PetShop/BuyServlet" method="post">
    <h5 style="position:relative; left:450px; top:55px">
      Sum of prices is:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=prices%>
      <input type="submit" name="payButton" value="Pay" style="position:relative; left:100px"/>
    </h5>
  </form>
</body>
</html>
