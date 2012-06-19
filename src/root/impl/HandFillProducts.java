package root.impl;

import java.awt.DisplayMode;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

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

import org.apache.log4j.Logger;

import root.ConsoleShop;
import root.interfaces.FillProducts;
import root.interfaces.Shop;

public class HandFillProducts implements FillProducts {
	private static final Logger LOGGER = Logger.getRootLogger();
	private Random random = new Random(Calendar.getInstance().getTimeInMillis());
	private Shop facade;
	private User user;
	private Scanner in;
	public HandFillProducts(User user, Shop facade) {
		super();
		this.facade = facade;
		this.user = user;
		in = new Scanner(System.in);
	}
	@Override
	public void fill() {
		print(ConsoleShop.getRes().getString("fill_start") + COUNT + " " + ConsoleShop.getRes().getString("fill_start1"));
		Printer printer;
		MFU mfu;
		CellPhone cellPhone;
		Tablet tablet;
		for(int i = 0; i < COUNT; ++i){
			question();
			int nextInt = in.nextInt();
			switch (nextInt) {
			case 0:
				printer = new Printer(new Articul1(getArticle()));
				fillPrinter(printer);
				facade.addProduct(user, printer);
				break;
			case 1:
				mfu = new MFU(new Articul1(getArticle()));
				fillMFU(mfu);
				facade.addProduct(user, mfu);
				break;
			case 2:
				cellPhone = new CellPhone(new Articul1(getArticle()));
				fillCellPhone(cellPhone);
				facade.addProduct(user, cellPhone);
				break;
			case 3:
				tablet = new Tablet(new Articul1(getArticle()));
				fillTablet(tablet);
				facade.addProduct(user, tablet);
				break;
			default:
				--i;
				break;
			}
		}
	}
	private void question(){
		print(ConsoleShop.getRes().getString("fill_questn"));
	}
	private String getArticle(){
		print(ConsoleShop.getRes().getString("put_article"));
		return in.next();
	}
	public void print(String s){
		System.out.println(s);
	}
	private void fillProduct(Product product){
		product.setCost(getInt("cost"));
		product.setDescription(getString("description"));
		product.setProducer(getString("producer"));
		product.setTitle(getString("title"));
	}
	private void fillOfficeEq(OfficeEquipment officeEquipment){
		fillProduct(officeEquipment);
		officeEquipment.setColorPrinting(getBoolean("color printing"));
		officeEquipment.setFormat(getEnum("format", Format.values()));
		officeEquipment.setPrintingTechnology(getEnum("printing technology", PrintingTechnology.values()));
		officeEquipment.setUsb2_0(getBoolean("usb"));
		officeEquipment.setWifi(getBoolean("wifi"));
	}
	
	private void fillPrinter(Printer printer) {
		fillOfficeEq(printer);
	}
	private void fillMFU(MFU mfu) {
		fillOfficeEq(mfu);
		mfu.setCardReader(getBoolean("card reader"));
		mfu.setLAN(getBoolean("LAN"));
		mfu.setOpticalResolution(getEnum("optical resolution", OpticalResolution.values()));
	}
	private void fillMobileDevice(MobileDevice mobileDevice){
		fillProduct(mobileDevice);
		mobileDevice.setBatteryCapacity(getInt("battery capacity"));
		mobileDevice.setCameraResolution(getFloat("camera resolution"));
		mobileDevice.setDiagonal(getFloat("diagonal"));
		mobileDevice.setGPS(getBoolean("GPS"));
		mobileDevice.setOs(getEnum("OS", OS.values()));
	}
	private void  fillCellPhone(CellPhone cellPhone) {
		fillMobileDevice(cellPhone);
		cellPhone.setBluetooth(getBoolean("bluetooth"));
		cellPhone.setColor(getString("color"));
		cellPhone.setNumberOfSims(getInt("number of sims"));
		cellPhone.setSensor(getBoolean("sensor"));
		cellPhone.setShellType(getEnum("shell type", ShellType.values()));
		cellPhone.setWifi(getBoolean("wifi"));
	}
	private void fillTablet(Tablet tablet) {
		fillMobileDevice(tablet);
		tablet.setDisplayResolution(getEnum("display resolution", DisplayResolution.values()));
		tablet.setCoreFrequency(getFloat("core frequency"));
		tablet.setProccessorProducer(getEnum("processor producer", ProccessorProducer.values()));
		tablet.setRamVolume(getInt("ram"));
		tablet.setHddVolume(getInt("hdd"));
		tablet.setNumberOfUSB(getInt("number of usbs"));
		tablet.setHDMI(getBoolean("HDMI"));
	}
	private String getString(String fieldName){
		print("put string for " + fieldName + ":");
		return in.next();
	}
	private int getInt(String fieldName){
		print("put int for " + fieldName + ":");
		return in.nextInt();
	}
	private float getFloat(String fieldName){
		print("put double for " + fieldName + ":");
		return in.nextFloat();
	}
	private boolean getBoolean(String fieldName){
		print("put boolean for " + fieldName + " (t/y):");
		String s = in.next();
		return s.equals("t");
	}
	private <T> T getEnum(String fieldName, T [] enums){
		print("put index of " + fieldName + ":");
		for(int i = 0; i < enums.length; ++i){
			print(i + " - " + enums[i]);
		}
		int index = in.nextInt();
		if(0 <= index && index < enums.length){
			return enums[index];
		}else{
			return enums[0];
		}
	}
}
