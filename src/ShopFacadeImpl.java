import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	public User login(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logout(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putProductInBag(User user, Product p) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Product> getProductsInBag(User user) {
		return new ArrayList(shop.getBags().get(user).values());
	}

	@Override
	public long getCostForWholeBag(User user) {
		Map<Product, Object> bag = shop.getBags().get(user);
		Iterator<Product> it = bag.keySet().iterator();
		long cost = 0;
		while(it.hasNext()){
			Product product = it.next();
			cost += product.getCost();
		}
		return cost;
	}

	@Override
	public boolean buyWholeBag(User user) {
		Map<Product, Object> bag = shop.getBags().get(user);
		
		return false;
	}

	@Override
	public List<Product> getNLastProductsInBag(User user, int N) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrders(User user) {
		return Collections.unmodifiableList(new ArrayList(shop.getOrders().values()));
	}


}
