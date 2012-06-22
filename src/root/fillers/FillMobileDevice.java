package root.fillers;

import model.product.Product;
import model.product.mobile.MobileDevice;
import model.product.mobile.MobileDevice.OS;

public class FillMobileDevice extends FillDecorator{

	public FillMobileDevice(FillDecorator decorator) {
		super(decorator);
	}
	public FillMobileDevice() {
	}
	@Override
	public void fill(Product product) {
		super.fill(product);
		if(product instanceof MobileDevice){
			MobileDevice mobileDevice = (MobileDevice) product;
			mobileDevice.setBatteryCapacity(getInt("batterycapacity"));
			mobileDevice.setCameraResolution(getFloat("cameraresolution"));
			mobileDevice.setDiagonal(getFloat("diagonal"));
			mobileDevice.setGPS(getBoolean("gps"));
			mobileDevice.setOs(getEnum("os", OS.values()));
		}
	}

}
