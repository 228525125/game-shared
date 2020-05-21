package org.cx.game.tag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.cx.game.tools.IListFilter;
import org.cx.game.tools.ListUtils;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class TagHelper implements Serializable {
	
	
	public final static Integer Category_Zhanqileixing = 1003;
	public final static Integer Category_Zhongzu = 1004;
	public final static Integer Category_Fashugongneng = 1005;
	public final static Integer Category_Zhiye = 1006;
	
	private Map<Integer,Integer> tagCategoryMap = new HashMap<Integer,Integer>();
	private Map<Integer,List<Integer>> categoryTagMap = new HashMap<Integer,List<Integer>>();
	private Map<Integer,List<Integer>> objectTagMap = new HashMap<Integer,List<Integer>>();
	private Map<Integer,List<Integer>> tagObjectMap = new HashMap<Integer,List<Integer>>();
	
	/**
	 * 根据对象，查询tag
	 * @param object
	 * @return
	 */
	public List<Integer> queryForObject(Integer object){
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> list = objectTagMap.get(object);
		if(null!=list){
			result.addAll(list);
		}
		return result;
	}
	
	/**
	 * 根据种类、对象，查询tag
	 * @param category
	 * @param object
	 * @return
	 */
	public List<Integer> queryForCategoryTag(Integer category, Integer object) {
		List<Integer> tags1 = queryForCategory(category);
		List<Integer> tags2 = queryForObject(object);
		tags1.retainAll(tags2);
		return tags1;
	}
	
	/**
	 * 根据tag，查询对象	
	 * @param tag
	 * @return
	 */
	public List<Integer> queryForTag(Integer tag){
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> list = tagObjectMap.get(tag);
		if(null!=list)
		result.addAll(list);
		return result;
	}
	
	/**
	 * 根据category，查询tag的集合
	 * @param category
	 * @return
	 */
	public List<Integer> queryForCategory(Integer category){
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> list = categoryTagMap.get(category);
		if(null!=list)
		result.addAll(list);
		return result;
	}
	
	/**
	 * 根据tag，查询category
	 * @param category
	 * @return
	 */
	public Integer getCategory(Integer tag){
		return tagCategoryMap.get(tag);
	}

	public void setTagCategoryMap(Map<Integer, Integer> tagCategoryMap) {
		this.tagCategoryMap = tagCategoryMap;
	}

	public void setCategoryTagMap(Map<Integer, List<Integer>> categoryTagMap) {
		this.categoryTagMap = categoryTagMap;
	}

	public void setObjectTagMap(Map<Integer, List<Integer>> objectTagMap) {
		this.objectTagMap = objectTagMap;
	}

	public void setTagObjectMap(Map<Integer, List<Integer>> tagObjectMap) {
		this.tagObjectMap = tagObjectMap;
	}
	
}
