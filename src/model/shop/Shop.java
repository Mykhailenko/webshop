package model.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import root.CashedBag;

import model.User;
import model.product.Product;

public class Shop implements Serializable{
	private static final long serialVersionUID = 7119227837763428951L;
	
	
	final private List<Product> products = new ArrayList<Product>();
	final private Map<User, Map<Product, Integer>> bags = new HashMap<User, Map<Product,Integer>>();
	final private Map<User, CashedBag> last5 = new HashMap<User, CashedBag>();
	final private TreeMap<Date, Order> orders = new TreeMap<Date, Order>();
	final private Map<String, User> customers = new HashMap<String, User>();
	final private Map<String, User> admins = new HashMap<String, User>();
	transient final private LinkedHashMap<User, Date> loginedUsers = new LinkedHashMap<User, Date>();
	
	
	public Map<User, Map<Product, Integer>> getBags() {
		return bags;
	}
	public Map<User, CashedBag> getLast5() {
		return last5;
	}
	public TreeMap<Date, Order> getOrders() {
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
	public boolean addProduct(Product product){
		if(!products.contains(product)){
			return products.add(product);
		}else{
			return false;
		}
	}
	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
	}
}	
