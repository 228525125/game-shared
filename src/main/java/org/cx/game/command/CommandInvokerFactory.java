package org.cx.game.command;

import org.cx.game.command.IInvoker;
import org.cx.game.host.IHost;
import org.cx.game.host.IHostManager;
import org.cx.game.host.IPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandInvokerFactory {
	
	public IInvoker getInstance(IHost host, Integer troop) {
		CommandBuffer cb = new CommandBuffer(host.getPlayer(troop)); 
		IInvoker invoker = new WithCacheInvoker(cb);
		return invoker;
	}
	
	public IInvoker getInstance() {
		IInvoker invoker = new SimpleInvoker();
		return invoker;
	}
}
