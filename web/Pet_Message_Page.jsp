<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/23
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="cn.myself.basic.Customer" %>
<%@ page import="cn.myself.basic.Goods" %>
<%@ page import="cn.myself.basic.ShoppingCart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet Message Page</title>
</head>
<body style="background-image: url(<%=request.getContextPath()+"/background.jpg"%>)">
  <%
    Customer customer = (Customer)session.getAttribute("customer");
    Goods goods = (Goods)session.getAttribute("goods");
    String[] urls = {"/icon/dog.png", "/icon/cat.png", "/icon/turtle.png",
            "/icon/parrot.png", "/icon/hamster.png", "/icon/squirrel.png",
            "/icon/rabbit.png", "/icon/snake.png", "/icon/lizard.png",
            "/icon/fish.png", "/icon/myna.png", "/icon/canary.png",};
    ShoppingCart shoppingCart = customer.getCart();
    String message = (String)request.getAttribute("message");
    if(message == null) message=" ";
  %>
  <form action="Pet_Shop_Page.jsp" method="post"><input type="submit" name="backButton" value="<--Back" style="float:left" /></form>
  <form action="Shop_Cart_Page.jsp" method="post"><input type="submit" name="shopcartButton" value="ShopCart" style="float:right"/></form>
  <img src="<%=request.getContextPath()+urls[goods.getId()-1]%>" style="position:relative; left:500px; top:100px" />
  <%
    if(message.equals("Succeed to add to shopcart.")) {
  %>
  <h5 style="position:relative; left:500px; top:120px; color: green"><%=message%></h5>
  <%
    }else{
  %>
  <h5 style="position:relative; left:500px; top:120px; color: red"><%=message%></h5>
  <%
    }
  %>
  <h5 style="position:relative; left:450px; top:200px">Name:       <%=goods.getName()%></h5>
  <h5 style="position:relative; left:450px; top:210px">Eat:        <%=goods.getEat()%></h5>
  <h5 style="position:relative; left:450px; top:220px">Drink:      <%=goods.getDrink()%></h5>
  <h5 style="position:relative; left:450px; top:230px">Live:       <%=goods.getLive()%></h5>
  <h5 style="position:relative; left:450px; top:240px">Hobby:      <%=goods.getHobby()%></h5>
  <h5 style="position:relative; left:450px; top:250px">Price:      <%=goods.getPrice()%></h5>
  <h5 style="position:relative; left:450px; top:260px">Inventory:  <%=goods.getInventory()%></h5>
  <form action="/PetShop/AddToShopCartServlet?id=<%=goods.getId()%>" method="post">
    <h5 style="position:relative; left:450px; top:270px" >Want to buy:
      <input type="text" name="numbers"/>
      <input type="submit" value="Add to my ShopCart" />
    </h5>
  </form>
</body>
</html>
