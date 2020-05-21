package org.cx.game.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.cx.game.command.exception.ExecuteValidatorException;
import org.cx.game.observer.Result;
import org.cx.game.tools.CommonIdentifier;

public class GetCommand extends WithCacheCommand {

	public GetCommand(ICommandBuffer buffer) {
		super(buffer);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object execute() throws ExecuteValidatorException {
		// TODO Auto-generated method stub
		super.execute();
		
		Map<String, Object> param = (Map<String, Object>) parameter;
		Boolean isParamFormCache = (Boolean) param.get("isParamFormCache");
		if(isParamFormCache) return param.get("cacheObject");
		
		Object obj = buffer.get(); 
		
		String methodName = param.get("methodName").toString();
		Class [] clzs = (Class[]) param.get("parameterTypes");
		Object [] params = (Object[]) param.get("parameterObjects");
		
		try {
			Method method = obj.getClass().getMethod(methodName, clzs);
			return method.invoke(obj, params);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
