package org.cx.game.pojo;

import java.util.Set;

import lombok.Data;

@Data
public class Level {

	private Long id;
	private String name;
	private Integer mapId;
	private Set<Tactic> tactics;
	
	public Tactic getDefaultTactic() {
		for(Tactic tactic : tactics) {
			if(tactic.getSelected())
				return tactic;
		}
		return null;
	}

}
