package root.interfaces;

import java.util.List;
import java.util.Map;

import root.exceptions.UnloggedUserException;

import model.product.Product;

public interface Bag {

	Map<Product, Integer> getProductsInBag() throws UnloggedUserException;

	long getCostForWholeBag()throws UnloggedUserException;
	
	boolean clearBag();
	
	boolean putProductInBag(Product p) throws UnloggedUserException;

	List<Product> getLast5Added();
}
