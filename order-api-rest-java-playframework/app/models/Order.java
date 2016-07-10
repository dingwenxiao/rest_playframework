package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.data.validation.Constraints;

@Entity
@Table(name="orders")
public class Order {
	 public static String TABLE = Order.class.getSimpleName();

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer orderId;

	    private Date orderTime;
	    
	    private double totalPrice;
	    
	    @Constraints.Required
	    private String customerName;

	    
	    public Integer getOrderId() {
			return orderId;
		}

		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}

		public Date getOrderTime() {
			return orderTime;
		}

		public void setOrderTime(Date orderTime) {
			this.orderTime = orderTime;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		/**
	     * Set all empty values to null
	     */
	    public void emptyToNull() {
	        if (customerName != null && customerName.isEmpty()) customerName = null;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (obj == this) {
	            return true;
	        } if (obj == null || obj.getClass() != this.getClass()) {
	            return false;
	        }
	        Order order = (Order) obj;
	        if(order.getOrderId()!=null && orderId!=null) {
	        	return order.getOrderId().equals(this.orderId);
	        } else {
	        	return order.customerName.equals(this.customerName); 
	        }
	    }

	    @Override
	    public int hashCode() {
	    	 final int prime = 31;
	         int result = 1;
	         result = prime * result + ((orderId == null) ? 0 : orderId);
	         result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
	         return result;
	    }
}
