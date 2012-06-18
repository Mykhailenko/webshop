package model.product.mobile;

import java.awt.Color;
import java.text.MessageFormat;

import model.product.AbstractArticul;
import model.product.NamedAttribute;


public class CellPhone extends MobileDevice {
	public enum ShellType {
		MONOBLOCK, FOLDING, SLIDER;
	}
	
	private ShellType shellType;
	private boolean sensor;
	private int numberOfSims;
	private boolean bluetooth;
	private boolean wifi;
	private String color;
	public CellPhone(AbstractArticul articul){
		super(articul);
	}
	public CellPhone(AbstractArticul articul, String title, String producer, String description,long cost, 
			double diagonal, OS os, int batteryCapacity, boolean gPS,
			double cameraResolution,ShellType shellType, boolean sensor, int numberOfSims,
			 boolean bluetooth, boolean wifi,	String color) {
		super(articul, title, producer, description, cost, diagonal, os, batteryCapacity, gPS, cameraResolution);
		this.shellType = shellType;
		this.sensor = sensor;
		this.numberOfSims = numberOfSims;
		this.bluetooth = bluetooth;
		this.wifi = wifi;
		this.color = color;
	}

	

	@Override
	public String toString() {
		return MessageFormat
				.format("CellPhoN [shellType={0}, sensor={1}, numberOfSims={2}, bluetooth={3}, wifi={4}, color={5}, getDiagonal()={6}, getOs()={7}, getBatteryCapacity()={8}, isGPS()={9}, getTitle()={10}, getProducer()={11}, getId()={12}, getDescription()={13}]",
						shellType, sensor, numberOfSims, bluetooth, wifi, color,
						getDiagonal(), getOs(), getBatteryCapacity(), isGPS(), getTitle(),
						getProducer(), getArticul(), getDescription());
	}

	@NamedAttribute("shelltype")
	public ShellType getShellType() {
		return shellType;
	}
	
	@NamedAttribute("shelltype")
	public void setShellType(ShellType shellType) {
		this.shellType = shellType;
	}
	
	@NamedAttribute("sensor")
	public boolean isSensor() {
		return sensor;
	}
	
	@NamedAttribute("sensor")
	public void setSensor(boolean sensor) {
		this.sensor = sensor;
	}
	
	@NamedAttribute("numberofsims")
	public int getNumberOfSims() {
		return numberOfSims;
	}
	
	@NamedAttribute("numberofsims")
	public void setNumberOfSims(int numberOfSims) {
		this.numberOfSims = numberOfSims;
	}
	
	@NamedAttribute("bluetooth")
	public boolean isBluetooth() {
		return bluetooth;
	}
	
	@NamedAttribute("bluetooth")
	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}
	
	@NamedAttribute("wifi")
	public boolean isWifi() {
		return wifi;
	}
	
	@NamedAttribute("wifi")
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	
	@NamedAttribute("color")
	public String getColor() {
		return color;
	}
	
	@NamedAttribute("color")
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
