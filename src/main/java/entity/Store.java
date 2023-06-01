package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stores")
public class Store implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7163604650437603396L;
	@Id
	@Column(name = "store_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "store_name", columnDefinition = "nvarchar(255)")
	private String name;
	@Embedded
	private Contact contact;
	@Embedded
	private Address address;

	public Store() {
	}

	public Store(int id) {
		super();
		this.id = id;
	}

	public Store(String name, Contact contact, Address address) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
	}

	public Store(int id, String name, Contact contact, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + "]";
	}

}
