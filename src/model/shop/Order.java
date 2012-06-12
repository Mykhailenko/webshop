package model.shop;

import java.util.Date;
import java.util.LinkedHashMap;

import model.User;
import model.product.Product;

public class Order {
	public enum PaymentMethod {
		CASH, CASHLESS;
	}
	public enum DeliveryMethod {
		DELIVERY, SELF_CARE;
	}
	private User user;
	private LinkedHashMap<Product, Object> bag;
	private PaymentMethod paymentMethod;
	private DeliveryMethod deliveryMethod;
	private Date date;
	public Order(User user, LinkedHashMap<Product, Object> bag,
			PaymentMethod paymentMethod, DeliveryMethod deliveryMethod, Date date) {
		super();
		this.user = user;
		this.bag = bag;
		this.paymentMethod = paymentMethod;
		this.deliveryMethod = deliveryMethod;
		this.setDate(date);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bag == null) ? 0 : bag.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (bag == null) {
			if (other.bag != null)
				return false;
		} else if (!bag.equals(other.bag))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LinkedHashMap<Product, Object> getBag() {
		return bag;
	}
	public void setBag(LinkedHashMap<Product, Object> bag) {
		this.bag = bag;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
