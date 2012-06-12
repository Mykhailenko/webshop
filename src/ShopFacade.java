import java.util.List;

import model.User;
import model.product.Product;
import model.shop.Order;

public interface ShopFacade {

	boolean login(String login, String password);
	
	boolean logout(String login);
	
	boolean putProductInBag(Product p);

	List<Product> getProductsInBag(User user);

	long getPriceForWholeBag(User user);

	boolean buyWholeBag(User user);

	List<Product> getNLastProductsInBag(User user, int N);

	List<Order> getAllOrders();
}
