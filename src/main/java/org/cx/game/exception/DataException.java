package org.cx.game.exception;

import org.cx.game.tools.I18n;

public class DataException extends RuntimeException {

	public DataException() {
		// TODO Auto-generated constructor stub
		super(I18n.getMessage("org.cx.game.data.exception.DataException"));
	}
	
	public DataException(String description) {
		// TODO Auto-generated constructor stub
		super(I18n.getMessage(description));
	}
}
