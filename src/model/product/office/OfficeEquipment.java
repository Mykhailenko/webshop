package model.product.office;

import java.text.MessageFormat;

import model.product.AbstractArticul;
import model.product.NamedAttribute;
import model.product.Product;

public class OfficeEquipment extends Product {
	public enum Format {
		A5, A4, A3;
	}
	public enum PrintingTechnology {
		LED, Fluid, Laser, Martix, Tverdochernilnaya;
	}
	
	private Format format;
	private boolean colorPrinting;
	private PrintingTechnology printingTechnology;
	private boolean wifi;
	private boolean usb2_0;
	public OfficeEquipment(AbstractArticul articul){
		super(articul);
	}
	
	public OfficeEquipment(AbstractArticul articul, String title, String producer, String description,long cost,  
			Format format,	PrintingTechnology printingTechnology, 
			boolean colorPrinting,	boolean wifi, boolean usb2_0) {
		super(articul, title, producer, description, cost);
		this.format = format;
		this.printingTechnology = printingTechnology;
		this.colorPrinting = colorPrinting;
		this.wifi = wifi;
		this.usb2_0 = usb2_0;
	}

	
	@Override
	public String toString() {
		return MessageFormat
				.format("OfficeEquipment [format={0}, printingTechnology={1}, colorPrinting={2}, wifi={3}, usb2_0={4}, getTitle()={5}, getProducer()={6}, getArticul()={7}, getDescription()={8}]",
						format, printingTechnology, colorPrinting, wifi, usb2_0, getTitle(),
						getProducer(), getArticul(), getDescription());
	}

	@NamedAttribute("format")
	public Format getFormat() {
		return format;
	}
	
	@NamedAttribute("format")
	public void setFormat(Format format) {
		this.format = format;
	}
	
	@NamedAttribute("printingtechnology")
	public PrintingTechnology getPrintingTechnology() {
		return printingTechnology;
	}
	
	@NamedAttribute("printingtechnology")
	public void setPrintingTechnology(PrintingTechnology printingTechnology) {
		this.printingTechnology = printingTechnology;
	}
	
	@NamedAttribute("colorprinting")
	public boolean isColorPrinting() {
		return colorPrinting;
	}
	
	@NamedAttribute("colorprinting")
	public void setColorPrinting(boolean colorPrinting) {
		this.colorPrinting = colorPrinting;
	}
	
	@NamedAttribute("wifi")
	public boolean isWifi() {
		return wifi;
	}
	
	@NamedAttribute("wifi")
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	@NamedAttribute("usb2_0")
	public boolean isUsb2_0() {
		return usb2_0;
	}
	@NamedAttribute("usb2_0")
	public void setUsb2_0(boolean usb2_0) {
		this.usb2_0 = usb2_0;
	}
}
