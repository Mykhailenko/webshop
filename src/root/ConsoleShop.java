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

import model.User;
import model.product.Product;
import model.shop.Order;

public class ConsoleShop {
	private static final Logger LOGGER = Logger.getRootLogger();
	public final int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
	private ShopFacade facade;
	private Scanner in;
	private User user;
	private static ResourceBundle res;
	private FillProducts fillProducts;
	
	public ConsoleShop(ShopFacade facade) {
		super();
		this.facade = facade;
		this.in = new Scanner(System.in);
	}
	public void start() {
		p("====Gleb Web Shop====");
		chooseLocale();
		login();
		chooseAddProductMethod();
		mainCycle();
	}
	private void chooseLocale() {
		p("Enter the language(by index):");
		p("0 - english;");
		p("1 - russian;");
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
					selectProduct();
					List<Product> products = facade.getAllProducts();
					for (int i = 0; i < products.size(); ++i) {
						p(i + " : " + products.get(i).toString());
					}
					int index = in.nextInt();
					if (0 <= index && index < products.size()) {
						Product product = products.get(index);
						facade.putProductInBag(user, product);
					}
					break;
				case 1:
					p("your bag contains:");
					Map<Product, Integer> bag = facade.getProductsInBag(user);
					Iterator<Map.Entry<Product, Integer>> it = bag.entrySet()
							.iterator();
					while (it.hasNext()) {
						Map.Entry<Product, Integer> entry = it.next();
						p(entry.getValue() + " X " + entry.getKey().toString());
					}
					break;
				case 2:
					long cost = facade.getCostForWholeBag(user);
					p("total cost: " + cost);
					break;
				case 3:
					p("if u really want buy the bag enter 'y', if u not want - enter 'n'");
					String ch = in.next();
					if (ch.equals("y")) {
						if (facade.buyWholeBag(user)) {
							p("your are successfully bought the bag!");
						} else {
							p("something gets wrong!");
						}
					}
					break;
				case 4:
					p("the latest 5 product added in your bag:");
					for (Product product : facade.get5LastProductsInBag(user)) {
						p(product.toString());
					}
					break;
				case 5:
					facade.clearBag(user);
					break;
				case 6:
					p("enter the time FROM(k:mm):");
					String s = in.next();
					SimpleDateFormat sdf1 = new SimpleDateFormat("k:mm");
					Date dateFrom = null;
					try {
						dateFrom = sdf1.parse(s);
					} catch (ParseException e) {
						return;
					}
					p("enter the time TO(k:mm):");
					s = in.next();
					Date dateTo = null;
					try {
						dateTo = sdf1.parse(s);
					} catch (ParseException e) {
						return;
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
					break;
				case 7:
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"dd/MM/yyyy");
					p("enter the date in format dd/mm/yyyy");
					String sDate = in.next();
					Date date2 = null;
					try {
						date2 = dateFormat.parse(sDate);
					} catch (ParseException e) {
						return;
					}
					Date nextDay = new Date(date2.getTime() + MILLIS_IN_DAY);
					printOrdersFromDateToDate(date2, nextDay);
					break;
				case 8:
					addProducts();
					break;
				case 9:
					return;
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
	
	private void addProducts() {
		fillProducts.fill();
	}


	private void chooseAddProductMethod() {
		p(res.getString("choose_add_product_mode"));
		int act = in.nextInt();
		if(act == 0){
			fillProducts = new GenerateProducts(user, facade);
		}else{
			fillProducts = new HandFillProducts(user, facade);
		}
	}

	

	private void printOrdersFromDateToDate(Date from, Date to) {
		SortedMap<Date, Order> map = facade.getAllOrders(user).subMap(from, to);
		Iterator<Order> x = map.values().iterator();
		while (x.hasNext()) {
			Order order = x.next();
			System.out.println(order);
		}
	}

	private void login() {
		p(res.getString("pr_login"));
		String login = in.next();
		p(res.getString("pr_password"));
		String password = in.next();
		user = facade.login(login, password);
		if (user == null) {
			p(res.getString("er_password_login_wrong"));
			throw new UnregisteredUserOrIncorrectPasswordException();
		}
	}

	private void selectProduct() {
		p(res.getString("pr_select_product"));
	}

	private void printOpportunities() {
		p(res.getString("choose_action"));
		
	}

	private static void p(String s) {
		System.out.println(s);
	}
	public static ResourceBundle getRes() {
		return res;
	}
}
