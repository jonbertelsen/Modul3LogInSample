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
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jobe
 */
public class ToggleSentStatus extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int orderId = Integer.parseInt(request.getParameter("orderid"));
        LogicFacade.toggleSentStatus(orderId);
        Order order = LogicFacade.getOrder(orderId);
        request.setAttribute("order", order);
        User user = LogicFacade.getUser(order.getUserId());
        request.setAttribute("user", user);
        ItemList itemList = LogicFacade.createItemList(order);
        request.setAttribute("itemList", itemList);
        return "vieworder";
    }

}
