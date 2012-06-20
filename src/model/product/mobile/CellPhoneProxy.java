package model.product.mobile;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CellPhoneProxy implements InvocationHandler{
	private final CellPhone cellPhone;
	
	public CellPhoneProxy(CellPhone cellPhone) {
		super();
		this.cellPhone = cellPhone;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(method.getName().startsWith("set")){
			throw new UnsupportedOperationException();
		}else{
			return method.invoke(cellPhone, args);
		}
	}

}
