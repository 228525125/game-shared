package org.cx.game.host;

import java.util.Map;

import org.cx.game.core.GameObject;

import lombok.Synchronized;

public interface IHost {

	/**
	 * 主机代码
	 * @return
	 */
	public String getPlayNo();
	
	/**
	 * 用于记录整场比赛的摄像机
	 * @return
	 */
	public Camera getCamera();
	
	/**
	 * 获取比赛中的所有游戏对象
	 * @return
	 */
	public Map<Integer, GameObject> getGameObjects();
	
	/**
	 * 根据阵营查找player
	 * @param troop
	 * @return
	 */
	public IPlayer getPlayer(Integer troop);
	
	/**
	 * 根据帐号查找阵营
	 * @param account
	 * @return
	 */
	public Integer getTroopForAccount(String account);
	
	/**
	 * 返回主机状态，例如比赛处于准备 还是 开始
	 * @return
	 */
	public Integer getStatus();
}
