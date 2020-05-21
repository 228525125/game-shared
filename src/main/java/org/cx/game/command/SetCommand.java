package org.cx.game.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.cx.game.command.exception.ExecuteValidatorException;

public class SetCommand extends WithCacheCommand {
	
	public SetCommand(ICommandBuffer buffer) {
		super(buffer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object execute() throws ExecuteValidatorException {
		// TODO Auto-generated method stub
		Object ret = super.execute();
		
		Object obj = buffer.get();
		Map<String, Object> param = (Map<String, Object>) parameter;
		String declareName = param.get("declareName").toString();
		String methodName = param.get("methodName").toString();
		Class [] clzs = (Class[]) param.get("parameterTypes");
		Object [] params = (Object[]) param.get("parameterObjects");
		
		try {
			Method method = obj.getClass().getMethod(methodName, clzs);
			Object result = method.invoke(obj, params);
			buffer.setParameter(declareName, result);
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
		
		return ret;
	}

}
