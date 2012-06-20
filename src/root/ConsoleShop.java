package root;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.SortedMap;

import org.apache.log4j.Logger;

import root.exceptions.UnregisteredUserOrIncorrectPasswordException;
import root.fillers.GenerateProducts;
import root.fillers.GenerateProductsReflection;
import root.fillers.HandDecoratorFillProducts;
import root.fillers.HandFillProducts;
import root.fillers.HandFillProductsReflection;
import root.interfaces.Bag;
import root.interfaces.FillProducts;
import root.interfaces.Shop;

import model.User;
import model.product.Product;
import model.shop.Order;

public class ConsoleShop {
	private static final Logger LOGGER = Logger.getRootLogger();
	private static final String FILE_NAME = "shop";
	public final int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
	private Shop shop;
	private Bag bag;
	private Scanner in;
	private User user;
	private static ResourceBundle res;
	private FillProducts fillProducts;
	
	public ConsoleShop(Shop facade) {
		super();
		this.shop = facade;
		this.in = new Scanner(System.in);
	}
	public void start() {
		print("====Gleb Web Shop====");
		chooseLocale();
		login();
		chooseAddProductMethod();
		loadFromFile();
		mainCycle();
	}
	private void chooseLocale() {
		print("Enter the language(by index):");
		print("0 - english;");
		print("1 - russian;");
		int lang = in.nextInt();
		if(lang == 1){
			LOGGER.info("russin selected;");
			Locale.setDefault(new Locale("ru"));
		}else{
			LOGGER.info("english selected;");
			Locale.setDefault(new Locale("en"));
		}
		res = ResourceBundle.getBundle("data");
	}


	private void mainCycle(){
		while (true) {
			try {
				printOpportunities();
				int action = in.nextInt();
				switch (action) {
				case 0:
					printAll();
					break;
				case 1:
					printBag();
					break;
				case 2:
					printCost();
					break;
				case 3:
					buyBag();
					break;
				case 4:
					printLast();
					break;
				case 5:
					clear();
					break;
				case 6:
					printForPeriod();
					break;
				case 7:
					printForDate();
					break;
				case 8:
					addProducts();
					break;
				case 9:
					saveAndExit();
					break;
				default:
					break;
				}
			} catch (InputMismatchException e) {
				in.close();
				in = new Scanner(System.in);
			}catch(NoSuchElementException eee){
				in.close();
				in = new Scanner(System.in);
			}
		}
	}
	private void loadFromFile(){
		shop.loadFromFile(FILE_NAME);
	}
	private void saveAndExit(){
		shop.saveToFile(FILE_NAME);
		System.exit(0);
	}
	private void printForDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd/MM/yyyy");
		print("enter the date in format dd/mm/yyyy");
		String sDate = in.next();
		Date date2 = null;
		try {
			date2 = dateFormat.parse(sDate);
		} catch (ParseException e) {
		}
		Date nextDay = new Date(date2.getTime() + MILLIS_IN_DAY);
		printOrdersFromDateToDate(date2, nextDay);
	}
	private void printForPeriod() {
		print("enter the time FROM(k:mm):");
		String s = in.next();
		SimpleDateFormat sdf1 = new SimpleDateFormat("k:mm");
		Date dateFrom = null;
		try {
			dateFrom = sdf1.parse(s);
		} catch (ParseException e) {
		}
		print("enter the time TO(k:mm):");
		s = in.next();
		Date dateTo = null;
		try {
			dateTo = sdf1.parse(s);
		} catch (ParseException e) {
		}
		Calendar cur = Calendar.getInstance();
		Calendar from = Calendar.getInstance();
		from.setTime(dateFrom);
		from.set(Calendar.YEAR, cur.get(Calendar.YEAR));
		from.set(Calendar.MONTH, cur.get(Calendar.MONTH));
		from.set(Calendar.DATE, cur.get(Calendar.DATE));
		Calendar to = Calendar.getInstance();
		to.setTime(dateTo);
		to.set(Calendar.YEAR, cur.get(Calendar.YEAR));
		to.set(Calendar.MONTH, cur.get(Calendar.MONTH));
		to.set(Calendar.DATE, cur.get(Calendar.DATE));
		printOrdersFromDateToDate(from.getTime(), to.getTime());
	}
	private void clear() {
		bag.clearBag();
	}
	private void printLast() {
		print("the latest 5 product added in your bag:");
		for (Product product : bag.getLast5Added()) {
			print(product.toString());
		}
	}
	private void buyBag() {
		print("if u really want buy the bag enter 'y', if u not want - enter 'n'");
		String ch = in.next();
		if (ch.equals("y")) {
			if(shop.buyBag(user, bag)){
				print("your are successfully bought the bag!");
			} else {
				print("something gets wrong!");
			}
		}
	}
	private void printCost() {
		long cost = bag.getCostForWholeBag();
		print("total cost: " + cost);
	}
	private void printBag() {
		print("your bag contains:");
		Iterator<Map.Entry<Product, Integer>> it = bag.getProductsInBag().entrySet()
				.iterator();
		while (it.hasNext()) {
			Map.Entry<Product, Integer> entry = it.next();
			print(entry.getValue() + " X " + entry.getKey().toString());
		}
	}
	private void printAll() {
		selectProduct();
		List<Product> products = shop.getAllProducts();
		for (int i = 0; i < products.size(); ++i) {
			print(i + " : " + products.get(i).toString());
		}
		int index = in.nextInt();
		if (0 <= index && index < products.size()) {
			Product product = products.get(index);
			bag.putProductInBag(product);
		}
	}
	
	private void addProducts() {
		fillProducts.fill();
	}


	private void chooseAddProductMethod() {
		print(res.getString("choose_add_product_mode"));
		int act = in.nextInt();
		if(act == 0){
			fillProducts = new GenerateProducts(user, shop);
		}else{
			fillProducts = new HandDecoratorFillProducts(shop, user);
		}
	}

	

	private void printOrdersFromDateToDate(Date from, Date to) {
		SortedMap<Date, Order> map = shop.getAllOrders(user).subMap(from, to);
		Iterator<Order> x = map.values().iterator();
		while (x.hasNext()) {
			Order order = x.next();
			System.out.println(order);
		}
	}

	private void login() {
		print(res.getString("pr_login"));
		String login = in.next();
		print(res.getString("pr_password"));
		String password = in.next();
		user = shop.login(login, password);
		bag = shop.createBag();
		if (user == null) {
			print(res.getString("er_password_login_wrong"));
			throw new UnregisteredUserOrIncorrectPasswordException();
		}
	}

	private void selectProduct() {
		print(res.getString("pr_select_product"));
	}

	private void printOpportunities() {
		print(res.getString("choose_action"));
		
	}

	private static void print(String s) {
		System.out.println(s);
	}
	public static ResourceBundle getRes() {
		return res;
	}
}
