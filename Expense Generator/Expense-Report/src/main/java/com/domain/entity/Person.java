package com.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "person-id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long personId;
	private String name;
	private long income;
	private long age;
	private long monthlyMaxExpenseLimit;
	
	@Column(unique = true)
	private String emailId;
}
