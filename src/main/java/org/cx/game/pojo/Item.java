package org.cx.game.pojo;

import lombok.Data;

@Data
public class Item {

	private Long id;
	private ItemType type;
	private Integer quantity;        //数量
}
