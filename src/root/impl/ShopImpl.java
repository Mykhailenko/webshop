package root.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import root.exceptions.AccessViolationException;
import root.exceptions.RegisterException;
import root.exceptions.UnloggedUserException;
import root.interfaces.Bag;
import root.interfaces.Shop;
import root.interfaces.UserManager;
import util.SaverLoaderUtil;

import model.User;
import model.product.Product;
import model.shop.Order;

public class ShopImpl implements Shop {
	private static final Logger LOGGER = Logger.getRootLogger();
	private List<Product> products = new ArrayList<Product>();
	private TreeMap<Date, Order> orders = new TreeMap<Date, Order>();
	private UserManager userManager = new UserManagerImpl();

	@Override
	public boolean register(String login, String password, String email) {
		try {
			return userManager.register(login, password, email);
		} catch (RegisterException e) {
			return false;
		}
	}

	@Override
	public User login(String login, String password) {
		return userManager.login(login, password);
	}

	@Override
	public boolean logout(User user) {
		return userManager.logout(user);
	}

	@Override
	public List<Product> getAllProducts() {
		return Collections.unmodifiableList(products);
	}

	@Override
	public boolean buyBag(User user, Bag bag) throws UnloggedUserException {
		synchronized (user) {
			if (userManager.isLogged(user.getLogin())) {
				Order order = new Order(user, bag.getProductsInBag(), Calendar
						.getInstance().getTime());
				orders.put(order.getDate(), order);
				bag.clearBag();
				return true;
			} else {
				throw new UnloggedUserException();
			}
		}
	}

	@Override
	public Bag createBag() {
		return new BagImpl();
	}

	@Override
	public NavigableMap<Date, Order> getAllOrders(User user)
			throws AccessViolationException {
		return orders;
	}

	@Override
	public boolean addProduct(User user, Product product)
			throws AccessViolationException {
		if (!products.contains(product)) {
			return products.add(product);
		} else {
			return false;
		}
	}

	@Override
	public boolean saveToFile(String fileName) {
		try {
			Object [] arr = new Object[]{
					getAllOrders(null), getAllProducts(), userManager };
			SaverLoaderUtil.saveObjectToFile(arr, fileName);
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean loadFromFile(String fileName) {
		try {
			LOGGER.info("check");
			Object[] arr = SaverLoaderUtil.loadObjectFromFile(fileName);
			LOGGER.info("check2");
			LOGGER.info(arr.length);
			this.orders.clear();
			this.orders.putAll((TreeMap<Date, Order>) arr[0]);
			
			this.products.clear();
			this.products.addAll((List<Product>) arr[1]);
			
			this.userManager = (UserManager) arr[2];
			LOGGER.info("loaded from " + fileName);
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}
}
