package es.example.sb.ng.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_ENTITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_EMPLOYEE")
	private long empId;
	
	@Column(name = "FNAME_EMPLOYEE", nullable = false)
	@Size(max=100)
	private String empFirstName;
	
	@Column(name = "LNAME_EMPLOYEE")
	private String empLastName;
	
	@Column(name = "EMAIL_EMPLOYEE")
	private String empEmailId;
	
	@Override
	public String toString() {
		return String.format("Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName + ", empEmailId=" + empEmailId
				+ "]");
	}
	
}
