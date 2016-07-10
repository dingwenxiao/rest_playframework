package services;

import java.util.List;

import daos.OrderDAO;
import models.Order;

public class OrderService {
	 /**
     * place an Order
     *
     * @param Order data
     *
     * @return Order
     */
    public static Order create(Order data) {
        return OrderDAO.create(data);
    }

    /**
     * Update an order
     *
     * @param Order data
     *
     * @return Order
     */
    public static Order update(Order data) {
        return OrderDAO.update(data);
    }

    /**
     * Find an order by orderId
     *
     * @param Integer orderId
     *
     * @return order
     */
    public static Order find(Integer orderId) {
        return OrderDAO.find(orderId);
    }

    /**
     * Delete an order by orderId
     *
     * @param Integer orderId
     */
    public static Boolean delete(Integer orderId) {
    	Order order = OrderDAO.find(orderId);
        if (order != null) {
        	OrderDAO.delete(orderId);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get all orders
     *
     * @return List<Order>
     */
//    public static List<Order> all() {
//        return OrderDAO.all();
//    }

    /**
     * Get the page of orders by customer name
     *
     * @param Integer page
     * @param Integer size
     * @param String customerName
     * @return List<Order>
     */
    public static List<Order> paginate(Integer page, Integer size, String customerName) {
        return OrderDAO.paginate(page, size,customerName);
    }

    /**
     * Get the number of total of a customer's orders 
     *
     * @return Long
     */
    public static Long count(String customerName) {
        return OrderDAO.count(customerName);
    }
}
