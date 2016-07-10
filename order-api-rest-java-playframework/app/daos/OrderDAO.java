package daos;

import java.util.List;

import javax.persistence.Query;

import models.Order;
import play.api.Logger;
import play.db.jpa.JPA;

public class OrderDAO {
	/**
	 * Place an Order
	 *
	 * @param Order
	 *            model
	 *
	 * @return Order
	 */
	public static Order create(Order model) {
		model.emptyToNull();
		JPA.em().persist(model);
		// Flush and refresh for check
		JPA.em().flush();
		JPA.em().refresh(model);
		return model;
	}

	/**
	 * test if an Order exists by order orderId
	 *
	 * @param Integer
	 *            orderId
	 *
	 * @return Order
	 */
	public static Order find(Integer orderId) {
		return JPA.em().find(Order.class, orderId);
	}

	/**
	 * Update an Order
	 *
	 * @param Order
	 *            model
	 *
	 * @return Order
	 */
	public static Order update(Order model) {
		return JPA.em().merge(model);
	}

	/**
	 * Delete an order by orderId
	 *
	 * @param Integer
	 *            orderId
	 */
	public static void delete(Integer orderId) {
		Order model = JPA.em().getReference(Order.class, orderId);
		JPA.em().remove(model);
	}

	/**
	 * Query orders by customer's name
	 *
	 * @return List<Order>
	 */
	public static List<Order> queryOrderByName(String customerName) {
		Query q = JPA.em().createQuery("from " + Order.TABLE + " o where o.customerName = :customerName",
				Order.class);
		return (List<Order>) q.setParameter("customerName", customerName).getResultList();
	}

	/**
	 * Get the page of orders
	 *
	 * @param Integer
	 *            page
	 * @param Integer
	 *            size
	 *
	 * @return List<Order>
	 */
	public static List<Order> paginate(Integer page, Integer size, String customerName) {
		Query q = JPA.em().createQuery("from " + Order.TABLE + " o where o.customerName = :customerName");
		q.setParameter("customerName", customerName).setFirstResult(page * size).setMaxResults(size);
		return (List<Order>) q.getResultList();
	}

	/**
	 * Get the number of total row
	 *
	 * @return Long
	 */
	public static Long count(String customerName) {
		return (Long) JPA.em().createQuery("SELECT count(o) FROM " + Order.TABLE + " o where o.customerName = :customerName")
				.setParameter("customerName", customerName).getSingleResult();
	}
}
