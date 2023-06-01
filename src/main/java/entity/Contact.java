package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5017658859805673213L;
	@Column(columnDefinition = "nvarchar(25)")
	private String phone;
	private String email;

	public Contact() {
	}

	public Contact(String phone, String email) {
		super();
		this.phone = phone;
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [phone=" + phone + ", email=" + email + "]";
	}

}
