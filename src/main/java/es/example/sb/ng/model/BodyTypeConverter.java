package es.example.sb.ng.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.Optional;
import java.util.stream.Stream;

// below class is not being used, checked by commenting whole class;
@Converter(autoApply = true) // exception is thrown without autoApply
public class BodyTypeConverter implements AttributeConverter<BodyType, String> {

	@Override
	public String convertToDatabaseColumn(BodyType bodyType) {
		//if (bodyType == null) {
			//return null;
		//}
		//return bodyType.getBodyType();
		// OR
		return Optional.ofNullable(bodyType).map(BodyType::getBodyType)
				.orElse(null);
	}

	@Override
	public BodyType convertToEntityAttribute(String bodyType) {
		return Stream.of(BodyType.values()).filter(bt -> bt.getBodyType().equals(bodyType)).findFirst()
				.orElse(null);
	}
	
}
