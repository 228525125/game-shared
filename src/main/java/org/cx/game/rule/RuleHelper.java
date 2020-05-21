package org.cx.game.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleHelper {

	private Map<Integer, List<Integer>> phyleCorpsMap = new HashMap<Integer, List<Integer>>();
	
	public List<Integer> findCorpsByPhyle(Integer phyle) {
		return phyleCorpsMap.get(phyle);
	}
	
	public void setPhyleCorpsMap(Map<Integer, List<Integer>> phyleCorpsMap) {
		this.phyleCorpsMap = phyleCorpsMap;
	}
}
