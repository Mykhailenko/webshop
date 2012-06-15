package model.product.mobile;

import java.awt.Color;
import java.text.MessageFormat;

import model.product.AbstractArticul;


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

	public ShellType getShellType() {
		return shellType;
	}
	public void setShellType(ShellType shellType) {
		this.shellType = shellType;
	}
	public boolean isSensor() {
		return sensor;
	}
	public void setSensor(boolean sensor) {
		this.sensor = sensor;
	}
	public int getNumberOfSims() {
		return numberOfSims;
	}
	public void setNumberOfSims(int numberOfSims) {
		this.numberOfSims = numberOfSims;
	}
	public boolean isBluetooth() {
		return bluetooth;
	}
	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
