package model.product;

public class Articul0 extends AbstractArticul {

	public Articul0(String articul) {
		super(articul);
	}

	@Override
	protected int calculateHashCode() {
		return articul.length();
	}

}
