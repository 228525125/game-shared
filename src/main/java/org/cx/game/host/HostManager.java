package org.cx.game.host;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;


public abstract class HostManager implements IHostManager {

	protected Map<String, Lock> locks = new HashMap<String, Lock>();
	protected Map<String, IHost> hosts = new HashMap<String, IHost>();	
	
	protected IHostService hostService;
	
	/**
	 * 创建游戏(隐含注册)
	 * @param hostName 主机名，不是唯一ID
	 * @param creatorAccount 创建主机的帐号
	 * @param mapId 地图
	 * @return
	 */
	@Override
	public abstract IHost createHost(String hostName, String creatorAccount, Integer nop);
	
	/**
	 * 
	 * 加入游戏
	 * @param playNo 游戏唯一编号
	 * @param account 加入的帐号
	 */
	@Override
	public abstract IHost joinGame(String playNo, String account);
	
	@Override
	public IHost findByPlayNo(String playNo) {
		Lock lock = locks.get(playNo);
		lock.lock();
		IHost host = hostService.findByPlayNo(playNo);
		hosts.put(playNo, host);
		return host;
	}

	@Override
	public IHost get(String playNo) {
		// TODO Auto-generated method stub
		return hosts.get(playNo);
	}

	/**
	 * 通过帐号查找游戏编号
	 * @param account
	 * @return 如果该帐号正处于游戏中的话，则返回PlayNo，否则返回null
	 */
	@Override
	public String getPlayNoByCreator(String account) {
		// TODO Auto-generated method stub
		String playNo = hostService.findPlayNoByCreator(account);
		
		if(hostIsExist(playNo))
			return playNo;
		else
			return null;
	}

	@Override
	public String getPlayNoByHostName(String hostName) {
		// TODO Auto-generated method stub
		return hostService.findPlayNoByHostName(hostName);
	}

	@Override
	public void synCache(IHost host) {
		// TODO Auto-generated method stub
		hostService.cache(host);
		Lock lock = locks.get(host.getPlayNo());
		lock.unlock();
		hosts.put(host.getPlayNo(), null);
	}
	
	@Override
	public void removeHost(String playNo) {
		// TODO Auto-generated method stub
		IHost host = findByPlayNo(playNo);
		hostService.removeHostName(host);
		hostService.removeHostCreator(host);
		hostService.remove(playNo);
		hosts.remove(playNo);
		unlock(playNo);
		deleteLock(playNo);
	}
	
	@Override
	public void unlock(String playNo) {
		Lock lock = locks.get(playNo);
		if(null!=lock) lock.unlock();
	}
	
	@Override
	public void deleteLock(String playNo) {
		locks.put(playNo, null);
	}
	
	/**
	 * 判断主机是否存在，这里只是简单的判断，真实环境下要复杂得多
	 * @param playNo 
	 * @return
	 */
	private Boolean hostIsExist(String playNo) {
		Boolean ret = null!=findByPlayNo(playNo) ? true : false;
		unlock(playNo);
		return ret;
	}

}
