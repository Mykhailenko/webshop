import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import model.product.Product;
import model.shop.Shop;

import org.apache.log4j.Logger;
import org.junit.Test;

import util.SaverLoaderUtil;

public class SaverLoaderUtilTest {
	private static final Logger LOGGER = Logger.getRootLogger();
	@Test
	public void t(){
		Shop shop = ConsoleShopTest.getShop();
		try {
			SaverLoaderUtil.saveObjectToFile(shop.getProducts(), "products");
		} catch (IOException e) {
			LOGGER.error(e);
			assertTrue(false);
		}
		assertTrue(true);
	}
	@Test
	public void tread(){
		Set<Product> s = null;  
		try {
			s = SaverLoaderUtil.<Set<Product>>loadObjectFromFile("products");
		} catch (Exception e) {
			LOGGER.error(e);
			assertTrue(false);
		}
		Iterator<Product> it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	@Test
	public void countTest(){
		Shop shop = ConsoleShopTest.getShop();
		try {
			SaverLoaderUtil.saveObjectNTimesToFile(shop.getProducts(), "many", 10000);
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
			SaverLoaderUtil.saveGZipObjectNTimesToFile(shop.getProducts(), "zipMany", 10000);
		} catch (IOException e) {
			LOGGER.error(e);
			assertTrue(false);
		}
		assertTrue(true);
	}
}
