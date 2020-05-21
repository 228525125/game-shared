package org.cx.game.command;

import org.cx.game.command.exception.ExecuteValidatorException;

public class CleanBufferCommand extends WithCacheCommand {

	public CleanBufferCommand(ICommandBuffer buffer) {
		super(buffer);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object execute() throws ExecuteValidatorException {
		// TODO Auto-generated method stub
		Object ret = super.execute();
		
		buffer.clean();
		
		return ret;
	}

}
