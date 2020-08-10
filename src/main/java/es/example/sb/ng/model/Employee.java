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

import com.mkyong.error.validator.ChName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_ENTITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
// public class Employee extends EsUserEntity {
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_EMP")
	private long empId;
	
	@Size(max=100)
	@Column(name = "FNAME_EMP", nullable = false)
	private String empFirstName;
	
	@Column(name = "LNAME_EMP")
	private String empLastName;
	
	@ChName
    @NotEmpty(message = "Employee Chinese Name is MANDATORY field")
	@Column(name = "CH_NAME_EMP")
    private String empChineseName;
	
	@Column(name = "COVID19_STATUS_EMP")
	private boolean empCovid19Status;
	
	@Column(name = "EMAIL_EMP")
	private String empEmailId;
	
	
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
	
	
	//@Column(name = "BODY_TYPE_EMP")
	//private BodyType empBodyType;
	// empSkinTone = VERY_FAIR, FAIR, WHEATISH, DARK, LIGHT
	// empDisability = NONE, PHYSICAL_DISABILITY
	
	
	// empDietLifeStyle = VEG, NON_VEG, OCCASIONALLY_NON_VEG, EGGETARIAN, VEGAN, JAIN
	// empDrinkLifeStyle = YES, NO, OCCASIONALLY
	// empSmokeLifeStyle = YES, NO, OCCASIONALLY
	
	
	@DecimalMin("500.00")
	@NotNull(message = "Initial deposite is MANDATORY") // Accepts any type.
	@Column(name = "WALLET_BALANCE_EMP")
    private BigDecimal empWalletBalance;
	
	@Column(name = "AGE_EMP")
	private int empAge;
	
	@Column(name = "DOB_EMP")
	private Date empDob;
	
	@Override
	public String toString() {
		return String.format("Employee [empId=" + empId + 
				", empFirstName=" + empFirstName + 
				", empLastName=" + empLastName + 
				", empChineseName=" + empChineseName + 
				", empGenderType=" + empGenderType + 
				", empEmailId=" + empEmailId +
				", empContactPrefType=" + empContactPrefType + 
				//", empBodyType=" + empBodyType + 
				", empWalletBalance=" + empWalletBalance + 
				", empAge=" + empAge + 
				", empDob=" + empDob
				+ "]");
	}
	
}
