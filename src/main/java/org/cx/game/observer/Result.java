package org.cx.game.observer;

import java.io.Serializable;
import java.util.Map;

import org.cx.game.observer.IObservedResult;

import lombok.Data;

@Data
public class Result implements IObservedResult<Map<String, Object>>, Serializable {
	
	private String action;
	private Map<String, Object> result;
	
	public Result(String type, Map<String, Object> map) {
		// TODO Auto-generated constructor stub
		this.action = type;
		this.result = map;
	}
	
	public Result() {
		// TODO Auto-generated constructor stub
	}
}
