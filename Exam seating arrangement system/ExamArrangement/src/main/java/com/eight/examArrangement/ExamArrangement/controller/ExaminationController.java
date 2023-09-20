package com.eight.examArrangement.ExamArrangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eight.examArrangement.ExamArrangement.service.StudentDataInsertService;

@RestController
@RequestMapping("/api/v1")
public class ExaminationController {
	
	@Autowired
	private StudentDataInsertService studentDataInsertService;

	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("Working");
	}
	
	//Temp
	//http://localhost:8080/api/v1/insertStudents/temp?cse=198&ece=165&mech=150
	@GetMapping("/insertStudents/temp")
	public ResponseEntity<String> insertTempStudents(@RequestParam("CSE") int cse,@RequestParam("ECE") int ece,@RequestParam("MECH") int mech) {
		try {
			studentDataInsertService.insertStudents(cse,ece,mech);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("insertTempStudents failed :: "+e.getLocalizedMessage());
		}
		
		return ResponseEntity.ok("Working");
	}

}
