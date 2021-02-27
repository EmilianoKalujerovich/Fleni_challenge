package ar.com.genomasoft.fenix.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



public class Address {

	private Employee employee;
	private String streetAddres;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String country;
   
    
    public Address() {
	}

    
    
    //@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	public Employee getEmployee() {
		return employee;
	}




	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	@Column(name = "STREETADDRES", nullable = false)
	public String getStreetAddres() {
		return streetAddres;
	}


	public void setStreetAddres(String streetAddres) {
		this.streetAddres = streetAddres;
	}

	@Column(name = "POSTALCODE", nullable = false)
	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "CITY", nullable = false)
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATEPROVINCE", nullable = false)
	public String getStateProvince() {
		return stateProvince;
	}


	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	@Column(name = "COUNTRY", nullable = false)
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
    
    
    
}
