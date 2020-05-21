package org.cx.game.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.cx.game.utils.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

@Component
public class JsonHelper {

	@Autowired
	private Jackson jackson;
	
	private Map<String, String[]> filters;
	
	public JsonHelper() {
		// TODO Auto-generated constructor stub
		filters = new HashMap<String, String[]>();
		filters.put("Host", new String[]{"otype","pid","playNo"});
		filters.put("Player", new String[]{"otype","pid","troop", "name"});
		filters.put("Corps", new String[]{"otype","pid","troop","name","position"});
		filters.put("Place", new String[]{"otype","pid","position"});
		filters.put("Building", new String[]{"otype","pid","type","place","name"});
		filters.put("Treasure", new String[]{"otype","pid","type"});
		filters.put("Skill", new String[]{"otype","pid","type","corps"});
	}
	
	public String toJson(Object obj) {
		for(String filterName : filters.keySet()) {
			jackson.addFilter(filterName, filters.get(filterName));
		}
		
		return jackson.toJson(obj);
	}
	
	public <T> T parseObject(String json, Class<T> type) {
		return jackson.parseObject(json, type);
	}
	
	public <T> T parseObject(String content, TypeReference<T> typeRef) {
		return jackson.parseObject(content, typeRef);
	}
	
	public static void main(String[] args) {
		JsonHelper helper = new JsonHelper();
		String json = "{'command' : 'cmd'}";
		helper.parseObject(json, Command.class);
	}
}
