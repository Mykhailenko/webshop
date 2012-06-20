package root.fillers;

import java.util.Scanner;

import model.User;
import model.product.Articul1;
import model.product.Product;
import model.product.mobile.CellPhone;
import model.product.mobile.Tablet;
import model.product.office.MFU;
import model.product.office.Printer;
import root.ConsoleShop;
import root.interfaces.FillProducts;
import root.interfaces.Shop;

public class HandDecoratorFillProducts implements FillProducts {
	private Scanner in = new Scanner(System.in);
	private Shop facade;
	private User user;
	
	public HandDecoratorFillProducts(Shop facade, User user) {
		super();
		this.facade = facade;
		this.user = user;
	}
	@Override
	public void fill() {
		print(ConsoleShop.getRes().getString("fill_start") + COUNT + " " + ConsoleShop.getRes().getString("fill_start1"));
		Product product = null;
		FillDecorator asDecorator;
		FillDecorator asChain = new FillProduct(new FillMobileDevice(new FillCellPhone(new FillTablet(new FillOfficeEquipment(new FillPrinter(new FillMFU()))))));
		for(int i = 0; i < COUNT; ++i){
			asDecorator = null;
			question();
			int nextInt = in.nextInt();
			switch (nextInt) {
			case 0:
				product = new Printer(new Articul1(getArticle()));
				asDecorator = new FillPrinter(new FillOfficeEquipment(new FillProduct()));
				break;
			case 1:
				product = new MFU(new Articul1(getArticle()));
				asDecorator = new FillMFU(new FillOfficeEquipment(new FillProduct()));
				break;
			case 2:
				product = new CellPhone(new Articul1(getArticle()));
				asDecorator = new FillCellPhone(new FillMobileDevice(new FillProduct()));
				break;
			case 3:
				product = new Tablet(new Articul1(getArticle()));
				asDecorator = new FillTablet(new FillMobileDevice(new FillProduct()));
				break;
			default:
				--i;
				break;
			}
			if(asDecorator != null){
				asChain.fill(product);
//				decorator.fill(product);
				facade.addProduct(user, product);
			}
		}
	}
	private void question(){
		print(ConsoleShop.getRes().getString("fill_questn"));
	}
	private String getArticle(){
		print(ConsoleShop.getRes().getString("put_article"));
		return in.next();
	}
	public void print(String s){
		System.out.println(s);
	}
}
