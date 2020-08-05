package org.cx.game.host;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface IHostService {

	public IHost cache(IHost host);
	
	public String cachePlayNoByCreator(IHost host);
	
	public String cachePlayNoHostName(IHost host);
	
	public IHost findByPlayNo(String playNo);
	
	public String findPlayNoByCreator(String account);
	
	public String findPlayNoByHostName(String hostName);
	
	public void remove(String playNo);
		
	public void removeHostName(IHost host);
	
	public void removeHostCreator(IHost host);
}
