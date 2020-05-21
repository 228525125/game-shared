package org.cx.game.command.check;

import org.cx.game.builder.ObjectTypeBuilder;
import org.cx.game.builder.ObjectTypeParse;
import org.cx.game.builder.exception.BuilderException;
import org.cx.game.builder.exception.ParseException;
import org.cx.game.command.check.CheckHelper;
import org.cx.game.tools.IXmlHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckHelperBuilder {

	@Autowired
	private IXmlHelper xh;
	
	public CheckHelper getInstance() {
		// TODO Auto-generated method stub
		Element checkHelper = xh.getRoot("check.path");
		ObjectTypeBuilder otb = new ObjectTypeBuilder();
		try {
			new ObjectTypeParse(otb).parse(checkHelper);
			return (CheckHelper) otb.builder();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
