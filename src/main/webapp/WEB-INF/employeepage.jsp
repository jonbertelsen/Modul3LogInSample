<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>

        <% User user = (User) session.getAttribute("user");%>

        <h1>My admin profile</h1>
        <p>Hello <strong><%=user.getEmail()%></strong> </p>
        <p>You are now logged in as a EMPLOYEE of our wonderful site.</p>

        <p>Your role is: <strong><%=user.getRole()%></strong></p>
        <p>Please choose between:</p>
        <ul>
            <li><a href="FrontController?command=viewallorders">View complete order list</li>
            <li><a href="index.jsp">Go to login page</a></li>
        </ul>
    </body>
</html>
