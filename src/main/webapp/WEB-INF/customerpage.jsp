<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user");%>

        <h1>My profile</h1>
        <p>Hello <strong><%=user.getEmail()%></strong> </p>
        <p>You are now logged in as a customer of our wonderful site.</p>
        <p>Your role is: <strong><%=user.getRole()%></strong></p>
        <p>Please choose between:</p>
        <ul>
            <li><a href="FrontController?command=enterorder">Order a Lego house</a></li>
            <li><a href="FrontController?command=viewmyorderlist">View my order list</li>
            <li><a href="index.jsp">Go to login page</a></li>
        </ul>

    </body>
</html>
