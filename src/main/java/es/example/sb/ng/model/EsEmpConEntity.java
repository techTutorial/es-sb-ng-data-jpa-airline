package es.example.sb.ng.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ES_EMPLOYEE_CONTRACT", schema="USER_SCHEMA2")
@PrimaryKeyJoinColumn(name = "ID_ECON")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsEmpConEntity extends EsEmployeeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Id member variable is not required; alone existence is not possible
	// Contractual employee member variables are always part of employee object;
	
	@Column(name="EDATE_ECON")
	private String cEmpEndDate;
	
}
