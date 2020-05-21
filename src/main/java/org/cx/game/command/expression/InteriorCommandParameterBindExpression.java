package org.cx.game.command.expression;

import java.util.HashMap;
import java.util.Map;

import org.cx.game.command.ICommandBuffer;
import org.cx.game.command.exception.SyntaxValidatorException;
import org.cx.game.core.GameObject;
import org.cx.game.command.validator.*;
import org.dom4j.Element;

public class InteriorCommandParameterBindExpression extends WithCacheCommandParameterExpression {
	
	private InteriorCommandParameterBindExpressionValidator validator = null;

	public InteriorCommandParameterBindExpression(String cmd, Element cmdEl, ICommandBuffer buffer) {
		super(cmd, cmdEl, buffer);
		// TODO Auto-generated constructor stub
		
		this.validator = new InteriorCommandParameterBindExpressionValidator(getParameter(), buffer);
		addValidator(validator);
	}
	
	@Override
	public Object interpreter() throws SyntaxValidatorException {
		// TODO Auto-generated method stub
		super.interpreter();
		
		Map<String, Object> ret = new HashMap<String, Object>();
		String declareName = this.validator.getDeclareName();
		GameObject obj = this.validator.getGameObject();
		
		ret.put("declareName", declareName);
		ret.put("gameObject", obj);
		
		return ret;
	}

}
