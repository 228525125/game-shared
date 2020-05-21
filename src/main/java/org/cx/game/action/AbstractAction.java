package org.cx.game.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Vector;

import org.cx.game.intercepter.IIntercepter;
import org.cx.game.observer.Observable;
import org.cx.game.observer.IObservable;
import org.cx.game.rule.RuleBuilder;
import org.cx.game.rule.RuleGroup;
import org.cx.game.tools.ObserverBuilder;
import org.cx.game.tools.SpringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class AbstractAction implements IAction, Serializable {

	private Object owner;
	
	@JsonIgnore
	private IObservable observable = new Observable();
	
	@JsonIgnore
	private Map<String,List<IIntercepter>> intercepterList = new HashMap<String,List<IIntercepter>>();
	
	@JsonIgnore
	private List<IIntercepter> intercepterAppendList = new ArrayList<IIntercepter>();
	
	@JsonIgnore
	private List<IIntercepter> intercepterDeleteList = new ArrayList<IIntercepter>();
	
	@JsonIgnore
	private Map<String,Object> actionResultMap = new HashMap<String,Object>();

	public AbstractAction() {
		// TODO Auto-generated constructor stub
		//Observer observer = SpringUtils.getBean("jsonObserver");
		//observable.addObserver(observer);
		/*RuleBuilder builder = SpringUtils.getBean("ruleBuilder");
		RuleGroup rules = builder.getInstance(RuleGroup.RuleGroup_System);
		rules.bindingRule(this);*/
	}
	
	@Override
	public void setOwner(Object object) {
		// TODO Auto-generated method stub
		this.owner = object;
	}
	
	public Object getOwner() {
		return owner;
	}
	
	@Override
	public void action(Object... objects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addIntercepter(IIntercepter intercepter) {
		// TODO Auto-generated method stub
		this.intercepterAppendList.add(intercepter);
	}

	@Override
	public void deleteIntercepter(IIntercepter intercepter) {
		// TODO Auto-generated method stub
		this.intercepterDeleteList.add(intercepter);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		intercepterList.clear();
	}

	@Override
	public Map<String,List<IIntercepter>> getIntercepterList() {
		// TODO Auto-generated method stub
		addIntercepter();
		deleteIntercepter();
		return intercepterList;
	}
	
	/**
	 * 将缓存里的拦截器，真正添加到被拦截对象
	 */
	private void addIntercepter() {
		for(IIntercepter intercepter : this.intercepterAppendList){
			List<IIntercepter> intercepters = intercepterList.get(intercepter.getIntercepterMethod());
			if(null!=intercepters){
				intercepters.add(intercepter);
			}else{
				intercepters = new ArrayList<IIntercepter>();
				intercepters.add(intercepter);
				intercepterList.put(intercepter.getIntercepterMethod(), intercepters);
			}
		}
		
		this.intercepterAppendList.clear();
	}
	
	/**
	 * 将缓存的拦截器，真正删除
	 */
	private void deleteIntercepter() {
		for(IIntercepter intercepter : this.intercepterDeleteList){
			List<IIntercepter> intercepters = intercepterList.get(intercepter.getIntercepterMethod());
			intercepters.remove(intercepter);
		}
		
		this.intercepterDeleteList.clear();
	}
	
	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observable.addObserver(o);
	}
	
	@Override
	public int countObservers() {
		// TODO Auto-generated method stub
		return observable.countObservers();
	}
	
	@Override
	public void deleteObserver(Observer o) {
		// TODO Auto-generated method stub
		observable.deleteObserver(o);
	}
	
	@Override
	public void deleteObservers() {
		// TODO Auto-generated method stub
		observable.deleteObservers();
	}
	
	@Override
	public boolean hasChanged() {
		// TODO Auto-generated method stub
		return observable.hasChanged();
	}
	
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		observable.notifyObservers();
	}
	
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		observable.notifyObservers(arg);
	}
}
