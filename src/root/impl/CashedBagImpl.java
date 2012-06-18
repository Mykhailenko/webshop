package root.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import root.interfaces.CashedBag;


import model.product.Product;

class CashedBagImpl implements CashedBag{
	private final CashedProducts products = new CashedProducts();
	
	@Override
	public synchronized List<Product> get() {
		Iterator<Product> it = products.keySet().iterator();
		List<Product> result = new ArrayList<Product>();
		while(it.hasNext()){
			result.add(it.next());
		}
		return Collections.unmodifiableList(result);
	}
	
	@Override
	public synchronized void add(Product product) {
		products.put(product, null);
	}
	
	@Override
	public void clear() {
		products.clear();
	}
}
