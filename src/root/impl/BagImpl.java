package root.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import root.interfaces.Bag;
import root.interfaces.CashedBag;

import model.product.Product;

class BagImpl implements Bag{

	private final Map<Product, Integer> content = new HashMap<Product, Integer>();
	private final CashedBag lastAdded = new CashedBagImpl();
	@Override
	public synchronized Map<Product, Integer> getProductsInBag(){
		return new HashMap<Product, Integer>(content);
	}

	@Override
	public synchronized long getCostForWholeBag() {
		long cost = 0;
		Iterator<Map.Entry<Product, Integer>> it = content.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Product, Integer> entry = it.next();
			cost += entry.getKey().getCost() * entry.getValue();
		}
		return cost;
	}

	@Override
	public synchronized boolean clearBag() {
		int sizeBefore = content.size();
		content.clear();
		lastAdded.clear();
		return content.size() != sizeBefore;
	}

	@Override
	public synchronized boolean putProductInBag(Product p)  {
		Integer count = content.get(p);
		if(count == null){
			content.put(p, 1);
		}else{
			content.put(p, count + 1);
		}
		lastAdded.add(p);
		return true;
	}

	@Override
	public synchronized List<Product> getLast5Added() {
		return lastAdded.get();
	}

}
