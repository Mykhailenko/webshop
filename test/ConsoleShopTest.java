import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import model.User;
import model.product.Articul1;
import model.product.office.MFU.OpticalResolution;
import model.product.office.OfficeEquipment.Format;
import model.product.office.OfficeEquipment.PrintingTechnology;
import model.product.office.Printer;
import model.shop.Shop;

import org.junit.Test;

import root.ConsoleShop;
import root.ShopFacadeImpl;


public class ConsoleShopTest {
	@Test
	public void t(){
		Shop shop = new Shop();
		User user = new User("m@gmail.com", "devic", "5");
		shop.getCustomers().put(user.getLogin(), user);
		shop.getLoginedUsers().put(user, Calendar.getInstance().getTime());
		Printer printer = new Printer(new Articul1("printer0"), 
				"printer0", "producer0", 
				"description0", 150000, Format.A4, 
				PrintingTechnology.Laser, false, true, true, 
				true, false, OpticalResolution.dpi1200x600);
		shop.getProducts().add(printer);
		Printer printer1 = new Printer(new Articul1("printer1"), 
				"printer1", "producer1", 
				"description1", 160000, Format.A4, 
				PrintingTechnology.Laser, false, true, true, 
				true, false, OpticalResolution.dpi1200x600);
		shop.getProducts().add(printer1);
		assertEquals(2, shop.getProducts().size());
		ConsoleShop consoleShop = new ConsoleShop(new ShopFacadeImpl(shop));
		consoleShop.start();
	}
}
