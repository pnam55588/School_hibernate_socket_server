package entity;

import java.io.Serializable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "staffs")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "staff_id")) })
public class Staff extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2131550540641443719L;
	@Column(columnDefinition = "tinyint")
	private byte active;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id", referencedColumnName = "staff_id")
	private Staff manager;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", referencedColumnName = "store_id")
	private Store store;

	public Staff() {
	}

	public Staff(int id) {
		super(id);
	}

	public Staff(String firstName, String lastName, Contact contact, byte active, Staff manager, Store store) {
		super(firstName, lastName, contact);
		this.active = active;
		this.manager = manager;
		this.store = store;
	}

	public Staff(int id, String firstName, String lastName, Contact contact, byte active, Staff manager, Store store) {
		super(id, firstName, lastName, contact);
		this.active = active;
		this.manager = manager;
		this.store = store;
	}

	@Override
	public String toString() {
		return super.toString() + " Staff [active=" + active + ", manager=" + manager + ", store=" + store + "]";
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	

}
