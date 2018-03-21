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
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jobe
 */
public class CreateOrder extends Command {
    
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        int width = Integer.parseInt(request.getParameter( "width" ));
        int length = Integer.parseInt(request.getParameter("length"));
        int height = Integer.parseInt(request.getParameter( "height" ));
        Order order = LogicFacade.createOrder(length, width, height);
        ItemList itemList = LogicFacade.createItemList(order);
        request.setAttribute("itemList", itemList);
        return "ordercreated";
    }
    
    
}
