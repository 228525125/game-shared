package org.cx.game.observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Observable extends java.util.Observable implements IObservable, Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Observer> observerList = new ArrayList<Observer>();

	public Observable() {
		// TODO Auto-generated constructor stub
		observerList.add(new JsonObserver());
	}
	
	@Override
	public void notifyObservers(Object arg) {
		// TODO Auto-generated method stub
		super.deleteObservers();
		for(Observer ob : observerList) addObserver(ob); //每次缓存后Observer会被清空；
		super.setChanged();
		super.notifyObservers(arg);
	}
}
