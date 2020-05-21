package org.cx.game.host;

import java.io.Serializable;

public class Record implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String playNo = null;      //比赛唯一标识
	private Integer sequence = null;   //顺序号
	private Integer executor = null;   //命令发起人的阵营编号
	private String result = null;     
	private String action = null;
	
	public String getPlayNo() {
		return playNo;
	}
	public void setPlayNo(String playNo) {
		this.playNo = playNo;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getExecutor() {
		return executor;
	}
	public void setExecutor(Integer executor) {
		this.executor = executor;
	}
}
