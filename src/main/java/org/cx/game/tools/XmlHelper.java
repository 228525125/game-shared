package org.cx.game.tools;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class XmlHelper implements IXmlHelper {

	@Autowired
	private Environment environment;
	
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	@Override
	public Element getRoot(String alias) {
		// TODO Auto-generated method stub
		String filePath = environment.getProperty(alias);
		SAXReader saxReader = new SAXReader();
		try {
			ClassPathResource resource = new ClassPathResource(filePath);
			InputStream is=new BufferedInputStream(resource.getInputStream());
			Document document = saxReader.read(is);
			return document.getRootElement();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
