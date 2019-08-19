package pl.fis.artur.kasza.serializer;

import java.time.LocalDateTime;

import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class LocalDateTimeSerializer implements JsonbSerializer<LocalDateTime>{

	@Override
	public void serialize(LocalDateTime obj, JsonGenerator generator, SerializationContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
