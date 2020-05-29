package infsci2710.finalproject.model;

import java.util.ArrayList;
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
@Table(name="cases")
public class Cases {
	@Id
	@Column(name = "cases_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Employee employee;
	
	//<delete> foreign key in product
	//@JsonIgnore
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "product_id",nullable = false)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	//private Product product;
	
	//<add> foreign key in buy
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buy_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Buy buy;
	
	@OneToMany(mappedBy = "cases", fetch = FetchType.LAZY)
    private List<Casecomment> casecomment= new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Buy getBuy() {
		return buy;
	}

	public void setBuy(Buy buy) {
		this.buy = buy;
	}

	public List<Casecomment> getCasecomment() {
		return casecomment;
	}

	public void setCasecomment(List<Casecomment> casecomment) {
		this.casecomment = casecomment;
	}

	//<add> getter method to retrieve the buy_id
	public Long getBuy_id() {
		return buy.getId();
	}
	
	//<add> getter method to get the product_id
	public Long getProduct_id() {
		return buy.getProduct_id();
	}
	
	//<add> getter method to get the product name
	public String getProductName() {
		return buy.getProductName();
	}
	
    //<add> getter method to get the customer_id
	public Long getCustomer_id() {
		return buy.getCustomer_id();
	}
	
    //<add> getter method to get the customer's full name
	public String getCustomerName() {
		return buy.getCustomerName();
	}
	
	//<add> getter method to get the customer's company
	public String getCustomerCompany() {
		return buy.getCustomerCompany();
	}
		
	//getter method to retrieve the employee_id
	public Long getEmployee_id() {
		return employee.getId();
	}
	
	//getter method to get the product name
	public String getEmployeeName() {
		return employee.getFirstname()+" "+employee.getLastname();
	}

	@Override
	public String toString() {
		return "Cases [id=" + id + ", summary=" + summary + ", description=" + description + ", status=" + status
				+ ", employee=" + employee + ", buy=" + buy + ", casecomment=" + casecomment + "]";
	}

}
