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
			tablet.setDisplayResolution(getEnum("display resolution", DisplayResolution.values()));
			tablet.setCoreFrequency(getFloat("core frequency"));
			tablet.setProccessorProducer(getEnum("processor producer", ProccessorProducer.values()));
			tablet.setRamVolume(getInt("ram"));
			tablet.setHddVolume(getInt("hdd"));
			tablet.setNumberOfUSB(getInt("number of usbs"));
			tablet.setHDMI(getBoolean("HDMI"));
		}
	}

}
