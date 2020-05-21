package org.cx.game.tools;

import java.util.Iterator;

import org.cx.game.builder.IObjectBuilder;
import org.cx.game.observer.AbstractObserver;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObserverBuilder implements IObjectBuilder<AbstractObserver<?>>{
	
	
	@Autowired
	private IXmlHelper xh;
	
	public AbstractObserver<?> getInstance() {
		return getInstance(AbstractObserver.Response_Format_DEFAULT_ID);
	}
	
	public AbstractObserver<?> getInstance(Integer responseId) {
		Element configEl = xh.getRoot("gameconfig.path");
		Element responseEl = configEl.element(XmlUtil.GameConfig_ResponseFormat);
		for(Iterator<Element> it = responseEl.elementIterator();it.hasNext();){
			Element el = it.next();
			if(responseId.equals(Integer.valueOf(el.attribute(XmlUtil.Attribute_Id).getText()))) {
				Class clazz;
				try {
					clazz = Class.forName(el.element(XmlUtil.GameConfig_FormatClass).getText());
					return (AbstractObserver<?>) clazz.newInstance();
				} catch (ReflectiveOperationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
}
