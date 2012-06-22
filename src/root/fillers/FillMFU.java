package root.fillers;

import model.product.Product;
import model.product.office.MFU;
import model.product.office.MFU.OpticalResolution;

public class FillMFU extends FillDecorator{

	public FillMFU(FillDecorator decorator) {
		super(decorator);
	}
	public FillMFU() {
	}
	@Override
	public void fill(Product product) {
		super.fill(product);
		if(product instanceof MFU){
			MFU mfu = (MFU)product; 
			mfu.setCardReader(getBoolean("cardreader"));
			mfu.setLAN(getBoolean("lan"));
			mfu.setOpticalResolution(getEnum("opticalresolution", OpticalResolution.values()));
		}
	
	}

}
