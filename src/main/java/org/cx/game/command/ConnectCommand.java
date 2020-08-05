package org.cx.game.command;

import java.util.HashMap;
import java.util.Map;

import org.cx.game.command.exception.ExecuteValidatorException;
import org.cx.game.host.IHost;
import org.cx.game.host.IHostManager;
import org.cx.game.tools.I18n;
import org.cx.game.tools.SpringUtils;

public class ConnectCommand extends Command {

	@Override
	public Object execute() throws ExecuteValidatorException {
		// TODO Auto-generated method stub
		super.execute();
		
		String account = parameter.toString();
		IHostManager hm = SpringUtils.getBean("hostManager");
		String playNo = hm.getPlayNoByCreator(account);
	
		if(null==playNo) throw new ExecuteValidatorException(this.getClass().getName()+".fail");
		
		Integer troop = null;
		IHost host = hm.get(playNo);
		troop = host.getTroopForAccount(account);		
		
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("playNo", playNo);
		ret.put("troop", troop);
		ret.put("sequence", host.getCamera().getLastSequence());
		ret.put("firstHand", false);
		ret.put("hostStatus", host.getStatus());
		ret.put("account", account);
		
		return ret;
	}
}
