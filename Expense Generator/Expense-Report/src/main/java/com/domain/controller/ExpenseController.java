package com.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.entity.Expense;
import com.domain.entity.Person;
import com.domain.model.ExpenseResponse;
import com.domain.repository.PersonRepository;
import com.domain.service.ExpenseService;

@RestController
@RequestMapping("/expense")
@CrossOrigin
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private PersonRepository personRepo;

	@PostMapping("/save")
	public ResponseEntity<ExpenseResponse> saveExpenseDetails(@RequestBody Expense expense){
		ExpenseResponse response = null;
		try {
			response = expenseService.validateAndSaveResponse(expense);
		} catch (Exception e) {
			ResponseEntity.internalServerError().body(e.getMessage());
		}
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("/person/save")
	public ResponseEntity<String> saveIncome(@RequestBody Person person){
		try {
		    personRepo.save(person);
		} catch (Exception e) {
			ResponseEntity.internalServerError().body(e.getMessage());
		}
		return ResponseEntity.ok().body("Saved expense details successfully");
	}
	
	//TODO when user clicks on generate report it should give pie chart of expense %'s
}
