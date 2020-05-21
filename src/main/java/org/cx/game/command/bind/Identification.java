package org.cx.game.command.bind;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Identification implements IIdentification {

	@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS)
	private IBinder<?> binder = null;
	private Object identify = null;
}
