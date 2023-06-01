package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1479924507846778466L;
	@Column(columnDefinition = "nvarchar(255)")
	private String street;
	@Column(columnDefinition = "nvarchar(50)")
	private String city;
	@Column(columnDefinition = "nvarchar(10)")
	private String state;
	@Column(columnDefinition = "nvarchar(5)", name = "zip_code")
	private int zipCode;

	public Address() {
	}

	public Address(String street, String city, String state, int zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}

}
