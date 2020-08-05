package org.cx.game.host;

public interface IPlayer {
	
	/**
	 * 游戏主机
	 * @return
	 */
	public IHost getHost();
	
	public void setHost(IHost host);
	
	/**
	 * 阵营，它根据比赛中的位置来定的
	 * @return
	 */
	public Integer getTroop();
	
	public void setTroop(Integer troop);
	
	/**
	 * 玩家帐号
	 * @return
	 */
	public String getName();
	
	public void setName(String name);
}
