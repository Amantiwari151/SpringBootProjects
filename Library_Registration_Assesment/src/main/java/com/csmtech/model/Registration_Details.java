package com.csmtech.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Registration_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registration_id;
	
	private String applicant_name;
	
	private String email_id;
	
	private String mobile_no;
	
	private String gender;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	private String image_path;
	
	@ManyToOne(targetEntity = Subscription.class,cascade = CascadeType.ALL)
	@JoinColumn(name="subscriptionId")
	private Subscription subscription;
	
	@ManyToOne(targetEntity = Library.class,cascade = CascadeType.ALL)
	@JoinColumn(name="library_id")
	private Library library;
}
