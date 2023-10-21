package com.domain.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "expense-report")
public class Expense {

	@Id
	@Column(name = "expense-id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String category;
	private Date date;
	private String comments;
	
	private long expenseAmount;

	
	private String emailId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)          
	@JoinColumn(name="person-id",referencedColumnName = "person-id") 
	private Person person;
}
