package root.interfaces;

import java.util.Date;
import java.util.List;
import java.util.NavigableMap;

import root.exceptions.AccessViolationException;
import root.exceptions.RegisterException;
import root.exceptions.UnloggedUserException;

import model.User;
import model.product.Product;
import model.shop.Order;

public interface Shop {

	boolean register(String login, String password, String email) throws RegisterException;
	
	User login(String login, String password);
	
	boolean logout(User user);
	
	List<Product> getAllProducts();
	
	boolean buyBag(User user, Bag bag) throws UnloggedUserException;
	
	Bag createBag();

	NavigableMap<Date, Order> getAllOrders(User user) throws AccessViolationException;
	
	boolean addProduct(User user, Product product) throws AccessViolationException;
	
	boolean saveToFile(String fileName);
	
	boolean loadFromFile(String fileName);
}
