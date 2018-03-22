<%-- 
    Document   : enterorder
    Created on : Mar 21, 2018, 8:16:42 AM
    Author     : jobe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order page</h1>

        <p>Please enter your order here:</p>

        <form name="createorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="createorder">

            Length in dots: <input type="text" name="length" value="">
            <br/>
            Width in dots: <input type="text" name="width" value="">                  
            <br/>
            Height in bricks: <input type="text" name="height" value="">
            <br/>
            <input type="submit" value="Submit">          
        </form>

        <ul>
            <li><a href="FrontController?command=customerpage">Go to my profile</a></li>
            <li><a href="index.jsp">Go to login page</a></li>
        </ul>
    </body>
</html>
