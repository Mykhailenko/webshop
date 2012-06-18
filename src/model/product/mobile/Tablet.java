package model.product.mobile;

import java.text.MessageFormat;

import model.product.AbstractArticul;
import model.product.NamedAttribute;


public class Tablet extends MobileDevice{
	public enum DisplayResolution {
		px320x240, px400x240, px800x480,
		px800x600, px1024x600, px1024x768,
		px1280x800, px2048x1536;
	}
	public  enum ProccessorProducer {
		AMD, Apple, Cortex, Intel, NVIDIA, 
		Qualcomm;
	}
	private DisplayResolution displayResolution;
	private double coreFrequency;
	private ProccessorProducer proccessorProducer;
	private int ramVolume;//in MB
	private int hddVolume;// in MB
	private int numberOfUSB;
	private boolean HDMI;
	public Tablet(AbstractArticul articul){
		super(articul);
	}
	public Tablet(AbstractArticul articul, String title, String producer,
			String description,	long cost, double diagonal, 
			OS os, int batteryCapacity, boolean gPS, 
			double cameraResolution,
			DisplayResolution displayResolution, double coreFrequency,
			ProccessorProducer proccessorProducer, int ramVolume,
			int hddVolume, int numberOfUSB, boolean hDMI) {
		super(articul, title, producer, description, cost, diagonal,
				os, batteryCapacity, gPS, cameraResolution);
		this.displayResolution = displayResolution;
		this.coreFrequency = coreFrequency;
		this.proccessorProducer = proccessorProducer;
		this.ramVolume = ramVolume;
		this.hddVolume = hddVolume;
		this.numberOfUSB = numberOfUSB;
		HDMI = hDMI;
	}
	
	

	@Override
	public String toString() {
		return MessageFormat
				.format("Tablet [displayResolution={0}, coreFrequency={1}, proccessorProducer={2}, ramVolume={3}, hddVolume={4}, numberOfUSB={5}, HDMI={6}, getDiagonal()={7}, getOs()={8}, getBatteryCapacity()={9}, isGPS()={10}, getCameraResolution()={11}, getTitle()={12}, getProducer()={13}, getId()={14}, getDescription()={15}]",
						displayResolution, coreFrequency, proccessorProducer, ramVolume, hddVolume, numberOfUSB,
						HDMI, getDiagonal(), getOs(), getBatteryCapacity(), isGPS(),
						getCameraResolution(), getTitle(), getProducer(), getArticul(), getDescription());
	}


	@NamedAttribute("displayresolution")
	public DisplayResolution getDisplayResolution() {
		return displayResolution;
	}
	
	@NamedAttribute("displayresolution")
	public void setDisplayResolution(DisplayResolution displayResolution) {
		this.displayResolution = displayResolution;
	}
	
	@NamedAttribute("corefrequency")
	public double getCoreFrequency() {
		return coreFrequency;
	}
	
	@NamedAttribute("corefrequency")
	public void setCoreFrequency(double coreFrequency) {
		this.coreFrequency = coreFrequency;
	}
	
	@NamedAttribute("proccessorproducer")
	public ProccessorProducer getProccessorProducer() {
		return proccessorProducer;
	}
	
	@NamedAttribute("proccessorproducer")
	public void setProccessorProducer(ProccessorProducer proccessorProducer) {
		this.proccessorProducer = proccessorProducer;
	}
	
	@NamedAttribute("ramvolume")
	public int getRamVolume() {
		return ramVolume;
	}
	
	@NamedAttribute("ramvolume")
	public void setRamVolume(int ramVolume) {
		this.ramVolume = ramVolume;
	}
	
	@NamedAttribute("hddvolume")
	public int getHddVolume() {
		return hddVolume;
	}
	
	@NamedAttribute("hddvolume")
	public void setHddVolume(int hddVolume) {
		this.hddVolume = hddVolume;
	}
	
	@NamedAttribute("numberofusb")
	public int getNumberOfUSB() {
		return numberOfUSB;
	}
	
	@NamedAttribute("numberofusb")
	public void setNumberOfUSB(int numberOfUSB) {
		this.numberOfUSB = numberOfUSB;
	}
	
	@NamedAttribute("hdmi")
	public boolean isHDMI() {
		return HDMI;
	}
	
	@NamedAttribute("hdmi")
	public void setHDMI(boolean hDMI) {
		HDMI = hDMI;
	}
}
