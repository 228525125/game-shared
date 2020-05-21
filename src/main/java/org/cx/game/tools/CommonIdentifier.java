package org.cx.game.tools;

public class CommonIdentifier {
	
	//------------------ Exception ------------------//
		//public final static String ExecuteValidatorException = "ExecuteValidatorException";
		
	//------------------ Treasure ------------------//
		
	public final static Integer Gold = 701;                    //金币
	public final static Integer Wood = 702;                    //木材
	public final static Integer Stone = 703;                   //石材
	public final static Integer Ore = 704;                     //矿石
	public final static Integer EmpiricValue = 710;            //经验值
	public final static Integer SkillCount = 720;              //技能点
		
	//---------------- Corps ----------------//
		
	public final static Integer Death_Status_Live = 0;         //战斗
	public final static Integer Death_Status_Death = 1;        //死亡
	public final static Integer Death_Status_Exist = 2;        //存在
	
	public static final Integer Move_Type_Walk = 141;          //步行
	public static final Integer Move_Type_Equitation = 142;    //骑行
	public static final Integer Move_Type_Drive = 143;         //驾驶
	public static final Integer Move_Type_Fly = 144;           //飞行
	public static final Integer Move_Type_Transmit = 145;      //传送
	public static final Integer Move_Type_Sneak = 146;         //潜行
		
	public final static Integer Attack_Mode_Near = 115;   //近战肉搏
	public final static Integer Attack_Mode_Far = 116;    //远程射击
	public final static Integer Attack_Mode_EquitationFar = 117;  //骑射	

	public final static Integer Corps = 1007;   

	public final static Integer Stirps = 1004;   //种族
	public final static Integer Stirps_Human = 171;  //人族
	public final static Integer Stirps_Angel = 173;  //天神
	public final static Integer Stirps_Die = 172;    //亡灵
	public final static Integer Stirps_Daimon = 174;  //恶魔
	public final static Integer Stirps_Beast = 175;   //野兽
	public final static Integer Stirps_Insect = 176;  //昆虫
	public final static Integer Stirps_Plant = 177;   //植物
	public final static Integer Stirps_Machine = 178;  //机械
	public final static Integer Stirps_Dragon = 179;   //龙
	public final static Integer Stirps_Fish = 180;     //鱼
	
	public final static Integer Profession = 1006;     //职业
	public final static Integer Profession_Soldier = 301;  //战士
	public final static Integer Profession_Magic = 302;   //法师
	public final static Integer Profession_Pastor = 303;  //牧师
	public final static Integer Profession_Paladin = 304;  //圣骑士
	public final static Integer Profession_Hunter = 305;   //猎人
	public final static Integer Profession_Thief = 306;    //盗贼
	
	//--------------- Magic ------------------//
	
	public static final Integer Style_physical = 111;       //物理
	public static final Integer Style_Magic = 112;          //魔法
	
	public static final Integer Skill_Fight = 251;          //肉搏
	public static final Integer Skill_Archery = 252;        //箭术
	public static final Integer Skill_Trap = 253;           //陷阱
	public static final Integer Skill_Fast = 254;           //迅捷
	public static final Integer Skill_Sacred = 255;           //神圣
	public static final Integer Skill_Death = 256;           //死亡
	public static final Integer Skill_Natural = 257;           //自然
	public static final Integer Skill_Element = 258;           //元素
	
	public static final Integer Func_Astrict = 201;         //移动限制
	public static final Integer Func_Damage = 202;          //直接伤害
	public static final Integer Func_Call = 203;            //召唤
	public static final Integer Func_Cure = 204;            //治疗
	public static final Integer Func_Loss = 205;            //损益
	public static final Integer Func_SustainedHarm = 206;   //持续伤害
	public static final Integer Func_Trick = 207;           //陷阱
	public static final Integer Func_Bump = 208;            //冲锋
	public static final Integer Func_Mystery = 209;         //秘术
	public static final Integer Func_Other = 299;           //其他功能
	
