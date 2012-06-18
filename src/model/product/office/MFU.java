package model.product.office;

import java.text.MessageFormat;

import model.product.AbstractArticul;
import model.product.NamedAttribute;

public class MFU extends OfficeEquipment{
	private static final long serialVersionUID = 6614482025943522472L;
	public enum OpticalResolution {
		dpi300x300,
		dpi400x600,
		dpi600x600,
		dpi1200x600,
		dpi1200x1200,
		dpi2400x600,
		dpi2400x1200,
		dpi2400x2400,
		dpi4800x2400,
		dpi4800x4800,
		dpi9600x4800,
		dpi9600x9600;
	}
	private boolean LAN;
	private boolean cardReader;
	private OpticalResolution opticalResolution;
	public MFU(AbstractArticul articul){
		super(articul);
	}
	public MFU(AbstractArticul articul, String title, String producer, Format format, String description,long cost, 
			PrintingTechnology printingTechnology, boolean colorPrinting,
			boolean wifi, boolean usb2_0, boolean lAN, boolean cardReader,
			OpticalResolution opticalResolution) {
		super(articul, title, producer, description, cost,format, printingTechnology, colorPrinting, wifi, usb2_0);
		LAN = lAN;
		this.cardReader = cardReader;
		this.opticalResolution = opticalResolution;
	}
	
	
	@Override
	public String toString() {
		return MessageFormat
				.format("MFU [LAN={0}, cardReader={1}, opticalResolution={2}, getFormat()={3}, getPrintingTechnology()={4}, isColorPrinting()={5}, isWifi()={6}, isUsb2_0()={7}, getTitle()={8}, getProducer()={9}, getId()={10}, getDescription()={11}]",
						LAN, cardReader, opticalResolution, getFormat(), getPrintingTechnology(),
						isColorPrinting(), isWifi(), isUsb2_0(), getTitle(), getProducer(),
						getArticul(), getDescription());
	}

	@NamedAttribute("lan")
	public boolean isLAN() {
		return LAN;
	}
	
	@NamedAttribute("lan")
	public void setLAN(boolean lAN) {
		LAN = lAN;
	}
	
	@NamedAttribute("cardreader")
	public boolean isCardReader() {
		return cardReader;
	}
	
	@NamedAttribute("cardreader")
	public void setCardReader(boolean cardReader) {
		this.cardReader = cardReader;
	}
	
	@NamedAttribute("opticalresolution")
	public OpticalResolution getOpticalResolution() {
		return opticalResolution;
	}
	
	@NamedAttribute("opticalresolution")
	public void setOpticalResolution(OpticalResolution opticalResolution) {
		this.opticalResolution = opticalResolution;
	}
	
	
}
