package es.example.sb.ng.model;

public enum BodyType {

	AVERAGE("A"), SLIM("S"), HEAVY("T"); // , ATHLETIC

	private String bodyType;

	private BodyType(String bType) {
		this.bodyType = bType;
	}

	public String getBodyType() {
		return bodyType;
	}
	
}
