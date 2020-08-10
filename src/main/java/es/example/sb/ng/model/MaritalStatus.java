package es.example.sb.ng.model;

public enum MaritalStatus {

	SINGLE("S"), MARRIED("M"), DIVORCED("D");

	private String shortName;

	private MaritalStatus(String shortName) {
		this.shortName = shortName;
	}

	public String getShortName() {
		return shortName;
	}

	public static MaritalStatus fromShortName(String shortName) {
		switch (shortName) {
		case "MO":
			return MaritalStatus.SINGLE;

		case "OF":
			return MaritalStatus.MARRIED;

		case "HO":
			return MaritalStatus.DIVORCED;

		default:
			throw new IllegalArgumentException("ShortName [" + shortName + "] not supported.");
		}
	}

}
