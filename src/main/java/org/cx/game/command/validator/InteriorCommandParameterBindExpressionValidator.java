package org.cx.game.command.validator;

import org.cx.game.builder.tools.I18n;
import org.cx.game.command.CommandBuffer;
import org.cx.game.command.ICommandBuffer;
import org.cx.game.command.bind.BinderHelper;
import org.cx.game.command.bind.Identification;
import org.cx.game.command.expression.Calculator;
import org.cx.game.core.GameObject;
import org.cx.game.tools.CommonIdentifier;
import org.cx.game.tools.Jackson;
import org.cx.game.tools.SpringUtils;
import org.cx.game.validator.Validator;

public class InteriorCommandParameterBindExpressionValidator extends Validator {

	private String parameter = null;
	private String declareName = null;
	
	private GameObject gameObject = null;
	private CommandBuffer buffer = null;
	
	public InteriorCommandParameterBindExpressionValidator(String parameter, ICommandBuffer buffer) {
		// TODO Auto-generated constructor stub
		this.parameter = parameter;
		this.buffer = (CommandBuffer) buffer;
	}
	
	@Override
	public Boolean validate() {
		// TODO Auto-generated method stub
		String [] params = parameter.split(Calculator.SPACE);
		
		/*
		 * 这里自少要包含两个字符串，格式：set [@param method arguments]
		 */
		if(params.length<2){
			addMessage(I18n.getMessage(CommonIdentifier.ErrorInParameterFormat));
			return false;
		}
		
		/*
		 * 判断参数名是否带@
		 */
		if(0!=params[0].indexOf("@")){
			addMessage(I18n.getMessage(CommonIdentifier.ErrorInParameterFormat));
			return false;
		}
		
		this.declareName = params[0];
		
		String json = params[1];
		
		Jackson jackson = SpringUtils.getBean("jackson");
		try {
			Identification identification = jackson.parseObject(json, Identification.class);
			String playNo = buffer.getHost().getPlayNo();
			GameObject go = BinderHelper.getObject(playNo, identification);
			
			if(null==go) {
				addMessage(I18n.getMessage(CommonIdentifier.GameObjectNotFound));
				return false;
			}
			
			this.gameObject = go;
		} catch (Exception e) {
			// TODO: handle exception
			addMessage(I18n.getMessage(CommonIdentifier.ErrorInParameterFormat));
			return false;
		}
		
		return true;
	}
	
	public GameObject getGameObject() {
		return gameObject;
	}
	
	public String getDeclareName() {
		return this.declareName;
	}
}
