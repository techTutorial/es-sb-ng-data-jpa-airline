package es.example.sb.ng.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// catalog is applicable for mariadb and mysql > verified;
//@Table(name = "USER_ENTITY", catalog = "USER_SCHEMA2")
//@Table(name = "USER_SCHEMA2.USER_ENTITY") // not working
@Table(name="USER_ENTITY", schema="USER_SCHEMA2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsUserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private long userId;
	
	@Column(name = "NAME_USER")
	private String userName;
	
	@Column(name = "PASSWORD_USER")
	private char[] userPassword;
	
	@Column(name = "EMAIL_USER")
	private String userEmail;
	
	@Column(name = "TYPE_GENDER_USER")
	private int userGender;
	
	@Column(name = "AGREEMENT_USER")
	private boolean userAgreement;
	
	//@Autowired
	//List<EsEmployeeEntity> empList;
	
}
