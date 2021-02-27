package ar.com.genomasoft.fenix.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import ar.com.genomasoft.jproject.core.entities.BaseClientAuditedEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * Persona
 * 
 * @author Emiliano Kalujerovich (kalujerovich77@hotmail.com)
 *
 */
@Entity

@Table(name = "USR_EMPLOYEE")
@Where(clause = "DELETED_TIME IS NULL")
@SQLDelete(sql = "UPDATE USR_EMPLOYEE SET DELETED_TIME = CURRENT_TIMESTAMP WHERE ID = ? AND VERSION = ?")
public class Employee extends BaseClientAuditedEntity {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private int salary;
	private int commissionPct;

	public Employee() {
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	@ApiModelProperty(value = "Clave Primaria de la Persona", required = false, position = 0)
	public Integer getId() {
		return super.id;
	}

	@Column(name = "FIRSTNAME", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LASTNAME", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EMAIL", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PHONENUMBER", nullable = false)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "HIREDATE", nullable = false)
	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String dateParam) {
		this.hireDate = dateParam;
	}

	@Column(name = "SALARY", nullable = false)
	public int getSalary() {
		return salary;
	}
 

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Column(name = "COMMISSIONPCT", nullable = false)
	public int getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(int commissionPct) {
		this.commissionPct = commissionPct;
	}




	
}