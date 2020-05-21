package org.cx.game.utils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Connect {
	
	@NotNull
	@NotBlank
	private String playNo;         //比赛ID号
	
	@NotNull
	@Min(1)
	private Integer troop;         //阵营
	
	@NotNull
	@Min(0)
	private Integer sequence = 0;  //同步进程
	private Boolean firstHand = false;    //先手
	private Integer hostStatus = 0;      //主机状态
}
