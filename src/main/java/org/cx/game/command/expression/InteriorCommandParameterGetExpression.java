package org.cx.game.command.expression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cx.game.command.CommandBuffer;
import org.cx.game.command.ICommandBuffer;
import org.cx.game.command.exception.SyntaxValidatorException;
import org.cx.game.tools.Util;
import org.cx.game.command.validator.*;
import org.dom4j.Element;

public class InteriorCommandParameterGetExpression extends WithCacheCommandParameterExpression {
	
	private InteriorCommandParameterGetExpressionValidator validator = null;
	
	public InteriorCommandParameterGetExpression(String cmd, Element cmdEl,
			ICommandBuffer buffer) {
		super(cmd, cmdEl, buffer);
		// TODO Auto-generated constructor stub
		this.validator = new InteriorCommandParameterGetExpressionValidator(getParameter(), buffer);
		addValidator(this.validator);
	}
	
	@Override
	public Object interpreter() throws SyntaxValidatorException {
		// TODO Auto-generated method stub
		super.interpreter();
		
		Map<String, Object> ret = new HashMap<String, Object>();
		Boolean isParamFormCache = this.validator.isParamFormCache();
		ret.put("isParamFormCache", isParamFormCache);
		
		if(isParamFormCache) {
			ret.put("cacheObject", getBuffer().getParameter(getParameter()));
			return ret;
		}

		String methodName = this.validator.getMethodName();
		Class [] clazs = this.validator.getParameterTypes();
		Object [] params = this.validator.getParameterObjects();
		
		ret.put("methodName", methodName);
		ret.put("parameterTypes", clazs);
		ret.put("parameterObjects", params);
		
		return ret;
	}
	
	

}
