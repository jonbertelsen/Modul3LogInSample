/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author jobe
 */
public class OrderMapper {

    public static void createOrder(Order order, User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Orders (userId, length, width, height, orderSent) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.setBoolean(5, false);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setOrderId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getOrderList(int userId) throws LoginSampleException {
        try {
            ArrayList<Order> orderList = new ArrayList<>();
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders WHERE userId = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userId);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                Timestamp orderCreated = rs.getTimestamp("orderDate");
                boolean orderSent = rs.getBoolean("orderSent");
                Order order = new Order(orderId, userId, length, width, height, orderCreated, orderSent);
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getOrderList() throws LoginSampleException {
        try {
            ArrayList<Order> orderList = new ArrayList<>();
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("userId");
                int orderId = rs.getInt("orderId");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                Timestamp orderCreated = rs.getTimestamp("orderDate");
                boolean orderSent = rs.getBoolean("orderSent");
                Order order = new Order(orderId, userId, length, width, height, orderCreated, orderSent);
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static Order getOrder(int orderId) throws LoginSampleException {

        try {

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders WHERE orderId = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("userId");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                Timestamp orderCreated = rs.getTimestamp("orderDate");
                boolean orderSent = rs.getBoolean("orderSent");
                Order order = new Order(orderId, userId, length, width, height, orderCreated, orderSent);
                return order;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return null;
    }

    public static void toggleSentStatus(int orderId) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE Orders SET orderSent = NOT orderSent WHERE orderId = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
