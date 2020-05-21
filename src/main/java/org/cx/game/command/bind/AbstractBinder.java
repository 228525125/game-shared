package org.cx.game.command.bind;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBinder<T> implements IBinder<T> {
	
	@Override
	public Identification generateIdentification(T t) {
		// TODO Auto-generated method stub
		Identification id = new Identification(this, null);
		return id;
	}

}
