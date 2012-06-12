package model.shop;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import model.User;
import model.product.Product;

public class Shop {
	final private Map<Product, Integer> products = new HashMap<Product, Integer>();
	final private Map<User, LinkedHashMap<Product, Object>> bags = new HashMap<User, LinkedHashMap<Product,Object>>();
	final private TreeMap<Date, Order> orders = new TreeMap<Date, Order>();
	final private Map<String, User> customers = new HashMap<String, User>();
	final private Map<String, User> admins = new HashMap<String, User>();
	final private LinkedHashMap<User, Date> loginedUsers = new LinkedHashMap<User, Date>();
	public Map<Product, Integer> getProducts() {
		return products;
	}
	public Map<User, LinkedHashMap<Product, Object>> getBags() {
		return bags;
	}
	public Map<Date, Order> getOrders() {
		return orders;
	}
	public Map<String, User> getCustomers() {
		return customers;
	}
	public Map<String, User> getAdmins() {
		return admins;
	}
	public LinkedHashMap<User, Date> getLoginedUsers() {
		return loginedUsers;
	}
}	
