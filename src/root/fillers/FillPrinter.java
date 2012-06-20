package root.fillers;

import model.product.Product;
import model.product.office.Printer;

public class FillPrinter extends FillDecorator{

	public FillPrinter(FillDecorator decorator) {
		super(decorator);
	}
	public FillPrinter() {
	}
	@Override
	public void fill(Product product) {
		super.fill(product);
	}

}
