package model.product.mobile;

import java.text.MessageFormat;

import model.product.AbstractArticul;
import model.product.NamedAttribute;
import model.product.Product;

public class MobileDevice extends Product{
	public enum OS {
		Android, iOS, Windows_7, Tablet_OS, Bada, MeeGo, Symbian; 
	}
	private double diagonal;
	private OS os;
	private int batteryCapacity;
	private boolean GPS;
	private double cameraResolution;
	public MobileDevice(AbstractArticul articul){
		super(articul);
	}
	public MobileDevice(AbstractArticul articul, String title, String producer,
			String description,	long cost, double diagonal, 
			OS os, int batteryCapacity, boolean gPS, 
			double cameraResolution) {
		super(articul, title, producer, description, cost);
		this.diagonal = diagonal;
		this.os = os;
		this.batteryCapacity = batteryCapacity;
		this.setCameraResolution(cameraResolution);
		GPS = gPS;
	}

	@Override
	public String toString() {
		return MessageFormat
				.format("MobileDevice [diagonal={0}, os={1}, batteryCapacity={2}, GPS={3}, getTitle()={4}, getProducer()={5}, getId()={6}, getDescription()={7}]",
						diagonal, os, batteryCapacity, GPS, getTitle(),
						getProducer(), getArticul(), getDescription());
	}

	@NamedAttribute("diagonal")
	public double getDiagonal() {
		return diagonal;
	}
	
	@NamedAttribute("diagonal")
	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}
	
	@NamedAttribute("os")
	public OS getOs() {
		return os;
	}
	
	@NamedAttribute("os")
	public void setOs(OS os) {
		this.os = os;
	}
	
	@NamedAttribute("batterycapacity")
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	@NamedAttribute("batterycapacity")
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	@NamedAttribute("gps")
	public boolean isGPS() {
		return GPS;
	}
	
	@NamedAttribute("gps")
	public void setGPS(boolean gPS) {
		GPS = gPS;
	}

	@NamedAttribute("cameraresolution")
	public double getCameraResolution() {
		return cameraResolution;
	}

	@NamedAttribute("cameraresolution")
	public void setCameraResolution(double cameraResolution) {
		this.cameraResolution = cameraResolution;
	}
	
}
