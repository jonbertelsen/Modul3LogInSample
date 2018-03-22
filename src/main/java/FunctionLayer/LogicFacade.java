package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static User getUser(int userId) throws LoginSampleException {
        return UserMapper.getUser(userId);
    }

    public static Order createOrder(int length, int width, int height, User user) throws LoginSampleException {
        Order order = new Order(0, 0, length, width, height, null, false);
        OrderMapper.createOrder(order, user);
        return order;
    }

    public static Order getOrder(int orderId) throws LoginSampleException {
        return OrderMapper.getOrder(orderId);
    }

    public static ArrayList<Order> getOrderlist(int userId) throws LoginSampleException {
        ArrayList<Order> orderArrayList;
        orderArrayList = OrderMapper.getOrderList(userId);
        return orderArrayList;
    }

    public static ArrayList<Order> getOrderlist() throws LoginSampleException {
        ArrayList<Order> orderArrayList;
        orderArrayList = OrderMapper.getOrderList();
        return orderArrayList;
    }

    public static ItemList createItemList(Order order) {
        ItemList itemList = new ItemList(order);
        return itemList;
    }

    public static void toggleSentStatus(int orderId) throws LoginSampleException {
        OrderMapper.toggleSentStatus(orderId);
    }

}
