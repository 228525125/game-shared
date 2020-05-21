package org.cx.game.pojo;

import java.util.Set;

import lombok.Data;

@Data
public class Tactic {
	
	private Long id;
	private Set<ItemType> chesses;
	private Boolean selected;              // 默认战术
}
