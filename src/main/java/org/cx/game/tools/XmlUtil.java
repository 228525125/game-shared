package org.cx.game.tools;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

public class XmlUtil {
	
	/*public static Element getRoot(String path) {
		SAXReader saxReader = new SAXReader();
		try {
			String fileName = PropertiesUtil.getConfigure(path);
			ClassPathResource resource = new ClassPathResource(fileName);
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
	}*/
	
	/*
	 * 将xml配置文件中的标签和属性等集中申明
	 * Command_Command_Parameter_Request 等于 文件名_元素_属性_值
	 */
	
	public final static String Command_Types = "types";
	public final static String Command_Type = "type";
	public final static String Command_Type_Name = "name";
	public final static String Command_Item = "item";
	public final static String Command_Commands = "commands";
	public final static String Command_Command = "command";
	public final static String Command_Command_Name = "name";
	public final static String Command_Command_Class = "class";
	public final static String Command_Command_Parameter = "parameter";
	public final static String Command_Command_Parameter_Request = "request";
	public final static String Command_Parameter = "parameter";
	public final static String Command_Parameter_Expression = "expression";
	public final static String Command_Option = "option";
	
	/*public final static String Advantage_Advantage = "advantage";
	public final static String Advantage_Profession_Type = "type";*/
	
	/*public final static String Move_Move = "move";
	public final static String Move_Consume = "consume";
	public final static String Move_MoveType_Type = "type";
	public final static String Move_Landform_Type = "type";*/
	
	public final static String GameParameter_TopographicAdvantage = "topographicAdvantage";
	public final static String GameParameter_Landform = "landform";
	public final static String GameParameter_Landform_Code = "code";
	public final static String GameParameter_Object = "object";
	public final static String GameParameter_Object_Type = "type";
	public final static String GameParameter_Object_Type_MoveConsume = "MoveConsume";
	public final static String GameParameter_Object_Type_OffensiveAndDefensiveOfProfession = "OffensiveAndDefensiveOfProfession";
	public final static String GameParameter_Object_Code = "code";
	
	
	public final static String Corps_Corps = "corps";
	public final static String Corps_Card = "card";
	public final static String Corps_Card_Id = "id";
	
	public final static String Skill_Id = "id";
	public final static String Spell_Id = "id";
	
	public final static String Area_Area_Id = "id";
	
	public final static String Map_Map_Id = "id";
	
	public final static String Building_Building_Id = "id";
	
	public final static String Rule_RuleGroup_Id = "id";
	
	public final static String GameConfig_ResponseFormat = "response-format";
	public final static String GameConfig_FormatName = "format-name";
	public final static String GameConfig_FormatClass = "format-class";
	public final static String GameConfig_CommandsThatDoNotRequireControl = "commandsThatDoNotRequireControl";
	public final static String GameConfig_CommandClass = "command-class";
	
	public final static String Scene_Scene_Id = "id";
	
	public final static String Rule_EntranceRule = "entranceRule";
	public final static String Rule_Tag = "tag";
	public final static String Rule_Tag_Code = "code";
	public final static String Rule_Corps = "corps";
	public final static String Rule_Corps_Type = "type";
	
	public final static String Storage_Storage = "storage";
	
	//----------------通用---------------
	
	public final static String Attribute_Id = "id";
	public final static String Attribute_Type = "type";
	public final static String Attribute_Factory = "factory";
	public final static String Attribute_Interface = "interface";
	public final static String Attribute_Collection = "collection";
	public final static String Attribute_Map = "map";
	public final static String Attribute_Delayed = "delayed";
	
	public final static String Attribute_Value_Int = "int";
	public final static String Attribute_Value_Str = "str";
	public final static String Attribute_Value_Double = "double";
	public final static String Attribute_Value_Bool = "bool";
	
	public final static String Element_FactoryMethodParameter = "factoryMethodParameter";
	public final static String Element_Parameter = "parameter";
	public final static String Element_Key = "key";
	public final static String Element_Value = "value";
	
	public final static String List = "list";
	
	
	
	
}
