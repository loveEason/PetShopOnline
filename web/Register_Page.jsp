<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/23
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<%
  String message = (String)request.getAttribute("message");
  if(message == null) message = " ";
%>
<body style="background-image: url(<%=request.getContextPath()+"/background.jpg"%>)">
  <form action="/PetShop/RegisterServlet" method="post">
    <h5 style="position:relative; left:400px; top:10px; color: red"><%=message%></h5>
    <h5 style="position:relative; left:400px; top:20px">
      Name:
      <input type="text" name="name" style="position:relative; left:130px"/>
    </h5>
    <h5 style="position:relative; left:400px; top:30px">
      Account:
      <input type="text" name="accountNumber" style="position:relative; left:120px"/>
    </h5>
    <h5 style="position:relative; left:400px; top:50px">
      Password:
      <input type="password" name="password" style="position:relative; left:110px"/>
    </h5>
    <h5 style="position:relative; left:400px; top:70px">
      Password again:
      <input type="password" name="password_again" style="position:relative; left:70px"/>
    </h5>
    <input type="submit" name="register" value="Register" style="position:relative; left:600px; top:90px" />
  </form>
  <form action="index.jsp" method="post">
    <input type="submit" name="backButton" value="<--Back" style="position:relative; left:450px; top:50px"/>
  </form>
</body>
</html>
