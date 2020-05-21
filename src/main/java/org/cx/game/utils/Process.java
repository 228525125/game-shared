package org.cx.game.utils;

import lombok.Data;

@Data
public class Process {
	
	public static final String Sign_Syn = "syn";
	public static final String Sign_Send = "send";
	
	private Long id;
	private String playNo;                   //比赛ID号
	private Integer sequence;                //序号
	private String response;                 //响应的完整json
	private Integer executor;                //操作者
	private String action;                   //对应后台方法
	private String sign = Sign_Send;         //用于前台判断syn和send
}
