package org.cx.game.command.validator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.cx.game.builder.tools.I18n;
import org.cx.game.command.CommandBuffer;
import org.cx.game.command.ICommandBuffer;
import org.cx.game.command.expression.Calculator;
import org.cx.game.tools.CommandUtil;
import org.cx.game.tools.CommonIdentifier;
import org.cx.game.validator.Validator;

/**
 * 验证调用命令格式，call + method + arguments
 * @author admin
 *
 */
public class InteriorCommandParameterCallExpressionValidator extends Validator {

	private String parameter = null;
	
	private CommandBuffer buffer = null;
	private String methodName = null;
	private List<Class> paramTypes = null;
	private List<Object> paramObjects = null;
	
	public InteriorCommandParameterCallExpressionValidator(String parameter, ICommandBuffer buffer) {
		// TODO Auto-generated constructor stub
		this.parameter = parameter;
		this.buffer = (CommandBuffer) buffer;
	}
	
	@Override
	public Boolean validate() {
		// TODO Auto-generated method stub
		Object bufferObject = buffer.get();
		List<Method> methodWithSameName = new ArrayList<Method>();
		List<Method> methodOfSameNumberOfParameters = new ArrayList<Method>();
		Method method = null;
		String [] params = parameter.split(Calculator.SPACE);
		this.methodName = params[0];
		this.paramTypes = new ArrayList<Class>();
		this.paramObjects = new ArrayList<Object>();
		
		for(Method m : bufferObject.getClass().getMethods()){
			if(methodName.equals(m.getName())){
				methodWithSameName.add(m);
			}
		}
		
		/*
		 * 判断parameter与缓存对象的方法名称是否匹配
		 */
		if(methodWithSameName.isEmpty()){
			addMessage(I18n.getMessage(CommonIdentifier.ErrorInParameterFormat));
			return false;
		}
		
		/*
		 * 判断参数个数是否匹配，处理重载的情况
		 */
		for(Method m : methodWithSameName){
			if(m.getParameterTypes().length == (params.length-1)){
				methodOfSameNumberOfParameters.add(m);
			}
		}
		
		if(methodOfSameNumberOfParameters.isEmpty()){
			addMessage(I18n.getMessage(CommonIdentifier.ErrorInParameterFormat));
			return false;
		}
		
		/*
		 * 判断是否有参数
		 */
		if(params.length>1){
			for(int i=1;i<params.length;i++){
				
				/*
				 * 处理缓存参数的情况
				 */
				if(0==params[i].indexOf("@")){
					Object param = this.buffer.getParameter(params[i]);
					this.paramTypes.add(param.getClass());
					this.paramObjects.add(param);
				}else{
					this.paramTypes.add(CommandUtil.getParameterType(params[i]));
					this.paramObjects.add(CommandUtil.getParameterObject(params[i], buffer));
				}
			}
			
			/*
			 * 判断参数类型是否匹配
			 */
			for(Method m : methodOfSameNumberOfParameters) {
				Class[] clzs = m.getParameterTypes();
				if(CommandUtil.compareParameterClass(this.paramTypes.toArray(new Class[this.paramTypes.size()]), clzs)){
					method = m;
					break;
				}
			}
			
			if(null == method) {
				addMessage(I18n.getMessage(CommonIdentifier.ErrorInParameterFormat));
				return false;
			}
		}
		
		return true;
	}
	
	public Class[] getParameterTypes() {
		return this.paramTypes.toArray(new Class[this.paramTypes.size()]);
	}
	
	public Object [] getParameterObjects() {
		return this.paramObjects.toArray();
	}
	
	public String getMethodName() {
		return this.methodName;
	}
	
	public static void main(String[] args) {
		String str = "@int";
		System.out.println(str.indexOf("@"));
	}
}
