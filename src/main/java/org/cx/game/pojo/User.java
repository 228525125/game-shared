package org.cx.game.pojo;

import lombok.Data;

@Data
public class User {

	private Long id;
	private String account;
	private String password;
	private String name;
}
