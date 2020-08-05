package org.cx.game.host;

public interface IHostManager {

	public IHost createHost(String hostName, String creatorAccount, Integer nop);
	
	/**
	 * 该方法加了同步锁
	 * @param playNo
	 * @return
	 */
	public IHost findByPlayNo(String playNo);
	
	/**
	 * 该方法只能用于只读的情况
	 * @param playNo
	 * @return
	 */
	public IHost get(String playNo);
	
	public String getPlayNoByCreator(String creator);
	
	public String getPlayNoByHostName(String hostName);
	
	public IHost joinGame(String playNo, String account);
	
	public void synCache(IHost host);
	
	public void removeHost(String playNo);
	
	public void unlock(String playNo);
	
	public void deleteLock(String playNo);
	
}
