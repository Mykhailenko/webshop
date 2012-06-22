package root.fillers;

import model.product.Product;
import model.product.office.OfficeEquipment;
import model.product.office.OfficeEquipment.Format;
import model.product.office.OfficeEquipment.PrintingTechnology;

public class FillOfficeEquipment extends FillDecorator{

	public FillOfficeEquipment(FillDecorator decorator) {
		super(decorator);
	}
	public FillOfficeEquipment() {
	}
	@Override
	public void fill(Product product) {
		super.fill(product);
		if(product instanceof OfficeEquipment){
			OfficeEquipment officeEquipment = (OfficeEquipment) product;
			officeEquipment.setColorPrinting(getBoolean("colorprinting"));
			officeEquipment.setFormat(getEnum("format", Format.values()));
			officeEquipment.setPrintingTechnology(getEnum("printingtechnology", PrintingTechnology.values()));
			officeEquipment.setUsb2_0(getBoolean("usb2_0"));
			officeEquipment.setWifi(getBoolean("wifi"));
		}
	}

}
