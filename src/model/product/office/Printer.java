package model.product.office;

import java.text.MessageFormat;

import model.product.AbstractArticul;
import model.product.office.MFU.OpticalResolution;


public class Printer extends OfficeEquipment{

	public Printer(AbstractArticul articul){
		super(articul);
	}
	public Printer(AbstractArticul articul, String title, String producer, String description, long cost,  
			Format format, PrintingTechnology printingTechnology, boolean colorPrinting,
			boolean wifi, boolean usb2_0, boolean lAN, boolean cardReader,
			OpticalResolution opticalResolution) {
		super(articul, title, producer, description, cost, format, printingTechnology, colorPrinting, wifi, usb2_0);
	}

	@Override
	public String toString() {
		return MessageFormat
				.format("Printer [getTitle()={0}, getPrintingTechnology()={1}, isColorPrinting()={2}, isWifi()={3}, isUsb2_0()={4}, getFormat()={5}, getProducer()={6}, getArticul()={7}, getDescription()={8}, getCost()={9}]",
						getTitle(), getPrintingTechnology(), isColorPrinting(), isWifi(), isUsb2_0(),
						getFormat(), getProducer(), getArticul(), getDescription(), getCost());
	}
	
}
