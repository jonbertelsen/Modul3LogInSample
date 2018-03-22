<%-- 
    Document   : vieworder
    Created on : Mar 22, 2018, 5:17:28 PM
    Author     : jobe
--%>

<%@page import="FunctionLayer.ItemList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Order</title>
    </head>
    <body>
        <h1>View customer order</h1>

        <% User user = (User) request.getAttribute("user"); %>
        <% Order order = (Order) request.getAttribute("order");%>

        <p>This order was placed by:</p>
        <p>Email: <%=user.getEmail()%></p>
        <p>Role: <%=user.getRole()%></p>

        <table border="1">
            <thead>
            <th>OrderId</th>
            <th>Length</th>
            <th>Height</th>
            <th>Width</th>
            <th>Order Date</th>
            <th>Sent</th>
        </thead>
        <%
            String isOrderSent = (order.isOrderSent()) ? "Yes" : "No";

            out.print(String.format("<tr><td>%d</td><td>%d</td><td>%d</td><td>%d</td><td>%s</td><td>%s</td></tr>",
                    order.getOrderId(), order.getLength(), order.getWidth(), order.getWidth(),
                    order.getOrderCreated(), isOrderSent));
        %>
    </table>

    <h2>Change sent status</h2>
    <form action="FrontController" name="ordersent" method="POST">
        <input type="hidden" name="command" value="togglesentstatus">
        <input type="hidden" name="orderid" value="<%=order.getOrderId()%>">
        <input type="submit"  value="Toggle status">
    </form>

    <h2>Item list</h2>

    <%
        ItemList itemList = (ItemList) request.getAttribute("itemList");
        int[][] brickArray = itemList.getItemList();

        out.print("<table border=1");
        out.print("<thead><th>Wall</th><th>Brick-1</th><th>Brick-2</th><th>Brick-4</th></thead>");
        for (int walls = ItemList.FRONTWALL; walls <= ItemList.LEFTWALL; walls++) {
            out.print(String.format("<tr><td>%d</td> ", walls));
            for (int bricks = ItemList.ONE; bricks <= ItemList.FOUR; bricks++) {
                out.print(String.format("<td>%d</td>", brickArray[walls][bricks]));
            }
            out.print("</tr>");
        }
        out.print(String.format("<tr><td>Sum</td><td>%d</td><td>%d</td><td>%d</td></tr>",
                itemList.sumColumn(ItemList.ONE), itemList.sumColumn(ItemList.TWO), itemList.sumColumn(ItemList.FOUR)));
        out.print("</table>");

    %>

    <ul>
        <li><a href="FrontController?command=viewallorders">View all orders</li>
        <li><a href="FrontController?command=employeepage">Go to my profile</a></li>
        <li><a href="index.jsp">Go to login page</a></li>
    </ul>


</body>
</html>
