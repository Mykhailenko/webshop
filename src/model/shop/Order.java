package model.shop;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import model.User;
import model.product.Product;

public class Order implements Serializable {
	private static final long serialVersionUID = 1951729146508464863L;

	public enum PaymentMethod {
		CASH, CASHLESS;
	}
	public enum DeliveryMethod {
		DELIVERY, SELF_CARE;
	}
	private User user;
	private Map<Product, Integer> bag;
	private PaymentMethod paymentMethod;
	private DeliveryMethod deliveryMethod;
	private Date date;
	public Order() {
	}
	
	public Order(User user, Map<Product, Integer> bag, Date date) {
		super();
		this.user = user;
		this.bag = bag;
		this.date = date;
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
	public String toString() {
		return MessageFormat.format("Order [user={0}, date={1}, totalCost()={2}]",
				user, date, totalCost());
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
	
	
	private long totalCost(){
		long cost = 0;
		Iterator<Map.Entry<Product, Integer>> it = this.bag.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Product, Integer> entry = it.next();
			cost += entry.getKey().getCost() * entry.getValue();
		}
		return cost;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<Product, Integer> getBag() {
		return bag;
	}
	public void setBag(Map<Product, Integer> bag) {
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
