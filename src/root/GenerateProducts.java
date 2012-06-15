package root;

import java.util.Calendar;
import java.util.Random;

import org.apache.log4j.Logger;

import model.User;
import model.product.Articul1;
import model.product.Product;
import model.product.mobile.CellPhone;
import model.product.mobile.MobileDevice;
import model.product.mobile.Tablet;
import model.product.mobile.CellPhone.ShellType;
import model.product.mobile.MobileDevice.OS;
import model.product.mobile.Tablet.DisplayResolution;
import model.product.mobile.Tablet.ProccessorProducer;
import model.product.office.MFU;
import model.product.office.OfficeEquipment;
import model.product.office.Printer;
import model.product.office.MFU.OpticalResolution;
import model.product.office.OfficeEquipment.Format;
import model.product.office.OfficeEquipment.PrintingTechnology;

public class GenerateProducts implements FillProducts{
	private static final Logger LOGGER = Logger.getRootLogger();
	private Random random = new Random(Calendar.getInstance().getTimeInMillis());
	private ShopFacade facade;
	private User user;
	public GenerateProducts(User user, ShopFacade facade) {
		super();
		this.facade = facade;
		this.user = user;
	}
	@Override
	public void fill() {
		LOGGER.info("FILL");
		Printer printer;
		MFU mfu;
		CellPhone cellPhone;
		Tablet tablet;
		for(int i = 0; i < COUNT; ++i){
			LOGGER.info(i + " : " + COUNT);
			int nextInt = random.nextInt(4);
			switch (nextInt) {
			case 0:
				printer = new Printer(new Articul1("printer-articul"+random.nextInt()));
				generatePrinter(printer);
				facade.addProduct(user, printer);
				break;
			case 1:
				mfu = new MFU(new Articul1("mfu-article"+ random.nextInt()));
				generateMFU(mfu);
				facade.addProduct(user, mfu);
				break;
			case 2:
				cellPhone = new CellPhone(new Articul1("cellPhone-articul"+random.nextInt()));
				generateCellPhone(cellPhone);
				facade.addProduct(user, cellPhone);
				break;
			case 3:
				tablet = new Tablet(new Articul1("tablet-articul"+random.nextInt()));
				generateTablet(tablet);
				facade.addProduct(user, tablet);
				break;
			default:
				break;
			}
		}
		
	}
	private void generateProduct(Product product){
		product.setCost(random.nextInt());
		product.setDescription("description" + random.nextInt());
		product.setProducer("producer" + random.nextInt());
		product.setTitle("title" + random.nextInt());
	}
	private void generateOfficeEq(OfficeEquipment officeEquipment){
		generateProduct(officeEquipment);
		officeEquipment.setColorPrinting(random.nextBoolean());
		officeEquipment.setFormat(Format.values()[random.nextInt(Format.values().length)]);
		officeEquipment.setPrintingTechnology(PrintingTechnology.values()[random.nextInt(PrintingTechnology.values().length)]);
		officeEquipment.setUsb2_0(random.nextBoolean());
		officeEquipment.setWifi(random.nextBoolean());
	}
	
	private void generatePrinter(Printer printer) {
		generateOfficeEq(printer);
	}
	private void generateMFU(MFU mfu) {
		generateOfficeEq(mfu);
		mfu.setCardReader(random.nextBoolean());
		mfu.setLAN(random.nextBoolean());
		mfu.setOpticalResolution(OpticalResolution.values()[random.nextInt(OpticalResolution.values().length)]);
	}
	private void generateMobileDevice(MobileDevice mobileDevice){
		generateProduct(mobileDevice);
		mobileDevice.setBatteryCapacity(random.nextInt(4000));
		mobileDevice.setCameraResolution(random.nextDouble());
		mobileDevice.setDiagonal(random.nextDouble());
		mobileDevice.setGPS(random.nextBoolean());
		mobileDevice.setOs(OS.values()[random.nextInt(OS.values().length)]);
	}
	private void  generateCellPhone(CellPhone cellPhone) {
		generateMobileDevice(cellPhone);
		cellPhone.setBluetooth(random.nextBoolean());
		cellPhone.setColor("green");
		cellPhone.setNumberOfSims(random.nextInt(4));
		cellPhone.setSensor(random.nextBoolean());
		cellPhone.setShellType(ShellType.values()[random.nextInt(ShellType.values().length)]);
		cellPhone.setWifi(random.nextBoolean());
	}
	private void generateTablet(Tablet tablet) {
		generateMobileDevice(tablet);
		tablet.setDisplayResolution(DisplayResolution.values()[random.nextInt(DisplayResolution.values().length)]);
		tablet.setCoreFrequency(random.nextDouble());
		tablet.setProccessorProducer(ProccessorProducer.values()[random.nextInt(ProccessorProducer.values().length)]);
		tablet.setRamVolume(random.nextInt());
		tablet.setHddVolume(random.nextInt(1555));
		tablet.setNumberOfUSB(random.nextInt(5));
		tablet.setHDMI(random.nextBoolean());
	}
}
