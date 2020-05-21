package org.cx.game.utils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Command {
	
	@NotNull
	@NotBlank
	private String command;
	
}
