package org.cx.game.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.cx.game.builder.ObjectTypeBuilder;
import org.cx.game.builder.ObjectTypeParse;
import org.cx.game.builder.exception.BuilderException;
import org.cx.game.builder.exception.ParseException;
import org.cx.game.rule.RuleGroup;
import org.cx.game.tools.IXmlHelper;
import org.cx.game.tools.XmlUtil;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RuleBuilder {
	
	@Autowired
	private IXmlHelper xh;
	
	public RuleGroup getInstance(Integer groupId){
		Element groupEl = null;
		for(Iterator it = xh.getRoot("rule.path").elementIterator("ruleGroup");it.hasNext();){
			Element el = (Element) it.next();
			if(groupId.equals(Integer.valueOf(el.attribute(XmlUtil.Rule_RuleGroup_Id).getText())))
				groupEl = el;
		}
		
		if(null!=groupEl){
			ObjectTypeBuilder otb = new ObjectTypeBuilder();
			try {
				new ObjectTypeParse(otb).parse(groupEl);
				RuleGroup rg = (RuleGroup) otb.builder();
				return rg;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BuilderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public RuleHelper getInstance(){
		
		Map<Integer, List<Integer>> phyleCorpsMap = new HashMap<Integer, List<Integer>>();
		
		Element entranceEl = xh.getRoot("rule.path").element(XmlUtil.Rule_EntranceRule);
		for(Iterator it = entranceEl.elementIterator(XmlUtil.Rule_Tag);it.hasNext();){
			Element tag = (Element) it.next();
			Integer tagCode = Integer.valueOf(tag.attribute(XmlUtil.Rule_Tag_Code).getText());
			
			phyleCorpsMap.put(tagCode, new ArrayList<Integer>());
			for(Iterator ite = tag.elementIterator(XmlUtil.Rule_Corps);ite.hasNext();){
				Element corps = (Element) ite.next();
				Integer corpsType = Integer.valueOf(corps.attribute(XmlUtil.Rule_Corps_Type).getText());
				
				phyleCorpsMap.get(tagCode).add(corpsType);
			}
		}
		
		RuleHelper helper = new RuleHelper();
		helper.setPhyleCorpsMap(phyleCorpsMap);
		return helper;
	}
}
