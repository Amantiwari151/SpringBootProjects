package com.csmtech.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "subscription_master")
@Entity
@Data
public class Subscription implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subscription_id;
	
	private String subscription_type;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Provider.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id")
	private Provider provider;
	
	private Double fees;
}
