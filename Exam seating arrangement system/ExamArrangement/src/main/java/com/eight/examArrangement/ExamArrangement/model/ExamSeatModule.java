package com.eight.examArrangement.ExamArrangement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExamSeatModule {

	private String classRoomNumber;
	private String benchNumber;
	private String seatNumber;
}
