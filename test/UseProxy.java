import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Before;
import org.junit.Test;

import model.product.Articul1;
import model.product.mobile.CellPhone;
import model.product.mobile.CellPhoneProxy;
import model.product.mobile.CellProneInterface;
import model.product.mobile.MobileDevice.OS;


public class UseProxy {
	CellProneInterface cpi;
	@Before
	public void setup(){
		CellPhone cellPhone = new CellPhone(new Articul1("olololo"));
		cellPhone.setBatteryCapacity(1458);
		cellPhone.setBluetooth(true);
		cellPhone.setCameraResolution(46.456);
		cellPhone.setColor("asd");
		cellPhone.setCost(156);
		cellPhone.setDescription("asd");
		cellPhone.setDiagonal(156.54);
		cellPhone.setGPS(true);
		cellPhone.setNumberOfSims(1);
		cellPhone.setOs(OS.Bada);
		cellPhone.setProducer("asdkl");
		cellPhone.setSensor(false);
		cellPhone.setTitle("nokia 500");
		cellPhone.setWifi(false);
		
		cpi = (CellProneInterface) Proxy.newProxyInstance(CellPhone.class.getClassLoader(), 
				new Class[]{CellProneInterface.class},
				new CellPhoneProxy(cellPhone));
	}
	@Test(expected=UnsupportedOperationException.class)
	public void check(){
		cpi.setBluetooth(false);
	}
	@Test
	public void cc(){
		assertEquals(true, cpi.isGPS());
	}
}
