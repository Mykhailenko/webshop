package model.product.mobile;

import model.product.AbstractArticul;
import model.product.NamedAttribute;
import model.product.mobile.CellPhone.ShellType;
import model.product.mobile.MobileDevice.OS;

public interface CellProneInterface {

	@NamedAttribute("diagonal")
	public double getDiagonal() ;
	
	@NamedAttribute("diagonal")
	public void setDiagonal(double diagonal) ;
	
	@NamedAttribute("os")
	public OS getOs() ;
	
	@NamedAttribute("os")
	public void setOs(OS os) ;
	
	@NamedAttribute("batterycapacity")
	public int getBatteryCapacity() ;
	
	@NamedAttribute("batterycapacity")
	public void setBatteryCapacity(int batteryCapacity);
	
	@NamedAttribute("gps")
	public boolean isGPS() ;
	
	@NamedAttribute("gps")
	public void setGPS(boolean gPS) ;

	@NamedAttribute("cameraresolution")
	public double getCameraResolution() ;

	@NamedAttribute("cameraresolution")
	public void setCameraResolution(double cameraResolution) ;
	
	@NamedAttribute("shelltype")
	public ShellType getShellType();

	@NamedAttribute("shelltype")
	public void setShellType(ShellType shellType);

	@NamedAttribute("title")
	public String getTitle();

	@NamedAttribute("title")
	public void setTitle(String title);
	
	@NamedAttribute("producer")
	public String getProducer();

	@NamedAttribute("producer")
	public void setProducer(String producer) ;
	
	public AbstractArticul getArticul() ;

	@NamedAttribute("description")
	public String getDescription() ;

	@NamedAttribute("description")
	public void setDescription(String description) ;
	
	@NamedAttribute("cost")
	public long getCost() ;
	
	@NamedAttribute("cost")
	public void setCost(long cost) ;
	
	@NamedAttribute("sensor")
	public  boolean isSensor();

	@NamedAttribute("sensor")
	public  void setSensor(boolean sensor);

	@NamedAttribute("numberofsims")
	public  int getNumberOfSims();

	@NamedAttribute("numberofsims")
	public  void setNumberOfSims(int numberOfSims);

	@NamedAttribute("bluetooth")
	public  boolean isBluetooth();

	@NamedAttribute("bluetooth")
	public  void setBluetooth(boolean bluetooth);

	@NamedAttribute("wifi")
	public  boolean isWifi();

	@NamedAttribute("wifi")
	public  void setWifi(boolean wifi);

	@NamedAttribute("color")
	public  String getColor();

	@NamedAttribute("color")
	public  void setColor(String color);

}