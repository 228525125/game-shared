package org.cx.game.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ItemType {

	private Long id;
	private Integer itemId;
	private String name;
	private Integer type;         //Character:1 ,Skill:2, Spell:3, Consumable:4, Material:5
	private Integer quality;      //Common普通:1, Uncommon非凡:2, Rare罕见:3, Epic史诗:4, Legendary传奇:5, Artifact艺术品:6
	private String description;   //描述
	private Integer buyPrice;     //买入价格
	private Integer sellPrice;    //卖出价格
	private String spriteName;    //精灵名称
}
