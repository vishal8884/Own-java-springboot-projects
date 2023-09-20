package com.eight.examArrangement.ExamArrangement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eight.examArrangement.ExamArrangement.entity.StudentEntity;
import com.eight.examArrangement.ExamArrangement.model.ExamSeatModule;
import com.eight.examArrangement.ExamArrangement.model.Student;
import com.eight.examArrangement.ExamArrangement.repository.StudentRepository;
import com.eight.examArrangement.ExamArrangement.utils.StudentDTOParser;

@Service
public class StudentDataInsertService {

	@Autowired
	private StudentDTOParser studentDtoParser;
	
	@Autowired
	private StudentRepository studentRepo;
	
	public void insertStudents(int cse,int ece,int mech) {
		System.out.println("cse :: "+cse+"    ece :: "+ece+"   mech :: "+mech);
		
		insertStudentsByBranchAndYear(cse, "CSE", "1");
		insertStudentsByBranchAndYear(cse, "CSE", "2");
		insertStudentsByBranchAndYear(cse, "CSE", "3");
		insertStudentsByBranchAndYear(cse, "CSE", "4");
		
		insertStudentsByBranchAndYear(ece, "ECE", "1");
		insertStudentsByBranchAndYear(ece, "ECE", "2");
		insertStudentsByBranchAndYear(ece, "ECE", "3");
		insertStudentsByBranchAndYear(ece, "ECE", "4");
		
		insertStudentsByBranchAndYear(mech, "MECH", "1");
		insertStudentsByBranchAndYear(mech, "MECH", "2");
		insertStudentsByBranchAndYear(mech, "MECH", "3");
		insertStudentsByBranchAndYear(mech, "MECH", "4");
	}
	
	//Total 5 sections
	public void insertStudentsByBranchAndYear(int num,String branch,String year) {
		List<StudentEntity> studentsEntityList = new ArrayList<>();
		
		for(int i=1;i<=num;i++) {
			Student student = Student.builder()
					.rollNumber(String.valueOf(i))
					.branch(branch)
					.year(year)
					.examSeat(ExamSeatModule.builder()
							.classRoomNumber("")
							.benchNumber("")
							.seatNumber("").build())
					.build();
			setGenderAndNameLogic(i, student);
			setSectionLogic(i, student);
			
			StudentEntity studentEntity = studentDtoParser.convertStudentToStudentEntity(student);
			studentsEntityList.add(studentEntity);
		}
		
		studentRepo.saveAll(studentsEntityList);
	}
	



	private void setSectionLogic(int i, Student student) {
		if(i<30) {
			student.setSection("A");
		} else if(i < 60) {
			student.setSection("B");
		} else if(i < 90) {
			student.setSection("C");
		} else if(i < 120) {
			student.setSection("D");
		} else if(i < 150) {
			student.setSection("E");
		} else {
			student.setSection("F");
		}
	}


	private void setGenderAndNameLogic(int i, Student student) {
		if(i%3 == 0) {
			student.setGender("female");
			student.setName("miss name_"+i);
		}
		else {
			student.setGender("male");
			student.setName("mr name_"+i);
		}
	}
}
