import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Before;
import org.junit.Test;

import model.product.Articul1;
import model.product.mobile.CellPhone;
import model.product.mobile.CellPhoneProxyMap;
import model.product.mobile.CellProneInterface;
import model.product.mobile.MobileDevice.OS;


public class UseProxyMap {
	CellProneInterface cpi;
	@Before
	public void setup(){
		cpi = (CellProneInterface) Proxy.newProxyInstance(CellPhone.class.getClassLoader(), 
				new Class[]{CellProneInterface.class},
				new CellPhoneProxyMap(new Articul1("olololo")));
		cpi.setBatteryCapacity(1458);
		cpi.setBluetooth(true);
		cpi.setCameraResolution(46.456);
		cpi.setColor("asd");
		cpi.setCost(156);
		cpi.setDescription("asssd");
		cpi.setDiagonal(156.54);
		cpi.setGPS(true);
		cpi.setNumberOfSims(1);
		cpi.setOs(OS.Bada);
		cpi.setProducer("asdkl");
		cpi.setSensor(false);
		cpi.setTitle("nokia 500");
		cpi.setWifi(false);
		
	}
	
	@Test
	public void t(){
		assertEquals("olololo", cpi.getArticul().toString());
		assertEquals(1458, cpi.getBatteryCapacity());
		assertEquals(true,cpi.isBluetooth());
		assertEquals(46.456,cpi.getCameraResolution(), 0.01);
		assertEquals("asd",cpi.getColor());
		assertEquals(156,cpi.getCost());
		assertEquals("asssd",cpi.getDescription());
		assertEquals(156.54,cpi.getDiagonal(), 0.01);
		assertEquals(true,cpi.isGPS());
		assertEquals(1,cpi.getNumberOfSims());
		assertEquals(OS.Bada,cpi.getOs());
		assertEquals("asdkl",cpi.getProducer());
		assertEquals(false,cpi.isSensor());
		assertEquals("nokia 500",cpi.getTitle());
		assertEquals(false,cpi.isWifi());
	}
	@Test
	public void o(){
		cpi.setColor("qqq");
		assertEquals("qqq", cpi.getColor());
		cpi.setWifi(true);
		assertTrue(cpi.isWifi());
	}
}
