package entity;

import java.io.Serializable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "customer_id")) })
public class Customer extends Person implements Serializable, Comparable<Customer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1394084163041588206L;
	@Embedded
	private Address address;
	
	public Customer() {
	}

	public Customer(int id) {
		super(id);
	}

	public Customer(String firstName, String lastName, Contact contact, Address address) {
		super(firstName, lastName, contact);
		this.address = address;
	}

	public Customer(int id, String firstName, String lastName, Contact contact, Address address) {
		super(id, firstName, lastName, contact);
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return super.toString() + " Customer [address=" + address + "]";
	}

	@Override
	public int compareTo(Customer o) {
		return this.getFirstName().compareToIgnoreCase(o.getFirstName());
	}

}
