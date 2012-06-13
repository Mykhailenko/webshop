package root;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.SortedMap;

import model.User;
import model.product.Product;
import model.shop.Order;

public class ConsoleShop {
	public final int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
	private ShopFacade facade;
	private Scanner in;
	private User user;
	public ConsoleShop(ShopFacade facade) {
		super();
		this.facade = facade;
		this.in = new Scanner(System.in);
	}

	public void start() {
		p("====Gleb Web Shop====");
		login();
		while (true) {
			printOpportunities();
			int action = in.nextInt();
			switch (action) {
			case 0:
				selectProduct();
				List<Product> products = facade.getAllProducts();
				for(Product product : products){
					p(product.toString());
				}
				int index = in.nextInt();
				if(0 <= index && index < products.size()){
					Product product = products.get(index);
					facade.putProductInBag(user, product);
				}
				break;
			case 1:
				p("your bag contains:");
				Map<Product, Integer> bag = facade.getProductsInBag(user);
				Iterator<Map.Entry<Product, Integer>> it = bag.entrySet().iterator();
				while(it.hasNext()){
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
				if(ch.equals("y")){
					if(facade.buyWholeBag(user)){
						p("your are successfully bought the bag!");
					}else{
						p("something gets wrong!");
					}
				}
				break;
			case 4:
				p("the latest 5 product added in your bag:");
				for(Product product : facade.get5LastProductsInBag(user)){
					p(product.toString());
				}
				break;
			case 5:
				facade.clearBag(user);
				break;
			case 6:
				p("enter the time FROM(h:mm):");
				String s = in.next();
				SimpleDateFormat sdf1 = new SimpleDateFormat("h:mm");
				Date dateFrom = null;
				try {
					dateFrom = sdf1.parse(s);
				} catch (ParseException e) {
					return;
				}
				p("enter the time TO(h:mm):");
				s = in.next();
				Date dateTo = null;
				try {
					dateTo = sdf1.parse(s);
				} catch (ParseException e) {
					return;
				}
				Date date = Calendar.getInstance().getTime();
				Calendar curr—alendar = Calendar.getInstance();
				Calendar calendar = Calendar.getInstance();
				dateFrom.setYear(date.getYear());
				dateFrom.setMonth(date.getMonth());
				dateFrom.setDate(date.getDate());
				dateTo.setYear(date.getYear());
				dateTo.setMonth(date.getMonth());
				dateTo.setDate(date.getDate());
				printOrdersFromDateToDate(dateFrom, dateTo);
				break;
			case 7:
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
				return;
			default:
				break;
			}
		}

	}
	private void printOrdersFromDateToDate(Date from, Date to){
		SortedMap<Date, Order> map = facade.getAllOrders(user).subMap(from, to);;
		Iterator<Order> x = map.values().iterator();
		while(x.hasNext()){
			Order order = x.next();
			System.out.println(order);
		}
	}
	
	private void login(){
		p("login:");
		String login = in.next();
		p("password:");
		String password = in.next();
		user = facade.login(login, password);
		if(user == null){
			throw new UnregisteredUserException();
		}
	}
	private static void selectProduct(){
		p("if u want select and add product to bag enter the index of product, or if u don't want select any product - enter the '-1'");
	}
	private static void printOpportunities() {
		p("Chooes action:");
		p("0 - get products list;");
		p("1 - get the bag;");
		p("2 - get total cost of bag;");
		p("3 - buy the bag;");
		p("4 - get the latest 5 products in bag;");
		p("5 - clear the bag");
		p("6 - get orders for term;");
		p("7 - get orders for date;");
		p("8 - exit;");
	}

	private static void p(String s) {
		System.out.println(s);
	}
}
