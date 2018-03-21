<%-- 
    Document   : ordercreated
    Created on : Mar 21, 2018, 8:49:03 AM
    Author     : jobe
--%>

<%@page import="FunctionLayer.ItemList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Created</title>
    </head>
    <body>
        <h1>Thank you - your order is received</h1>
        
        <% 
            ItemList itemList = (ItemList)request.getAttribute("itemList");
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
            out.print(String.format("<tr><td>Sum</td><td>%d</td><td>%d</td><td>%d</td></tr>", itemList.sumColumn(ItemList.ONE),itemList.sumColumn(ItemList.TWO),itemList.sumColumn(ItemList.FOUR)));
            out.print("</table>");
 
%>
        
        
        
    </body>
</html>
