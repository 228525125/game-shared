package org.cx.game.core;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import org.cx.game.command.bind.BindingSerializer;
import org.cx.game.command.bind.IBinding;
import org.cx.game.host.IHost;
import org.cx.game.tools.SpringUtils;
import org.cx.game.tools.Util;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 所有游戏中的对象都应该继承自该对象
 * @author admin
 *
 */
public class GameObject implements IBinding, Serializable {

	private static final long serialVersionUID = 1L;

	@JsonSerialize(using=BindingSerializer.class)
	private GameObject bid = null;
	
	private Integer pid = 0;
	
	@JsonIgnore
	private IHost host = null;
	
	public void setHost(IHost host) {
		this.host = host;
		host.getGameObjects().put(getPid(), this);
	}
	
	public IHost getHost() {
		return host;
	}
	
	public Object getBid() {
		// TODO Auto-generated method stub
		return this;
	}
	
	public Integer getPid() {
		if(0==pid || null==pid) pid = Util.newCount();         //每场比赛动态生成的唯一标识
		return pid;
	}
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public String getOtype() {
		return this.getClass().getName();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getPid().intValue();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof GameObject) {
			GameObject go = (GameObject) obj;
			return go.getPid().equals(pid);
		}
		return false;
	}
	
	/*public static String getConfigure(String name) {
		Properties prop = new Properties();
		ClassPathResource resource = new ClassPathResource("gameobject.properties");
		try {
			prop.load(resource.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = prop.getProperty(name);
		return path;
	}*/

}
