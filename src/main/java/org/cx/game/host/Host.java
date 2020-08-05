package org.cx.game.host;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cx.game.core.GameObject;
import org.cx.game.tools.JsonHelper;
import org.cx.game.tools.SpringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Host extends GameObject implements IHost {

	public final static Integer Status_Prepare = 1;
	public final static Integer Status_Ready = 2;
	public final static Integer Status_Start = 3;
	public final static Integer Status_CharacterCreated = 4;
	
	private String playNo = null;
	private String name = null;
	private Integer nop = null;        //参与人数
	private String creator = null;
	private Integer status = Status_Prepare;
	
	@JsonIgnore
	private Camera camera = new Camera();
	
	@JsonIgnore
	private List<IPlayer> playerList = new ArrayList<IPlayer>();
	
	@JsonIgnore
	private Map<Integer, GameObject> gameObjects = new HashMap<Integer, GameObject>();
	
	@JsonIgnore
	private Map<Integer, IPlayer> troopPlayerMap = new HashMap<Integer, IPlayer>();
	
	@JsonIgnore
	private Map<String, Integer> accountTroopMap = new HashMap<String, Integer>();
	
	@JsonIgnore
	private Map<Integer, Integer> troopStatusMap = new HashMap<Integer, Integer>();

	public Host(String name, String playNo, String creator, Integer nop) {
		// TODO Auto-generated constructor stub
		super();
		setHost(this);
		
		this.name = name;
		this.nop = nop;
		this.playNo = playNo;
		this.creator = creator;
		
		for(int i=1; i<=nop; i++)  
			this.troopPlayerMap.put(i, null);
		
		setStatus(Status_Prepare);
	}
	
	/**
	 * 加入游戏主机
	 * @param account 玩家帐号
	 */
	public void playerJoinGame(IPlayer player) {
		this.playerList.add(player);
		this.troopPlayerMap.put(player.getTroop(), player);
		this.accountTroopMap.put(player.getName(), player.getTroop());
		this.troopStatusMap.put(player.getTroop(), Status_Ready);
		
		if(isStatus(Status_Ready)) setStatus(Status_Ready);
	}
	
	/**
	 * 玩家退出游戏主机
	 * @param troop 游戏中的编号
	 */
	public void playerQuitGame(String account) {
		Integer troop = getTroopForAccount(account);
		IPlayer player = getPlayer(troop);
		
		this.troopPlayerMap.put(troop, null);
		this.accountTroopMap.remove(account);
		this.playerList.remove(player);
	}
	
	/**
	 * 返回一个还没有被占用的阵营
	 * @return
	 */
	@JsonIgnore
	public Integer getUsableTroop() {
		// TODO Auto-generated method stub
		for(Integer key : this.troopPlayerMap.keySet()) {
			if(null==this.troopPlayerMap.get(key)) 
				return key;
		}
		return null;
	}
	
	/**
	 * 修改玩家阵营
	 * @param troop 阵营编号
	 * @param player
	 */
	public void setTroopOfPlayer(String account, Integer troop) {
		Integer tp = getTroopForAccount(account);
		if(null!=tp){
			IPlayer player =this.troopPlayerMap.get(tp);
			this.troopPlayerMap.remove(tp);
			player.setTroop(troop);
			
			this.troopPlayerMap.put(troop, player);
			this.accountTroopMap.put(account, troop);
		}
	}
	
	@Override
	public IPlayer getPlayer(Integer troop) {
		// TODO Auto-generated method stub
		return this.troopPlayerMap.get(troop);
	}

	@Override
	public Integer getTroopForAccount(String account) {
		// TODO Auto-generated method stub
		return this.accountTroopMap.get(account);
	}
	
	protected Boolean isStatus(Integer status) {
		Boolean ret = true;
		
		List<IPlayer> playerList = getPlayerList();
		for(IPlayer player : playerList){
			if(!status.equals(this.troopStatusMap.get(player.getTroop()))){
				ret = false;
				break;
			}
		}
		
		return ret;
	}
	
	public <T> List<T> findAllByType(Class<T> cls){
		List<T> list = new ArrayList<T>();
		for(GameObject go : getGameObjects().values()) {
			if(go.getClass().equals(cls))
				list.add((T) go);
		}
		return list;
	}
	
	public GameObject create(String cls, String json) {
		try {
			Class clz = Class.forName(cls);
			JsonHelper helper = SpringUtils.getBean("jsonHelper");
			GameObject go = (GameObject) helper.parseObject(json, clz);
			getGameObjects().put(go.getPid(), go);
			return go;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
