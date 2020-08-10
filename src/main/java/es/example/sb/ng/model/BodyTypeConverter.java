package es.example.sb.ng.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class BodyTypeConverter implements AttributeConverter<BodyType, String> {

	@Override
	public String convertToDatabaseColumn(BodyType bodyType) {
		/*if (bodyType == null) {
			return null;
		}*/
		//return bodyType.getBodyType();
		// OR
		return Optional.ofNullable(bodyType).map(BodyType::getBodyType)
				.orElse(null);
	}

	@Override
	public BodyType convertToEntityAttribute(String code) {
		return BodyType.decode(code);
	}
	
}
