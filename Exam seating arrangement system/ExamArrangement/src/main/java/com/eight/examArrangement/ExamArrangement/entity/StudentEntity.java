package com.eight.examArrangement.ExamArrangement.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long studentid;
	private String name;
	private String gender;
	private String rollNumber;
	private String section;
	private String branch;
	private String year;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "exam-seat-id",referencedColumnName = "examSeatid")
	private ExamSeatEntity examSeatEntity;
}
