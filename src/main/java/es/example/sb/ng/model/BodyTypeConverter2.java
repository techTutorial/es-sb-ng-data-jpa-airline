package es.example.sb.ng.model;

import java.util.stream.Stream;

import org.springframework.core.convert.converter.Converter;

// below class is not being used, checked by commenting whole class;
@BodyTypeRequestConverter
public class BodyTypeConverter2 implements Converter<String, BodyType> {

	@Override
	public BodyType convert(String bodyType) {
		return Stream.of(BodyType.values()).filter(bt -> bt.getBodyType().equals(bodyType)).findFirst()
				.orElse(null);
				// .orElseThrow(IllegalArgumentException::new);
	}
	
}
