import static org.junit.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;

import model.User;
import model.product.Articul1;
import model.product.office.MFU.OpticalResolution;
import model.product.office.OfficeEquipment.Format;
import model.product.office.OfficeEquipment.PrintingTechnology;
import model.product.office.Printer;
import model.shop.Shop;

import org.apache.log4j.Logger;
import org.junit.Test;

import root.ConsoleShop;
import root.ShopFacadeImpl;


public class ConsoleShopTest {
//	private static final Logger LOGGER = Logger.getRootLogger();
	@Test
	public void t() {
		ConsoleShop consoleShop = new ConsoleShop(new ShopFacadeImpl(getShop()));
		consoleShop.start();
	}
	public static Shop getShop(){
		Shop shop = new Shop();
		User user = new User("m@gmail.com", "devic", "‚|ËêŠplL4¡h‘øN{");
		shop.getCustomers().put(user.getLogin(), user);
		shop.getLoginedUsers().put(user, Calendar.getInstance().getTime());
		Printer printer = new Printer(new Articul1("printer0"), 
				"printer0", "producer0", 
				"description0", 150000, Format.A4, 
				PrintingTechnology.Laser, false, true, true);
		shop.addProduct(printer);
		Printer printer1 = new Printer(new Articul1("printer1"), 
				"printer1", "producer1", 
				"description1", 160000, Format.A4, 
				PrintingTechnology.Laser, false, true, true);
		shop.addProduct(printer1);
		assertEquals(2, shop.getProducts().size());
		return shop;
	}
}
