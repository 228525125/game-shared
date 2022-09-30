package org.cx.game.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.server.PowerType;
import org.cx.game.command.CommandBuffer;
import org.cx.game.command.bind.BinderHelper;
import org.cx.game.command.bind.Identification;
import org.cx.game.core.GameObject;
import org.cx.game.host.IHost;

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
		if(Util.isPowerType(str))
			return PowerType.class;
		return String.class;
	}
	
	/**
	 * 根据字符串解析对象
	 * @param str
	 * @param buffer 如果前台传递GameObject.pid，则需要buffer来获取GameObject
	 * @return
	 */
	public static Object getParameterObject(String str, CommandBuffer buffer) {
		JsonHelper jsonHelper = SpringUtils.getBean("jsonHelper");
		if(Util.isInteger(str))
			return Integer.valueOf(str);
		if(Util.isBoolean(str))
			return Boolean.valueOf(str);
		if(Util.isList(str)) {
			String fanxing = str.substring(str.indexOf("<")+1, str.indexOf(">"));
			try {
				Class clz = Class.forName(fanxing);
				if(GameObject.class.isAssignableFrom(clz)) {      //如果是GameObject，只传递Pid的集合
					List<Integer> list = jsonHelper.parseObject(str.substring(str.indexOf("[")), new TypeReference<List<Integer>>() {});
					List<GameObject> gos = new ArrayList<GameObject>();
					for(Integer pid : list) {
						IHost host = buffer.getHost();
						GameObject go = host.getGameObjects().get(pid);
						gos.add(go);
					}
					
					return gos;
				}
				
				if(clz.equals(Point.class)) {
					return jsonHelper.parseObject(str.substring(str.indexOf("[")), new TypeReference<List<Point>>() {});
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(Util.isMap(str)) 
			return jsonHelper.parseObject(str, Map.class);
		if(Util.isPoint(str))
			return jsonHelper.parseObject(str.substring(str.indexOf("{")), Point.class);
		if(Util.isPowerType(str)) {
			return Util.parse(str);
		}
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
