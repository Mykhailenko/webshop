package root;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

import model.User;
import model.product.Product;
import model.shop.Order;

public interface ShopFacade {

	User login(String login, String password);
	
	boolean logout(User user);
	
	List<Product> getAllProducts();
	
	boolean putProductInBag(User user, Product p) throws UnloginedUserException;

	Map<Product, Integer> getProductsInBag(User user)throws UnloginedUserException;

	long getCostForWholeBag(User user)throws UnloginedUserException;

	boolean buyWholeBag(User user)throws UnloginedUserException;

	List<Product> get5LastProductsInBag(User user)throws UnloginedUserException;

	NavigableMap<Date, Order> getAllOrders(User user);
	
	void clearBag(User user);
}
