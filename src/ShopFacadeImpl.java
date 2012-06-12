import java.util.List;

import model.User;
import model.product.Product;
import model.shop.Order;
import model.shop.Shop;


public class ShopFacadeImpl implements ShopFacade {
	private final Shop shop;
	
	public ShopFacadeImpl(Shop shop) {
		super();
		this.shop = shop;
	}

	@Override
	public boolean login(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout(String login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putProductInBag(Product p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getProductsInBag(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getPriceForWholeBag(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean buyWholeBag(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getNLastProductsInBag(User user, int N) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
