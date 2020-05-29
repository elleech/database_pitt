package infsci2710.finalproject.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="casecomment")
public class Casecomment {
	@Id
	@Column(name = "casecomment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//<add> date
	//@Column(name = "date")
	//private Date date;
	
	@Column(name = "time")
	private Timestamp time;
	
	@Column(name = "comment")
	private String comment;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cases_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cases cases;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Timestamp gettime() {
		return time;
	}

	public void settime(Timestamp time) {
		this.time = time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Cases getCases() {
		return cases;
	}

	public void setCases(Cases cases) {
		this.cases = cases;
	}

	// getter method to retrieve the cases_id
	public Long getCases_id() {
		return cases.getId();
	}
	
	//getter method to get the cases summary
	public String getCasesSummary() {
		return cases.getSummary();
	}

	@Override
	public String toString() {
		return "Casecomment [id=" + id +  ", time=" + time + ", comment=" + comment
				+ ", cases=" + cases + "]";
	}

}
