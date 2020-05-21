package org.cx.game.command.expression;

import java.util.HashMap;
import java.util.Map;

import org.cx.game.command.ICommandBuffer;
import org.cx.game.command.exception.SyntaxValidatorException;
import org.cx.game.command.validator.*;
import org.dom4j.Element;

public class InteriorCommandParameterCallParamsExpression extends WithCacheCommandParameterExpression {

	private InteriorCommandParameterCallParamsExpressionValidator validator = null;
	
	public InteriorCommandParameterCallParamsExpression(String cmd, Element cmdEl, ICommandBuffer buffer) {
		super(cmd, cmdEl, buffer);
		// TODO Auto-generated constructor stub
		this.validator = new InteriorCommandParameterCallParamsExpressionValidator(getParameter(), buffer);
		addValidator(this.validator);
	}
	
	@Override
	public Object interpreter() throws SyntaxValidatorException {
		// TODO Auto-generated method stub
		super.interpreter();
		
		Map<String, Object> ret = new HashMap<String, Object>();

		String methodName = this.validator.getMethodName();
		Class [] clazs = this.validator.getParameterTypes();
		Object [] params = this.validator.getParameterObjects();
		
		ret.put("methodName", methodName);
		ret.put("parameterTypes", clazs);
		ret.put("parameterObjects", params);
		
		return ret;
	}

}
