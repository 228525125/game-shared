package org.cx.game.utils;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class WithConnectCommand extends Command {

	//@NotNull
	private Connect connect;
}
