import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import model.product.Product;

import org.apache.log4j.Logger;
import org.junit.Test;

import root.interfaces.Shop;

import util.SaverLoaderUtil;

public class SaverLoaderUtilTest {
	private static final Logger LOGGER = Logger.getRootLogger();
	@Test
	public void t(){
		Shop shop = ConsoleShopTest.getShop();
		try {
			SaverLoaderUtil.saveObjectToFile(shop.getAllProducts(), "products");
		} catch (IOException e) {
			LOGGER.error(e);
			assertTrue(false);
		}
		assertTrue(true);
	}
	@Test
	public void tread(){
		List<Product> s = null;  
		try {
			s = SaverLoaderUtil.<List<Product>>loadObjectFromFile("products");
		} catch (Exception e) {
			LOGGER.error(e);
			assertTrue(false);
		}
		Iterator<Product> it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		assertTrue(true);
	}
	@Test
	public void countTest(){
		Shop shop = ConsoleShopTest.getShop();
		try {
			SaverLoaderUtil.saveObjectNTimesToFile(shop.getAllProducts(), "many", 10000);
		} catch (IOException e) {
			LOGGER.error(e);
			assertTrue(false);
		}
		assertTrue(true);
	}
	@Test
	public void testGZip(){
		Shop shop = ConsoleShopTest.getShop();
		try{
			SaverLoaderUtil.saveGZipObjectNTimesToFile(shop.getAllProducts(), "zipMany", 10000);
		} catch (IOException e) {
			LOGGER.error(e);
			assertTrue(false);
		}
		assertTrue(true);
	}
}
