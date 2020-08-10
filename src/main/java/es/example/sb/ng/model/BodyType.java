package es.example.sb.ng.model;

import java.util.stream.Stream;

public enum BodyType {

	AVERAGE("A"), SLIM("S"), HEAVY("T"); // , ATHLETIC

	private String bodyType;

	private BodyType(String bType) {
		this.bodyType = bType;
	}

	public String getBodyType() {
		return bodyType;
	}
	
	public static BodyType decode(String bodyType) {
		return Stream.of(BodyType.values()).filter(bt -> bt.getBodyType().equals(bodyType)).findFirst()
				.orElse(null);
				//.orElseThrow(IllegalArgumentException::new);
	}

}
