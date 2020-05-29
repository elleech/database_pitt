package infsci2710.finalproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "productname")
	private String productname;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private Double price;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Buy> buy= new ArrayList<>();
	
	//<delete> this foreign key
	//@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    //private List<Cases> cases= new ArrayList<>();
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Resolution> resolution= new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Buy> getBuy() {
		return buy;
	}

	public void setBuy(List<Buy> buy) {
		this.buy = buy;
	}

	public List<Resolution> getResolution() {
		return resolution;
	}

	public void setResolution(List<Resolution> resolution) {
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", description=" + description + ", price="
				+ price + ", buy=" + buy + ", resolution=" + resolution + "]";
	}

}