	public final static Integer Buff = 1009;
	public static final Integer Type_Benefit = 121;         //受益，不包含系统级的buff
	public static final Integer Type_Harm = 122;            //受损，不包含系统级的buff
	public static final Integer Type_Neutral = 123;         //中性
	
	public final static Integer Skill = 1008;
	
	public final static Integer Trick = 1013;
	
	//---------------- Landform ----------------//
	
	public static final Integer Landform = 1011;
	
	//---------------- Building ----------------//
	
	public static final Integer Building = 1010;
	
	public static final Integer Building_Town = 501;  //城镇
	
	
	public static final Integer Building_Bridge = 502;  //桥
	public static final Integer Building_Smithyt = 503; //铁匠铺
	public static final Integer Building_Hieron = 504;  //神殿
	public static final Integer Building_Call = 505;
	public static final Integer Building_Spatial = 506; //传送站
	
	/*public static final Integer Building_Chengshi = 601001; //城市
	public static final Integer Building_Ganglou = 602001; //岗楼
	public static final Integer Building_Jianta = 603001; //箭塔
	public static final Integer Building_Shijiuta = 604001; //狮鹫塔
	public static final Integer Building_Bingying = 605001; //兵营
	public static final Integer Building_Siyuan = 606001; //寺院
	public static final Integer Building_Mapeng = 607001; //马棚
	public static final Integer Building_Xunlianchang = 608001; //训练场*/
	
	public final static String Query_Move_Range = "Query_Move_Range";
	public final static String Query_Attack_Range = "Query_Attack_Range";
	public final static String Query_Execute_Range = "Query_Execute_Range";
	public final static String Query_Pick_Range = "Query_Pick_Range";
	
	//---------------- NotifyInfo -----------------//
	
	public final static String Ground_LoadMap = "Ground_LoadMap";
	
	public final static String Corps_Action_Attack = "Corps_Action_Attack";
	public final static String Corps_Action_Defend = "Corps_Action_Defend";
	public final static String Corps_Action_Affected = "Corps_Action_Affected";
	public final static String Corps_Action_Activate = "Corps_Action_Activate";
	public final static String Corps_Action_Call = "Corps_Action_Call";
	public final static String Corps_Action_Chuck = "Corps_Action_Chuck";
	public final static String Corps_Action_Conjure = "Corps_Action_Conjure";
	public final static String Corps_Action_Death = "Corps_Action_Death";
	public final static String Corps_Action_Grow = "Corps_Action_Grow";
	public final static String Corps_Action_Move = "Corps_Action_Move";
	public final static String Corps_Action_Moved = "Corps_Action_Moved";
	public final static String Corps_Action_Pick = "Corps_Action_Pick";
	public final static String Corps_Action_Placement = "Corps_Action_Placement";
	public final static String Corps_Action_Reinforce = "Corps_Action_Reinforce";
	public final static String Corps_Action_Upgrade = "Corps_Action_Upgrade";
	
	public final static String Corps_State_Hide = "Corps_State_Hide";
	public final static String Corps_State_Hp = "Corps_State_Hp";
	public final static String Corps_State_Atk = "Corps_State_Atk";
	public final static String Corps_State_Def = "Corps_State_Def";
	public final static String Corps_State_Speed = "Corps_State_Speed";
	public final static String Corps_State_Lock = "Corps_State_Lock";
	public final static String Corps_State_Energy = "Corps_State_Energy";
	public final static String Corps_State_Consume = "Corps_State_Consume";
	public final static String Corps_State_Direction = "Corps_State_Direction";
	
	public final static String Corps_Skill_Used = "Corps_Skill_Used";
	public final static String Corps_Skill_Affect = "Corps_Skill_Affect";
	public final static String Corps_Skill_BeforeExecute = "Corps_Skill_BeforeExecute";
	public final static String Corps_Skill_Executed = "Corps_Skill_Executed";
	public final static String Corps_Skill_Execute = "Corps_Skill_Execute";
	
