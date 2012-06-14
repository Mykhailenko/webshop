package root;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

import model.User;
import model.product.Product;
import model.shop.Order;
import model.shop.Shop;


public class ShopFacadeImpl implements ShopFacade{
	final private Shop shop;
	public ShopFacadeImpl(Shop shop) {
		super();
		this.shop = shop;
	}

	@Override
	public User login(String login, String password) {
		User user = shop.getCustomers().get(login);
		if(user != null){
			if(hashForPassword(password).equals(user.getHashPassword())){
				shop.getLoginedUsers().put(user, Calendar.getInstance().getTime());
				return user;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	private static String hashForPassword(String pass){
		MessageDigest md = null;
		byte[] bytesOfMessage = null;
		try {
			bytesOfMessage = pass.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
		}
		String s = null;
		s = new String(md.digest(bytesOfMessage));
		return s;
	}

	@Override
	public boolean logout(User user) {
		shop.getLoginedUsers().remove(user);
		return true;
	}

	@Override
	public List<Product> getAllProducts() {
		return shop.getProducts();
	}

	@Override
	public boolean putProductInBag(User user, Product p)
			throws UnloginedUserException {
		checkIfUserLogined(user);
		putInBagAndCashedBag(user, p);
		return true;
	}
	private void putInBagAndCashedBag(User user, Product p){
		synchronized (user) {
			Map<Product,Integer> bag = getUserBag(user);
			Integer count = bag.get(p);
			if(count == null){
				bag.put(p, 1);
			}else{
				bag.put(p, count + 1);
			}
			CashedBag cashedBag = getUserCashedBag(user);
			cashedBag.put(p, null);
		}
	}
	private Map<Product, Integer> getUserBag(User user){
		Map<Product, Integer> bag = null;
		synchronized (user) {
			bag = shop.getBags().get(user);
			if(bag == null){
				bag = new HashMap<Product, Integer>();
				shop.getBags().put(user, bag);
			}
		}
		return bag;
	}
	private CashedBag getUserCashedBag(User user){
		CashedBag bag = null;
		synchronized (user) {
			bag = shop.getLast5().get(user);
			if(bag == null){
				bag = new CashedBag();
				shop.getLast5().put(user, bag);
			}
		}
		return bag;
	}
	private void checkIfUserLogined(User user) throws UnloginedUserException{
		synchronized (user) {
			if(!shop.getLoginedUsers().containsKey(user)){
				throw new UnloginedUserException(user.getLogin());
			}
		}
	}
	@Override
	public Map<Product, Integer> getProductsInBag(User user)
			throws UnloginedUserException {
		synchronized (user) {
			checkIfUserLogined(user);
			return getUserBag(user);
		}
	}

	@Override
	public long getCostForWholeBag(User user) throws UnloginedUserException {
		checkIfUserLogined(user);
		long cost = 0;
		Iterator<Map.Entry<Product, Integer>> it = getUserBag(user).entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Product, Integer> entry = it.next();
			cost += entry.getKey().getCost() * entry.getValue();
		}
		return cost;
	}

	@Override
	public boolean buyWholeBag(User user) throws UnloginedUserException {
		synchronized (user) {
			Order order = new Order(user, getUserBag(user), Calendar.getInstance().getTime());
			shop.getOrders().put(order.getDate(), order);
			createNewUserBagAndCashedBag(user);
		}
		return true;
	}
	private void createNewUserBagAndCashedBag(User user){
		synchronized (user) {
			shop.getBags().put(user, new HashMap<Product, Integer>());
			shop.getLast5().put(user, new CashedBag());
		}
	}
	@Override
	public List<Product> get5LastProductsInBag(User user)
			throws UnloginedUserException {
		synchronized (user) {
			checkIfUserLogined(user);
			Iterator<Product> it = getUserCashedBag(user).keySet().iterator();
			List<Product> result = new ArrayList<Product>();
			while(it.hasNext()){
				result.add(it.next());
			}
			return result;
		}
	}

	@Override
	public NavigableMap<Date, Order> getAllOrders(User user) {
		// TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return shop.getOrders();
	}

	@Override
	public void clearBag(User user) {
		createNewUserBagAndCashedBag(user);
	}

	@Override
	public boolean addProduct(User user, Product product)
			throws AccessViolationException {
		return shop.addProduct(product);
	}
}
