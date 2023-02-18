package com.csmtech.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Table(name = "registration_details")
@Entity
@Data
public class Details implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer registration_id;
	
	private String applicant_name;
	
	private String email_id;
	
	private String mobile_no;
	
	private String gender;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	
	private String image_path;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Provider.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id")
	private Provider provider;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Subscription.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "subscription_id")
	private Subscription subscription;
}
