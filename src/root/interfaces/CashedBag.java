package root.interfaces;

import java.util.List;

import model.product.Product;

public interface CashedBag {
	List<Product> get();
	void add(Product product);
	void clear();
}
