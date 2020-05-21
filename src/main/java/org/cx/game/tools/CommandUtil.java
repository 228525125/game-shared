package org.cx.game.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cx.game.arithmetic.Point;
import com.fasterxml.jackson.core.type.TypeReference;

public class CommandUtil {
	
	public static Class getParameterType(String str) {
		if(Util.isInteger(str))
			return Integer.class;
		if(Util.isBoolean(str))
			return Boolean.class;
		if(Util.isList(str)) 
			return List.class;
		if(Util.isMap(str))
			return Map.class;
		
		return String.class;
	}
	
	public static Object getParameterObject(String str) {
		JsonHelper jsonHelper = SpringUtils.getBean("jsonHelper");
		if(Util.isInteger(str))
			return Integer.valueOf(str);
		if(Util.isBoolean(str))
			return Boolean.valueOf(str);
		if(Util.isList(str)) {
			String fanxing = str.substring(str.indexOf("<")+1, str.indexOf(">"));
			if(-1 != fanxing.indexOf("Point"))
				return jsonHelper.parseObject(str.substring(str.indexOf("[")), new TypeReference<List<Point>>() {});
			
			return jsonHelper.parseObject(str.substring(str.indexOf("[")), List.class);	
		}
		if(Util.isMap(str)) 
			return jsonHelper.parseObject(str, Map.class);
		if(Util.isPoint(str))
			return jsonHelper.parseObject(str.substring(str.indexOf("{")), Point.class);
		
		return str;
	}
	
	/**
	 * clzs2[i] 等于 clzs1[i]，或是父类
	 * @param c1 命令参数的class
	 * @param c2 方法参数的class
	 * @return
	 */
	public static Boolean compareParameterClass(Class [] c1, Class[] c2) {
		if(c1.length != c2.length)
			return false;
		
		for(int i=0;i<c1.length;i++){
			if(c1[i].equals(c2[i]) || isSuperClassOrInterface(c2[i], c1[i]))
				continue;
			else
				return false;
		}
		
		return true;
	}
	
	/**
	 * c1 是 c2 的父类或接口则返回true
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static Boolean isSuperClassOrInterface(Class c1, Class c2) {
		List<Class> list = new ArrayList<Class>();
		Class superClass = c2.getSuperclass();
		while(null!=superClass){
			list.add(superClass);
			superClass = superClass.getSuperclass();
		}
		
		for(Class inf : c2.getInterfaces())
			list.add(inf);
		
		return list.contains(c1);
	}
	
	/*public static String conversionNotifyType(String name) {
		Properties prop = new Properties();
		ClassPathResource resource = new ClassPathResource("conversion.properties");
		try {
			prop.load(resource.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = prop.getProperty(name);
		return path;
	}*/
	
	public static void main(String[] args) {
		String str = "Map<Point>";
		System.out.println(str.substring(str.indexOf("<")+1, str.indexOf(">")));
	}
}
