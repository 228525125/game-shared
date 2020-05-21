package org.cx.game.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.cx.game.builder.IObjectBuilder;
import org.cx.game.tools.IXmlHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagHelperBuilder {

	private Map<Integer,Integer> tagCategoryMap = new HashMap<Integer,Integer>();
	private Map<Integer,List<Integer>> categoryTagMap = new HashMap<Integer,List<Integer>>();
	private Map<Integer,List<Integer>> objectTagMap = new HashMap<Integer,List<Integer>>();
	private Map<Integer,List<Integer>> tagObjectMap = new HashMap<Integer,List<Integer>>();
	
	@Autowired
	private IXmlHelper xh;
	
	public TagHelper getInstance() {
		// TODO Auto-generated method stub
		Element tags = xh.getRoot("tag.path").element("tags");
		for(Iterator it = tags.elementIterator("category");it.hasNext();){
			Element category = (Element) it.next();
			Integer categoryCode = Integer.valueOf(category.attribute("code").getText());
			
			categoryTagMap.put(categoryCode, new ArrayList());
			for(Iterator ite = category.elementIterator("tag");ite.hasNext();){
				Element tag = (Element) ite.next();
				Integer tagCode = Integer.valueOf(tag.attribute("code").getText());
				
				tagCategoryMap.put(tagCode, categoryCode);
				categoryTagMap.get(categoryCode).add(tagCode);
				
				tagObjectMap.put(tagCode, new ArrayList<Integer>());
				for(Iterator iter = tag.elementIterator("object");iter.hasNext();){
					Element object = (Element) iter.next();
					Integer objectCode = Integer.valueOf(object.attribute("code").getText());
					
					
					if(null==objectTagMap.get(objectCode))
						objectTagMap.put(objectCode, new ArrayList<Integer>());
					
					objectTagMap.get(objectCode).add(tagCode);
					tagObjectMap.get(tagCode).add(objectCode);
				}
			}
		}
		
		TagHelper helper = new TagHelper();
		helper.setCategoryTagMap(categoryTagMap);
		helper.setTagCategoryMap(tagCategoryMap);
		helper.setObjectTagMap(objectTagMap);
		helper.setTagObjectMap(tagObjectMap);
		return helper;
	}

}
