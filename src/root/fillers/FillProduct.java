package root.fillers;

import model.product.Product;

public class FillProduct extends FillDecorator {

	public FillProduct(FillDecorator decorator) {
		super(decorator);
	}

	public FillProduct() {
	}

	@Override
	public void fill(Product product) {
		super.fill(product);
		product.setCost(getInt("cost"));
		product.setDescription(getString("description"));
		product.setProducer(getString("producer"));
		product.setTitle(getString("title"));
	}

}
