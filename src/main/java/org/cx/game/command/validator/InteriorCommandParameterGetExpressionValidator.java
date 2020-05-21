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
import org.cx.game.tools.Util;
import org.cx.game.validator.Validator;

public class InteriorCommandParameterGetExpressionValidator extends Validator {

	private String parameter = null;
	private Boolean paramFormCache = false;
	
	private CommandBuffer buffer = null;
	private String methodName = null;
	private List<Class> paramTypes = null;
	private List<Object> paramObjects = null;
	
	public InteriorCommandParameterGetExpressionValidator(String parameter, ICommandBuffer buffer) {
		// TODO Auto-generated constructor stub
		this.parameter = parameter;
		this.buffer = (CommandBuffer) buffer;
	}
	
	@Override
	public Boolean validate() {
		// TODO Auto-generated method stub
		/*
		 * 判断是否直接从缓存中获取
		 */
		if(-1!=parameter.indexOf("@")) {
			this.paramFormCache = true;
			if(null==buffer.getParameter(parameter)) {
				addMessage(I18n.getMessage(CommonIdentifier.ObjectsNotSpecifiedInTheCache));
				return false;
			}else {
				return true;
			}
		}
		
		Object obj = buffer.get();
		List<Method> methodWithSameName = new ArrayList<Method>();
		List<Method> methodOfSameNumberOfParameters = new ArrayList<Method>();
		Method method = null;
		String [] params = parameter.split(Calculator.SPACE);
		
		this.methodName = "get"+Util.toUpperCaseFirstOne(params[0]);
		this.paramTypes = new ArrayList<Class>();
		this.paramObjects = new ArrayList<Object>();
		
		for(Method m : obj.getClass().getMethods()){
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
		 * 判断参数个数是否匹配
		 */
		for(Method m : methodWithSameName){
			if((m.getParameterTypes().length+1) == params.length){
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
					this.paramObjects.add(CommandUtil.getParameterObject(params[i]));
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
	
	public Boolean isParamFormCache() {
		return paramFormCache;
	}
}
