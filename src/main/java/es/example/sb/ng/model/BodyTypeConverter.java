package es.example.sb.ng.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class BodyTypeConverter implements AttributeConverter<BodyType, String> {

	@Override
	public String convertToDatabaseColumn(BodyType bodyType) {
		if (bodyType == null) {
			return null;
		}
		return bodyType.getBodyType();
	}

	@Override
	public BodyType convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}

		return Stream.of(BodyType.values()).filter(c -> c.getBodyType().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
