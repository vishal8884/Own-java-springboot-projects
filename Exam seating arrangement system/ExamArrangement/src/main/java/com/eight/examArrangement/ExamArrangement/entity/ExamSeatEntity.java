package com.eight.examArrangement.ExamArrangement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ExamSeat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamSeatEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long examSeatid;
	private String classRoomNumber;
	private String benchNumber;
	private String seatNumber;
	
	@OneToOne(mappedBy = "examSeatEntity")
	private StudentEntity studentEntity;
}
