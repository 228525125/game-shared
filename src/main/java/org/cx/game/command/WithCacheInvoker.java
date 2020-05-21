package org.cx.game.command;

import org.cx.game.validator.exception.ValidatorException;
import org.dom4j.Element;
import org.cx.game.host.Camera;
import org.cx.game.host.IHost;
import org.cx.game.host.IHostManager;
import org.cx.game.host.Record;
import org.cx.game.observer.AbstractObserver;
import org.cx.game.tools.IXmlHelper;
import org.cx.game.tools.SpringUtils;

public class WithCacheInvoker extends AbstractWithCacheInvoker {

	private CommandBuffer buffer = null;
	
	/**
	 * 主机已经被创建
	 * @param buffer 缓存了主机、玩家等信息
	 */
	public WithCacheInvoker(CommandBuffer buffer) {
		super(buffer);
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}
	
	@Override
	public Object handleCommand(String cmd) throws ValidatorException {
		// TODO Auto-generated method stub
		IXmlHelper xh = SpringUtils.getBean("xmlHelper");
		Element cmdEl = xh.getRoot("command.path");
		return handleCommand(cmd, cmdEl);
	}

	@Override
	protected void afterHandle() {
		// TODO Auto-generated method stub
		response = AbstractObserver.process.get().toString();
		AbstractObserver.process.get().delete(0, AbstractObserver.process.get().length());
		
		record();
	}

	/**
	 * 将观察结果记录下来
	 */
	private void record(){
		if(!"".equals(response) && 0<response.split(";").length){
			String[] resps = response.split(";");
			IHost host = buffer.getPlayer().getHost();
			String playNo = host.getPlayNo();
			Camera camera = host.getCamera();
			
			Integer sequence = camera.getNewSequence();
			for(int i=0;i<resps.length;i++){
				Record r = new Record();
				r.setPlayNo(playNo);				
				r.setExecutor(buffer.getPlayer().getTroop());
				r.setSequence(sequence+i);
				String action = resps[i].split("\",")[0].substring(11);
				r.setAction(action);
				r.setResult(resps[i].substring(11+action.length()+11, resps[i].length()-1));
				
				camera.addRecord(r);
			}
		}
	}
}
