package root.fillers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.apache.log4j.Logger;

import root.ConsoleShop;
import root.interfaces.FillProducts;
import root.interfaces.Shop;

import model.User;
import model.product.Articul1;
import model.product.NamedAttribute;
import model.product.Product;
import model.product.mobile.CellPhone;
import model.product.mobile.Tablet;
import model.product.office.MFU;
import model.product.office.Printer;

public class HandFillProductsReflection implements FillProducts {
	private static final Logger LOGGER = Logger.getRootLogger();
	private Scanner in;
	private User user;
	private Shop facade;
	public HandFillProductsReflection(User user, Shop facade) {
		this.user = user;
		this.facade = facade;
		this.in = new Scanner(System.in);
	}
	@Override
	public void fill() {
		print(ConsoleShop.getRes().getString("fill_start") + COUNT + " " + ConsoleShop.getRes().getString("fill_start1"));
		Product product;
		for(int i = 0; i < COUNT; ++i){
			question();
			int nextInt = in.nextInt();
			switch (nextInt) {
			case 0:
				product = new Printer(new Articul1(getArticle()));
				fillProduct(product);
				facade.addProduct(user, product);
				break;
			case 1:
				product = new MFU(new Articul1(getArticle()));
				fillProduct(product);
				facade.addProduct(user, product);
				break;
			case 2:
				product = new CellPhone(new Articul1(getArticle()));
				fillProduct(product);
				facade.addProduct(user, product);
				break;
			case 3:
				product = new Tablet(new Articul1(getArticle()));
				fillProduct(product);
				facade.addProduct(user, product);
				break;
			default:
				--i;
				break;
			}
		}
	}
	
	private void question(){
		print(ConsoleShop.getRes().getString("fill_questn"));
	}
	private String getArticle(){
		print(ConsoleShop.getRes().getString("put_article"));
		return in.next();
	}
	@SuppressWarnings("rawtypes")
	private void fillProduct(Product product){
		Method [] methods = product.getClass().getMethods();
		for(Method method : methods){
			if(method.getName().startsWith("set")){
				if(method.getDeclaredAnnotations() == null ||
						method.getDeclaredAnnotations().length == 0){
					continue;
				}
				Class[] paramsTypes = method.getParameterTypes();
				if(paramsTypes.length == 1){
					Class paramType = paramsTypes[0];
					if(paramType == String.class){
						fillString(product, method);
					}else if(paramType == Boolean.class ||
							paramType == boolean.class){
						fillBoolean(product, method);
					}else if(paramType == Integer.class ||
							paramType == int.class){
						fillInteger(product, method);
					}else if(paramType == Long.class ||
							paramType == long.class){
						fillLong(product, method);
					}else if(paramType == Double.class ||
							paramType == double.class){
						fillDouble(product, method);
					}else if(paramType == Float.class ||
							paramType == float.class){
						fillFloat(product, method);
					}else if(paramType.isEnum()){
						fillEnum(product, method);
					}
				}
			}
		}
	}
	private void fillLong(Product product, Method method) {
		print(ConsoleShop.getRes().getString("put_long") + clearSET(method));
		long x = in.nextLong();
		try {
			method.invoke(product, x);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
	private void fillEnum(Product product, Method method) {
		print(ConsoleShop.getRes().getString("put_enum") + clearSET(method) + ' ' + ConsoleShop.getRes().getString("put_enum1"));
		Object [] enums = method.getParameterTypes()[0].getEnumConstants();
		for(int i = 0; i < enums.length; ++i){
			Object en = enums[i];
			print(i + " - " + en);
		}
		int index = in.nextInt();
		if(0 <= index && index < enums.length){
			try {
				method.invoke(product, enums[index]);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
	}
	private void fillFloat(Product product, Method method) {
		print(ConsoleShop.getRes().getString("put_float") + clearSET(method));
		float x = in.nextFloat();
		try {
			method.invoke(product, x);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
	private void fillDouble(Product product, Method method) {
		print(ConsoleShop.getRes().getString("put_double") + clearSET(method));
		double x = in.nextDouble();
		try {
			method.invoke(product, x);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
	private void fillInteger(Product product, Method method) {
		print(ConsoleShop.getRes().getString("put_int") + clearSET(method));
		int x = in.nextInt();
		try {
			method.invoke(product, x);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	private void fillBoolean(Product product, Method method) {
		print(ConsoleShop.getRes().getString("put_bool") + " '"+ConsoleShop.getRes().getString("put_bool1")+ "' " + ConsoleShop.getRes().getString("put_bool2")+ ' '+  clearSET(method));
		String s = in.next();
		try {
			method.invoke(product, s.equals(ConsoleShop.getRes().getString("put_bool1")));
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	private void fillString(Product product, Method method) {
		print(ConsoleShop.getRes().getString("put_string") + clearSET(method));
		String s = in.next();
		try {
			method.invoke(product, s);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
	private String clearSET(Method method){
		Annotation[] as = method.getDeclaredAnnotations();
		if(as != null && as.length > 0){
			NamedAttribute namedAttribute = method.getAnnotation(NamedAttribute.class);
//			NamedAttribute namedAttribute = (NamedAttribute) as[0];
			String s = ConsoleShop.getRes().getString(namedAttribute.value());
			if(s != null){
				return s;
			}
		}else{
			assert true != false;
		}
		return method.getName().substring(3).toLowerCase();
	}
	private static void print(String s){
		System.out.println(s);
	}
}
