package org.cx.game.command;

import org.cx.game.validator.exception.ValidatorException;
import org.dom4j.Element;
import org.cx.game.observer.AbstractObserver;
import org.cx.game.tools.IXmlHelper;
import org.cx.game.tools.SpringUtils;

/**
 * 在没有创建主机时使用，主要用于创建主机的过程
 * @author admin
 *
 */
public class SimpleInvoker extends AbstractSimpleInvoker {
	
	@Override
	public Object handleCommand(String cmd) throws ValidatorException {
		// TODO Auto-generated method stub
		IXmlHelper xh = SpringUtils.getBean("xmlHelper");
		Element cmdEl = xh.getRoot("command.path");
		return handleCommand(cmd, cmdEl);
	}
	
	/*
	 * 把执行中观察的结果反馈给前台
	 */
	protected void afterHandle() {
		response = AbstractObserver.process.get().toString();
		AbstractObserver.process.get().delete(0, AbstractObserver.process.get().length());
	}

}
