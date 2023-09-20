package com.eight.examArrangement.ExamArrangement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {

	private String name;
	private String gender;
	private String rollNumber;
	private String section;
	private String branch;
	private String year;
	
	private ExamSeatModule examSeat;
}
