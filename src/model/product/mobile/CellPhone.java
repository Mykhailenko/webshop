package model.product.mobile;

import java.awt.Color;
import java.text.MessageFormat;

import model.product.AbstractArticul;
import model.product.NamedAttribute;


public class CellPhone extends MobileDevice implements CellProneInterface {
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

	

	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#toString()
	 */
	@Override
	public String toString() {
		return MessageFormat
				.format("CellPhoN [shellType={0}, sensor={1}, numberOfSims={2}, bluetooth={3}, wifi={4}, color={5}, getDiagonal()={6}, getOs()={7}, getBatteryCapacity()={8}, isGPS()={9}, getTitle()={10}, getProducer()={11}, getId()={12}, getDescription()={13}]",
						shellType, sensor, numberOfSims, bluetooth, wifi, color,
						getDiagonal(), getOs(), getBatteryCapacity(), isGPS(), getTitle(),
						getProducer(), getArticul(), getDescription());
	}

	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#getShellType()
	 */
	@Override
	@NamedAttribute("shelltype")
	public ShellType getShellType() {
		return shellType;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#setShellType(model.product.mobile.CellPhone.ShellType)
	 */
	@Override
	@NamedAttribute("shelltype")
	public void setShellType(ShellType shellType) {
		this.shellType = shellType;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#isSensor()
	 */
	@Override
	@NamedAttribute("sensor")
	public boolean isSensor() {
		return sensor;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#setSensor(boolean)
	 */
	@Override
	@NamedAttribute("sensor")
	public void setSensor(boolean sensor) {
		this.sensor = sensor;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#getNumberOfSims()
	 */
	@Override
	@NamedAttribute("numberofsims")
	public int getNumberOfSims() {
		return numberOfSims;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#setNumberOfSims(int)
	 */
	@Override
	@NamedAttribute("numberofsims")
	public void setNumberOfSims(int numberOfSims) {
		this.numberOfSims = numberOfSims;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#isBluetooth()
	 */
	@Override
	@NamedAttribute("bluetooth")
	public boolean isBluetooth() {
		return bluetooth;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#setBluetooth(boolean)
	 */
	@Override
	@NamedAttribute("bluetooth")
	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#isWifi()
	 */
	@Override
	@NamedAttribute("wifi")
	public boolean isWifi() {
		return wifi;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#setWifi(boolean)
	 */
	@Override
	@NamedAttribute("wifi")
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#getColor()
	 */
	@Override
	@NamedAttribute("color")
	public String getColor() {
		return color;
	}
	
	/* (non-Javadoc)
	 * @see model.product.mobile.CellProneInterface#setColor(java.lang.String)
	 */
	@Override
	@NamedAttribute("color")
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
