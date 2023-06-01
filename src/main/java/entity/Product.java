package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2324062314018289099L;
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "product_name", columnDefinition = "nvarchar(255)")
	private String name;
	@Column(name = "model_year", columnDefinition = "smallint")
	private int modelYear;
	@Column(name = "list_price", columnDefinition = "decimal(10,2)")
	private double listPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
	private Brand brand;
	
	public Product() {
	}

	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(String name, int modelYear, double listPrice) {
		super();
		this.name = name;
		this.modelYear = modelYear;
		this.listPrice = listPrice;
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

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", modelYear=" + modelYear + ", listPrice=" + listPrice
				+ ", category=" + category.getId() + ", brand=" + brand.getId() + "]";
	}

}

