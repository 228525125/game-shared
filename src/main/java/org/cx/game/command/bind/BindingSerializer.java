package org.cx.game.command.bind;

import java.io.IOException;

import org.cx.game.core.GameObject;
import org.cx.game.tools.Jackson;
import org.cx.game.tools.SpringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class BindingSerializer extends JsonSerializer<GameObject> {

	@Override
	public void serialize(GameObject obj, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		// TODO Auto-generated method stub
		Jackson jackson = SpringUtils.getBean("jackson");
		String json = jackson.toJson(BinderHelper.generateIdentification(obj));
		gen.writeString(json);
	}

}
