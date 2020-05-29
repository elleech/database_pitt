package infsci2710.finalproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "buy")
public class Buy {
	@Id
	@Column(name = "buy_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "totalPrice")
	private Double totalPrice;
	
	@Column(name = "orderDate")
	private Date orderDate;
	
	@Column(name = "payDate")
	private Date payDate;
	
	@Column(name = "deliverDate")
	private Date deliverDate;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salesperson_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Salesperson salesperson;
	
	//<add> this foreign key
	@OneToMany(mappedBy = "buy", fetch = FetchType.LAZY)
    private List<Cases> cases= new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Salesperson getSalesperson() {
		return salesperson;
	}

	public void setSalesperson(Salesperson salesperson) {
		this.salesperson = salesperson;
	}

	public List<Cases> getCases() {
		return cases;
	}

	public void setCases(List<Cases> cases) {
		this.cases = cases;
	}

	// getter method to retrieve the customer_id
	public Long getCustomer_id() {
		return customer.getId();
	}
	
	//getter method to get the customer's full name
	public String getCustomerName() {
		return customer.getFirstname()+" "+customer.getLastname();
	}

	//<add> getter method to get the customer's company
	public String getCustomerCompany() {
		return customer.getCompany();
	}
	
	// getter method to retrieve the product_id
	public Long getProduct_id() {
		return product.getId();
	}
	
	//getter method to get the product name
	public String getProductName() {
		return product.getProductname();
	}
	
	//getter method to retrieve the salesperson_id
	public Long getSalesperson_id() {
		return salesperson.getId();
	}
	
	//getter method to get the salesperson's full name
	public String getSalespersonName() {
		return salesperson.getFirstname()+" "+salesperson.getLastname();
	}

	@Override
	public String toString() {
		return "Buy [id=" + id + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate
				+ ", payDate=" + payDate + ", deliverDate=" + deliverDate + ", customer=" + customer + ", product="
				+ product + ", salesperson=" + salesperson + ", cases=" + cases + "]";
	}

}
