/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.ItemList;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jobe
 */
public class ViewMyOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int orderId = Integer.parseInt(request.getParameter("orderid"));
        Order order = LogicFacade.getOrder(orderId);
        request.setAttribute("order", order);
        ItemList itemList = LogicFacade.createItemList(order);
        request.setAttribute("itemList", itemList);
        return "viewmyorder";
    }
}
