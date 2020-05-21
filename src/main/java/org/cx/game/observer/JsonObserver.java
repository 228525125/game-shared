package org.cx.game.observer;

import java.util.Map;
import java.util.Observable;

import org.cx.game.observer.AbstractObserver;
import org.cx.game.observer.IObservedResult;
import org.cx.game.tools.Jackson;
import org.cx.game.tools.JsonHelper;
import org.cx.game.tools.Logger;
import org.cx.game.tools.SpringUtils;
import org.springframework.stereotype.Component;

@Component
public class JsonObserver extends AbstractObserver<Map<String, Object>> {
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		IObservedResult<Map<String, Object>> result = (IObservedResult<Map<String, Object>>) arg;
		Object obj = convert(result);
		super.process.get().append(obj.toString()+";");
	}
	
	@Override
	protected Object convert(IObservedResult<Map<String, Object>> resp) {
		// TODO Auto-generated method stub
		JsonHelper helper = SpringUtils.getBean("jsonHelper");
		String json = helper.toJson(resp);
		Logger.debug(json);
		return json;
	}
	
	public static void main(String[] args) {
		//AbstractObserver defaultObserver = ObserverFactory.getInstance();
		//System.out.println(defaultObserver);
		
		Object obj = new Object();
		String name = obj.getClass().getName();
		System.out.println(name);
		//System.out.println(Jackson.getInstance().toJson(obj));
	}

	
}
