package es.example.sb.ng;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="EMPLOYEE_ENTITY")
public class EsEmployeeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EMP")
	private long empId;
	
	@Column(name = "CH_NAME_EMP")
    private String empChineseName;
	
	@Column(name = "COVID19_STATUS_EMP")
	private boolean empCovid19Status;
			
	// simplest enum usage
	public enum Disability {
		NONE, PHYSICAL_DISABILITY;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DISABILITY_EMP")
	private Disability empDisability;
	
	@Column(name = "DOB_EMP")
	private Date empDob;
	
	public long getEmpId() {
		return empId;
	}
	
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	
	public String getEmpChineseName() {
		return empChineseName;
	}

	public void setEmpChineseName(String empChineseName) {
		this.empChineseName = empChineseName;
	}

	public boolean isEmpCovid19Status() {
		return empCovid19Status;
	}

	public void setEmpCovid19Status(boolean empCovid19Status) {
		this.empCovid19Status = empCovid19Status;
	}

	public Disability getEmpDisability() {
		return empDisability;
	}

	public void setEmpDisability(Disability empDisability) {
		this.empDisability = empDisability;
	}

	public Date getEmpDob() {
		return empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	@Override
	public String toString() {
		return String.format("Employee [empId=" + empId + 
				", empChineseName=" + empChineseName + 
				", empDisability=" + empDisability + 
				", empDob=" + empDob
				+ "]");
	}
	
}
