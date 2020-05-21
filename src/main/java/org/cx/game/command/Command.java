package org.cx.game.command;

import org.cx.game.tools.ObserverBuilder;
import org.cx.game.tools.SpringUtils;

public class Command extends AbstractCommand {
	
	public Command() {
		// TODO Auto-generated constructor stub
		ObserverBuilder builder = SpringUtils.getBean("observerBuilder");
		addObserver(builder.getInstance());
	}
}
