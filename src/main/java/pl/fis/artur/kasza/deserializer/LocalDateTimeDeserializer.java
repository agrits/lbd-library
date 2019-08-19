package pl.fis.artur.kasza.deserializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;

public class LocalDateTimeDeserializer implements JsonbDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
		// TODO Auto-generated method stub
		return null;
	}

}
