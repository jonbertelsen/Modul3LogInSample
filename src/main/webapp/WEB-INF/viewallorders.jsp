<%-- 
    Document   : viewallorders
    Created on : Mar 22, 2018, 5:09:13 PM
    Author     : jobe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View all orders</title>
    </head>
    <body>

        <% User user = (User) session.getAttribute("user"); %>
        <% ArrayList<Order> orderList = (ArrayList<Order>) request.getAttribute("orderList");%>

        <h1>Order handling</h1>
        <p>I am an admin with:</p>
        <p>Email: <%=user.getEmail()%></p>
        <p>Role: <%=user.getRole()%></p>
        <table border="1">
            <thead>
            <th>OrderId</th>
            <th>UserId</th>
            <th>Length</th>
            <th>Height</th>
            <th>Width</th>
            <th>Order Date</th>
            <th>Sent</th>
            <th>View Order</th>
        </thead>
        <%
            for (Order order : orderList) {
                String isOrderSent = (order.isOrderSent()) ? "Yes" : "No";
                String viewOrderLink = String.format("<a href=\"FrontController?command=vieworder&orderid=%d\">view</a>", order.getOrderId());

                out.print(String.format("<tr><td>%d</td><td>%d</td><td>%d</td><td>%d</td><td>%d</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                        order.getOrderId(), order.getUserId(), order.getLength(), order.getWidth(), order.getWidth(),
                        order.getOrderCreated(), isOrderSent, viewOrderLink));
            }

        %>

    </table>

    <ul>
        <li><a href="FrontController?command=employeepage">Go to my profile</a></li>
        <li><a href="index.jsp">Go to login page</a></li>
    </ul>

</body>
</html>
