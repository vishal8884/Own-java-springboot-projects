package com.eight.examArrangement.ExamArrangement.utils;

import org.springframework.stereotype.Service;

import com.eight.examArrangement.ExamArrangement.entity.ExamSeatEntity;
import com.eight.examArrangement.ExamArrangement.entity.StudentEntity;
import com.eight.examArrangement.ExamArrangement.model.Student;

@Service
public class StudentDTOParser {

	public StudentEntity convertStudentToStudentEntity(Student student) {
		return StudentEntity.builder()
				.name(student.getName())
				.gender(student.getGender())
				.rollNumber(student.getRollNumber())
				.section(student.getSection())
				.branch(student.getBranch())
				.year(student.getYear())
				.examSeatEntity(ExamSeatEntity.builder()
						.classRoomNumber(student.getExamSeat().getClassRoomNumber())
						.benchNumber(student.getExamSeat().getBenchNumber())
						.seatNumber(student.getExamSeat().getSeatNumber())
						.build())
				.build();
	}
}
