package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7245759460704242525L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(columnDefinition = "nvarchar(50)", name = "first_name", nullable = false)
	protected String firstName;
	@Column(columnDefinition = "nvarchar(50)", name = "last_name")
	protected String lastName;
	@Embedded
	protected Contact contact;

	public Person() {
	}

	public Person(int id) {
		super();
		this.id = id;
	}

	public Person(String firstName, String lastName, Contact contact) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
	}

	public Person(int id, String firstName, String lastName, Contact contact) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact
				+ "]";
	}

}
