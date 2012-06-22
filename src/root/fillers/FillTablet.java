package root.fillers;

import model.product.Product;
import model.product.mobile.Tablet;
import model.product.mobile.Tablet.DisplayResolution;
import model.product.mobile.Tablet.ProccessorProducer;

public class FillTablet extends FillDecorator{

	public FillTablet(FillDecorator decorator) {
		super(decorator);
	}
	public FillTablet() {
	}
	@Override
	public void fill(Product product) {
		super.fill(product);
		if(product instanceof Tablet){
			Tablet tablet = (Tablet) product;
			tablet.setDisplayResolution(getEnum("displayresolution", DisplayResolution.values()));
			tablet.setCoreFrequency(getFloat("corefrequency"));
			tablet.setProccessorProducer(getEnum("processorproducer", ProccessorProducer.values()));
			tablet.setRamVolume(getInt("ram"));
			tablet.setHddVolume(getInt("hdd"));
			tablet.setNumberOfUSB(getInt("numberofusb"));
			tablet.setHDMI(getBoolean("HDMI"));
		}
	}

}
