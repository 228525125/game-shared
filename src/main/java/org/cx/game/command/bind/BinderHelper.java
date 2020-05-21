package org.cx.game.command.bind;

import java.util.Map;

import org.cx.game.core.GameObject;

public class BinderHelper {

	private static IBinder<GameObject> gameObjectBinder = new GameObjectBinder();
	
	public static Object generateIdentification(Object obj) {
		
		if (obj instanceof GameObject) {
			GameObject go = (GameObject) obj;
			return gameObjectBinder.generateIdentification(go);
		}
		
		return "";
	}
	
	public static GameObject getObject(String playNo, IIdentification id) {
		return (GameObject) id.getBinder().getObject(playNo, id.getIdentify());
	}
}
