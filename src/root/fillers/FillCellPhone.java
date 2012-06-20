package root.fillers;

import model.product.Product;
import model.product.mobile.CellPhone;
import model.product.mobile.CellPhone.ShellType;
import model.product.mobile.CellProneInterface;

public class FillCellPhone extends FillDecorator{

	public FillCellPhone(FillDecorator decorator) {
		super(decorator);
	}
	public FillCellPhone() {
	}
	@Override
	public void fill(Product product) {
		super.fill(product);
		if(product instanceof CellPhone){
			CellProneInterface cellPhone = (CellProneInterface) product;
			cellPhone.setBluetooth(getBoolean("bluetooth"));
			cellPhone.setColor(getString("color"));
			cellPhone.setNumberOfSims(getInt("number of sims"));
			cellPhone.setSensor(getBoolean("sensor"));
			cellPhone.setShellType(getEnum("shell type", ShellType.values()));
			cellPhone.setWifi(getBoolean("wifi"));
		}
	}

}