	public final static String Corps_Buff_Effect = "Corps_Buff_Effect";
	public final static String Corps_Buff_Affect = "Corps_Buff_Affect";
	public final static String Corps_Buff_Invalid = "Corps_Buff_Invalid";
	
	public final static String Context_Queue_Remove = "Context_Queue_Remove";  
	public final static String Context_Queue_Insert = "Context_Queue_Insert";  
	public final static String Context_Queue_Refurbish = "Context_Queue_Refurbish";	
	
	public final static String Ground_Place_In = "Ground_Place_In";
	public final static String Ground_Place_InCemetery = "Ground_Place_InCemetery";
	public final static String Ground_Place_Out = "Ground_Place_Out";
	public final static String Ground_Place_OutCemetery = "Ground_Place_OutCemetery";
	public final static String Ground_Building_Build = "Ground_Building_Build";
	public final static String Ground_Building_Upgrade = "Ground_Building_Upgrade";
	public final static String Ground_Building_Demolish = "Ground_Building_Demolish";
	public final static String Ground_Building_Work = "Ground_Building_Work";
	public final static String Ground_Building_Work_Transmit = "Ground_Building_Work_Transmit";
	public final static String Ground_Building_Work_Receive = "Ground_Building_Work_Receive";
	
	public final static String Ground_Treasure_Picked = "Ground_Treasure_Picked";
	
	public final static String Context_State_Start = "Context_State_Start";
	public final static String Context_State_Deploy = "Context_State_Deploy";
	public final static String Context_State_Done = "Context_State_Done";
	public final static String Context_State_Finish = "Context_State_Finish";
	
	public final static String Player_HandChess_Executed = "Player_HandChess_Executed";
	public final static String Player_Spell_Used = "Player_Spell_Used";
	public final static String Player_Spell_Executed = "Player_Spell_Executed";
	
	public final static String Module_Command_CreateHost = "Module_Command_CreateHost";
	public final static String Module_Command_Connect = "Module_Command_Connect";
	public final static String Module_Command_JoinHost = "Module_Command_JoinHost";
	//public final static String Module_Command_Get = "Module_Command_Get";
	
	/*public final static String Module_Command_Error = "Command_Error";
	public final static String Module_Command_Show = "Command_Show";
	public final static String Module_Command_Select = "Command_Select";
	public final static String Module_Command_Call = "Command_Call";
	public final static String Module_Command_Put = "Command_Put";
	public final static String Module_Command_Switch = "Command_Switch";
	public final static String Module_Command_Deploy = "Command_Deploy";
	public final static String Module_Command_Ready = "Command_Ready";*/
	
	/*public final static String Building_Option_Spacing_Process = "Building_Option_Spacing_Process";
	public final static String Building_Option_Execute_Process = "Building_Option_Execute_Process";
	public final static String Building_Upgrade_Product = "Building_Upgrade_Product";*/
	
	public final static String Game_Start = "Game_Start";
	public final static String Game_Over = "Game_Over";
	
	public final static String Card_Play = "Card_Play";
	public final static String Card_Draw = "Card_Draw";
	public final static String Character_Change_Mana = "Character_Change_Mana";
	public final static String Character_Change_Status = "Character_Change_Status";
	public final static String Character_Created = "Character_Created";
	
	public final static String Turn_Start = "Turn_Start";
	public final static String Turn_End = "Turn_End";
	
	//--------------------------- Error Type -----------------------------//
	public final static String ObjectsNotSpecifiedInTheCache = "ObjectsNotSpecifiedInTheCache";
	public final static String ErrorInParameterFormat = "ErrorInParameterFormat";
	public final static String GameObjectNotFound = "GameObjectNotFound";
	
}
