import static org.junit.Assert.assertEquals;

import model.product.Articul1;
import model.product.office.OfficeEquipment.Format;
import model.product.office.OfficeEquipment.PrintingTechnology;
import model.product.office.Printer;

import org.apache.log4j.Logger;
import org.junit.Test;

import root.ConsoleShop;
import root.exceptions.RegisterException;
import root.impl.ShopImpl;
import root.interfaces.Shop;
import static org.junit.Assert.*;


public class ConsoleShopTest {
	private static final Logger LOGGER = Logger.getRootLogger();
	@Test
	public void t() {
		ConsoleShop consoleShop = new ConsoleShop(getShop());
		consoleShop.start();
	}
	public static Shop getShop(){
		Shop shop = new ShopImpl();
		
		try {
			assertTrue(shop.register("devic", "12345", "m@gmail.com"));
		} catch (RegisterException e) {
			LOGGER.error(e);
		}
		
		Printer printer = new Printer(new Articul1("printer0"), 
				"printer0", "producer0", 
				"description0", 150000, Format.A4, 
				PrintingTechnology.Laser, false, true, true);
		shop.addProduct(null, printer);
		Printer printer1 = new Printer(new Articul1("printer1"), 
				"printer1", "producer1", 
				"description1", 160000, Format.A4, 
				PrintingTechnology.Laser, false, true, true);
		shop.addProduct(null, printer1);
		assertEquals(2, shop.getAllProducts().size());
		return shop;
	}
}
