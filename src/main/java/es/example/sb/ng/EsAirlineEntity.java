package es.example.sb.ng;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="ESAIRLINE")
public class EsAirlineEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AIRID")
	private long airId;
	
	@Column(name="AIRNAME")
	private String airName;
	
	public enum FClass { bus, eco; }
	@Enumerated(EnumType.ORDINAL)
	@Column(name="airClass")
	private FClass airClass;
	
	public long getAirId() {
		return airId;
	}
	public void setAirId(long airId) {
		this.airId = airId;
	}
	public String getAirName() {
		return airName;
	}
	public void setAirName(String airName) {
		this.airName = airName;
	}
	public FClass getFClass() {
		return airClass;
	}
	public void setAirClass(FClass airClass) {
		this.airClass = airClass;
	}
	
	@Override
	public String toString() {
		return String.format("Airline: id: " + airId 
				+ "airName: " + airName 
				+ "airClass: " + airClass);
	}
	
}
