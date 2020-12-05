package es.example.sb.ng;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EsAirline")
public class EsAirlineEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//enum Class { business, economy };
	
	//enum Status { booked, waiting, empty; }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="airId")
	private long airId;
	
	@Column(name="airName")
	private String airName;
	
	/*@Column(name="airSource")
	private String airSource; // from;
	
	@Column(name="airDest")
	private String airDest; // to;
	
	@Column(name="airClass")
	@Enumerated(EnumType.ORDINAL)
	private Class airClass;
	
	@Column(name="airStatus")
	@Enumerated(EnumType.STRING)
	private Status airStatus;
	
	@Column(name="airTravelDate")
	private Date airTravelDate;*/

	
	
	
	@Override
	public String toString() {
		return String.format("Employee [airId=" + airId + 
				", airName=" + airName + "]");
	}
	/*@Override
	public String toString() {
		return String.format("Airline: %d, %s, %s, %s, %s",
				airId, airName, airSource, airDest, airTravelDate);
	}*/

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

}
