package root.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Random;

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

public class GenerateProducts2 implements FillProducts{
	private static final Logger LOGGER = Logger.getRootLogger();
	private Random random = new Random(Calendar.getInstance().getTimeInMillis());
	private Shop facade;
	private User user;
	public GenerateProducts2(User user, Shop facade) {
		super();
		this.facade = facade;
		this.user = user;
	}
	@SuppressWarnings("rawtypes")
	private void fillProduct(Product product){
		Method [] methods = product.getClass().getMethods();
		for(Method method : methods){
			if(method.getName().startsWith("set")){
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
	
	private void fillString(Product product, Method method) {
		Annotation[] as = method.getDeclaredAnnotations();
		NamedAttribute namedAttribute = (NamedAttribute) as[0];
		String goodString = ConsoleShop.getRes().getString(namedAttribute.value());
		goodString += random.nextInt();
		setValueToMethod(product, method, goodString);
	}
	private void fillEnum(Product product, Method method) {
		Object [] enums = method.getParameterTypes()[0].getEnumConstants();
		setValueToMethod(product, method, enums[random.nextInt(enums.length)]);
	}
	private void fillFloat(Product product, Method method) {
		setValueToMethod(product, method, random.nextFloat());
	}
	private void fillDouble(Product product, Method method) {
		setValueToMethod(product, method, random.nextDouble());
	}
	private void fillLong(Product product, Method method) {
		setValueToMethod(product, method, random.nextLong());
	}
	private void fillInteger(Product product, Method method) {
		setValueToMethod(product, method, random.nextInt());
	}
	private void fillBoolean(Product product, Method method) {
		setValueToMethod(product, method, random.nextBoolean());
	}
	
	private void setValueToMethod(Object obj, Method method, Object arg){
		try {
			method.invoke(obj, arg);
		} catch (Exception e) { 
			LOGGER.error(e);
		}
	}
	@Override
	public void fill() {
		LOGGER.info("FILL");
		Product p = null;
		for(int i = 0; i < COUNT; ++i){
			LOGGER.info(i + " : " + COUNT);
			int nextInt = random.nextInt(4);
			switch (nextInt) {
			case 0:
				p = new Printer(new Articul1("printer-articul"+random.nextInt()));
				break;
			case 1:
				p = new MFU(new Articul1("mfu-article"+ random.nextInt()));
				break;
			case 2:
				p = new CellPhone(new Articul1("cellPhone-articul"+random.nextInt()));
				break;
			case 3:
			default:
				p = new Tablet(new Articul1("tablet-articul"+random.nextInt()));
				break;
			}
			fillProduct(p);
			facade.addProduct(user, p);
		}
	}
}
