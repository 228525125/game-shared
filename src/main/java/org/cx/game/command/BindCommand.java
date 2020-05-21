package org.cx.game.command;

import java.util.Map;

import org.cx.game.command.exception.ExecuteValidatorException;
import org.cx.game.core.GameObject;

public class BindCommand extends WithCacheCommand {

	public BindCommand(ICommandBuffer buffer) {
		super(buffer);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object execute() throws ExecuteValidatorException {
		// TODO Auto-generated method stub
		Object ret = super.execute();
		
		Map<String, Object> param = (Map<String, Object>) parameter;
		String declareName = param.get("declareName").toString();
		GameObject go = (GameObject) param.get("gameObject");
		
		buffer.setParameter(declareName, go);
		
		return ret;
	}

}
