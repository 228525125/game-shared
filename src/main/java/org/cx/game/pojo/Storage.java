package org.cx.game.pojo;

import java.util.Set;

import lombok.Data;

@Data
public class Storage {

	private Long id;
	private String account;
	private Set<Item> items;
	private Set<Tactic> tactics;
	
	public Tactic getDefaultTactic() {
		for(Tactic tactic : tactics) {
			if(tactic.getSelected())
				return tactic;
		}
		return null;
	}
}
