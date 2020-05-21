package org.cx.game.command;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.cx.game.host.IHost;
import org.cx.game.host.IPlayer;

public class CommandBuffer implements ICommandBuffer, Serializable {

	private Object cacheObject = null;
	private IPlayer player = null;
	private IHost host = null;
	private Stack<Object> stack = null;
	private Map<String, Object> parameter = null;
	
	public CommandBuffer(IPlayer player) {
		// TODO Auto-generated constructor stub
		this.player = player;
		this.host = player.getHost();
		stack = new Stack<Object>();
		set(host);
		parameter = new HashMap<String, Object>();
	}

	public IPlayer getPlayer() {
		return player;
	}
	
	public IHost getHost() {
		return host;
	}
	
	public void set(Object object) {
		stack.push(this.cacheObject);
		this.cacheObject = object;
	}
	
	public Object get() {
		return this.cacheObject;
	}
	
	public void backspace() {
		if(this.stack.isEmpty())
			this.cacheObject = this.player;
		else
			this.cacheObject = this.stack.pop();
	}
	
	public void clean() {
		this.stack.clear();
		set(getHost());
	}
	
	public void cleanParameter() {
		this.parameter.clear();
	}
	
	public void setParameter(String parameterName, Object parameter) {
		this.parameter.put(parameterName, parameter);
	}
	
	public Object getParameter(String parameterName) {
		return this.parameter.get(parameterName);
	}
}
