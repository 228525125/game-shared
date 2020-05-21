package org.cx.game.command.bind;

import java.util.HashMap;
import java.util.Map;

import org.cx.game.core.GameObject;
import org.cx.game.host.IHost;
import org.cx.game.host.IHostManager;
import org.cx.game.tools.SpringUtils;

public class GameObjectBinder extends AbstractBinder<GameObject> {

	@Override
	public Identification generateIdentification(GameObject obj) {
		// TODO Auto-generated method stub
		Identification id = super.generateIdentification(obj);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", obj.getPid());
		id.setIdentify(map);
		return id;
	}
	
	@Override
	public GameObject getObject(String playNo, Object identify) {
		// TODO Auto-generated method stub
		Map<String, Object> map = (Map<String, Object>) identify;
		Integer pid = (Integer) map.get("pid");
		IHostManager hm = SpringUtils.getBean("hostManager");
		IHost host = hm.get(playNo);
		return host.getGameObjects().get(pid);
	}

	
}
