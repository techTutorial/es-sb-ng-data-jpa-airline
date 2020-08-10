package es.example.sb.ng.model;

public enum ContactPreference {
	
	MO("MOBILE"), OF("OFFICE"), HO("HOME"), ME("MESSAGE"), EM("EMAIL");

	private String name;

	private ContactPreference(String name) {
		this.name = name;
	}

	public String getCompleteName() {
		return name;
	}

	public static ContactPreference fromShortName(String name) {
		switch (name) {
		case "MOBILE":
			return ContactPreference.MO;

		case "OFFICE":
			return ContactPreference.OF;

		case "HOME":
			return ContactPreference.HO;

		case "MESSAGE":
			return ContactPreference.ME;

		case "EMAIL":
			return ContactPreference.EM;

		default:
			throw new IllegalArgumentException("FullName [" + name + "] not supported.");
		}
	}
	
}
