/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.sql.Timestamp;

/**
 *
 * @author jobe
 */
public class Order {

    private int orderId;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    private int length;
    private int height;
    private int width;
    private Timestamp orderCreated;
    private boolean orderSent;

    public boolean isOrderSent() {
        return orderSent;
    }

    public void setOrderSent(boolean orderSent) {
        this.orderSent = orderSent;
    }

    public Order(int orderId, int userId, int length, int width, int height, Timestamp orderCreated, boolean orderSent) {
        this.orderId = orderId;
        this.userId = userId;
        this.length = length;
        this.height = height;
        this.width = width;
        this.orderCreated = orderCreated;
        this.orderSent = orderSent;
    }

    public Timestamp getOrderCreated() {
        return orderCreated;
    }

    public void setOrderCreated(Timestamp orderCreated) {
        this.orderCreated = orderCreated;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
