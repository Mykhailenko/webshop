import java.util.List;

import model.User;
import model.product.Product;
import model.shop.Order;

public interface ShopFacade {

	User login(String login, String password);
	
	boolean logout(User user);
	
	boolean putProductInBag(User user, Product p);

	List<Product> getProductsInBag(User user);

	long getCostForWholeBag(User user);

	boolean buyWholeBag(User user);

	List<Product> getNLastProductsInBag(User user, int N);

	List<Order> getAllOrders(User user);
}
