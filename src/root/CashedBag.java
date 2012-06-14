package root;
import java.util.LinkedHashMap;

import model.product.Product;


public class CashedBag extends LinkedHashMap<Product, Object>{
	private static final long serialVersionUID = 956200199818650734L;
	private static final int CASH_SIZE = 5;
	
	@Override
	protected boolean removeEldestEntry(
			java.util.Map.Entry<Product, Object> paramEntry) {
		return size() > CASH_SIZE;
	}
}
