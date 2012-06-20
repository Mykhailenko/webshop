package model.product.mobile;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import model.product.AbstractArticul;

public class CellPhoneProxyMap implements InvocationHandler{
	private Map<String, Object> content = new HashMap<String, Object>();
	
	public CellPhoneProxyMap(AbstractArticul articul) {
		super();
		content.put("articul", articul);
	}

	@Override
	public Object invoke(Object paramObject, Method paramMethod,
			Object[] paramArrayOfObject) throws Throwable {
		if(paramArrayOfObject != null && paramArrayOfObject.length != 1){
			throw new IllegalArgumentException("Unexpected array of arguments length: " + paramArrayOfObject.length);
		}
		String methodName = paramMethod.getName();
		String attributeName = null;
		if(methodName.startsWith("set")){
			attributeName = methodName.substring(3).toLowerCase();
			content.put(attributeName, paramArrayOfObject[0]);
			return null;
		}else if(methodName.startsWith("is")){
			attributeName = methodName.substring(2).toLowerCase();
			return content.get(attributeName);
		}else if(methodName.startsWith("get")){
			attributeName = methodName.substring(3).toLowerCase();
			return content.get(attributeName);
		}else{
			throw new UnsupportedOperationException(methodName);
		}
	}

}
