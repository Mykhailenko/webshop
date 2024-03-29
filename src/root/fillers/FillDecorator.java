package root.fillers;

import java.util.Scanner;

import root.ConsoleShop;
import model.product.Product;

public abstract class FillDecorator {
	private static final Scanner in = new Scanner(System.in); 
	protected FillDecorator decorator;
	
	protected FillDecorator(FillDecorator decorator) {
		super();
		this.decorator = decorator;
	}
	protected FillDecorator() {
	}

	public void fill(Product product){
		if(decorator != null){
			decorator.fill(product);
		}
	}
	
	
	
	public void print(String s){
		System.out.println(s);
	}
	protected String getString(String fieldName){
		print(ConsoleShop.getRes().getString("put_string") + ConsoleShop.getRes().getString(fieldName));
//		print("put string for " + fieldName + ":");
		return in.next();
	}
	protected int getInt(String fieldName){
		print(ConsoleShop.getRes().getString("put_int") + ConsoleShop.getRes().getString(fieldName));
//		print("put int for " + fieldName + ":");
		return in.nextInt();
	}
	protected float getFloat(String fieldName){
		print(ConsoleShop.getRes().getString("put_double") + ConsoleShop.getRes().getString(fieldName));
//		print("put double for " + fieldName + ":");
		return in.nextFloat();
	}
	protected boolean getBoolean(String fieldName){
		print(ConsoleShop.getRes().getString("put_bool") + " '"+ConsoleShop.getRes().getString("put_bool1")+ "' " + ConsoleShop.getRes().getString("put_bool2")+ ' '+  ConsoleShop.getRes().getString(fieldName));
//		print("put boolean for " + fieldName + " (t/y):");
		String s = in.next();
		return s.equals("t");
	}
	protected <T> T getEnum(String fieldName, T [] enums){
		print(ConsoleShop.getRes().getString("put_enum") + ConsoleShop.getRes().getString(fieldName) + ' ' + ConsoleShop.getRes().getString("put_enum1"));
//		print("put index of " + fieldName + ":");
		for(int i = 0; i < enums.length; ++i){
			print(i + " - " + enums[i]);
		}
		int index = in.nextInt();
		if(0 <= index && index < enums.length){
			return enums[index];
		}else{
			return enums[0];
		}
	}
}
