package es.example.sb.ng.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.example.sb.ng.validator.ChName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_ENTITY")
@Data
@NoArgsConstructor
//@RequiredArgsConstructor // check > Pending
@AllArgsConstructor
// public class Employee extends EsUserEntity {
public class EsEmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_EMP")
	// Input Values, if long: 1, 2, 3..., Long: 1L, 2L, 3L...
	private long empId;
	
	@Column(name = "FNAME_EMP", nullable = false)
	private String empFirstName;
	
	@Column(name = "LNAME_EMP")
	private String empLastName;
	
	@ChName
	@Size(max=100)
    @NotEmpty(message = "Employee Chinese Name is MANDATORY field")
	@Column(name = "CH_NAME_EMP")
    private String empChineseName;
	
	@Column(name = "COVID19_STATUS_EMP")
	private boolean empCovid19Status;
	
	@Column(name = "EMAIL_EMP")
	private String empEmailId;
	
	
	// enum type mapping with JPA
	@Basic
	@Column(name = "TYPE_GENDER_EMP")
    private int empGenderType;
 
    @Transient
    private Gender gender;
 
    @PostLoad
    void fillTransient() {
        if (empGenderType > 0) {
            this.gender = Gender.of(empGenderType);
        }
    }
 
    @PrePersist
    void fillPersistent() {
        if (gender != null) {
            this.empGenderType = gender.getGender();
        }
    }
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_MARITAL_EMP")
	private MaritalStatus empMaritalStatus;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_PREF_CONTACT_EMP")
	private ContactPreference empContactPrefType;
	
	
	// https://www.baeldung.com/jpa-persisting-enums-in-jpa
	// blog suggestion > without @Enumerated > not working > Pending
	// AttributeConverter class is not being picked for below field > Pending
	@Enumerated(EnumType.STRING)
	@Column(name = "BODY_TYPE_EMP")
	private BodyType empBodyType;
	
	
	/*public enum SkinTone {
		VERY_FAIR, FAIR, WHEATISH, DARK, LIGHT;
	}
	private SkinTone empSkinTone;*/
	
	
	// simplest enum usage
	public enum Disability {
		NONE, PHYSICAL_DISABILITY;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "DISABILITY_EMP")
	private Disability empDisability;
	
	
	// empDietLifeStyle = VEG, NON_VEG, OCCASIONALLY_NON_VEG, EGGETARIAN, VEGAN, JAIN
	// empDrinkLifeStyle = YES, NO, OCCASIONALLY
	// empSmokeLifeStyle = YES, NO, OCCASIONALLY
	
	
	@DecimalMin("500.00")
	@Column(name = "WALLET_BALANCE_EMP")
    private BigDecimal empWalletBalance;
	
	@DecimalMin("18")
	@NotNull(message = "Above 18 (adult) is MANDATORY") // Accepts any type.
	@Column(name = "AGE_EMP")
	private int empAge;
	
	@Column(name = "DOB_EMP")
	private Date empDob;
	
	public EsEmployeeEntity(Long empId, String empFirstName, String empChineseName, BigDecimal empWalletBalance, int empAge) {
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empChineseName = empChineseName;
		this.empWalletBalance = empWalletBalance;
		this.empAge = empAge;
	}
	
	@Override
	public String toString() {
		return String.format("Employee [empId=" + empId + 
				", empFirstName=" + empFirstName + 
				", empLastName=" + empLastName + 
				", empChineseName=" + empChineseName + 
				", empGenderType=" + empGenderType + 
				", empEmailId=" + empEmailId +
				", empContactPrefType=" + empContactPrefType + 
				", empBodyType=" + empBodyType + 
				", empDisability=" + empDisability + 
				", empWalletBalance=" + empWalletBalance + 
				", empAge=" + empAge + 
				", empDob=" + empDob
				+ "]");
	}
	
}
