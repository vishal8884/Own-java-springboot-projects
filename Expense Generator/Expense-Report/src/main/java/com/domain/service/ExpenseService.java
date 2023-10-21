package com.domain.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.entity.Expense;
import com.domain.entity.Person;
import com.domain.model.ExpenseResponse;
import com.domain.repository.ExpenseRepository;
import com.domain.repository.PersonRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Autowired
	private PersonRepository personRepo;

	public ExpenseResponse validateAndSaveResponse(Expense expense) {
		Person person = personRepo.findByEmailId(expense.getEmailId());
		
		expense.setDate(new Date());
		expense.setPerson(person);
		
		ExpenseResponse validateIfExpenseExceedsMonthlyLimit = validateIfExpenseExceedsMonthlyLimit(expense, person);
		
	    expenseRepository.save(expense);
	    
	    return validateIfExpenseExceedsMonthlyLimit;
	}
	
	
	private ExpenseResponse validateIfExpenseExceedsMonthlyLimit(Expense expense,Person person) {
		String userResponsePopUp = "";
		String remainingExpenseMontlyLimit = "";
		String remaingExpenseIncomeLimit = "";
	    boolean is75Percent = false;
		
		long expenseTillNow = expenseRepository.fetchTotalExpenseSumByEmail(expense.getEmailId());
		long totalExpense = expenseTillNow + expense.getExpenseAmount();
		System.out.println("expenseTillNow :: "+expenseTillNow+"     totalExpense :: "+totalExpense);
		
		remainingExpenseMontlyLimit = String.valueOf(person.getMonthlyMaxExpenseLimit() - totalExpense);
		remaingExpenseIncomeLimit = String.valueOf(person.getIncome() - totalExpense);
		
		if(totalExpense > person.getMonthlyMaxExpenseLimit()) {
			System.out.println("Monthly max limit exceeded please take care");
			userResponsePopUp = "Monthly max limit exceeded please take care";
			is75Percent = true;
		}
		else if(totalExpense > person.getIncome()) {
			System.out.println("You have exceeded your total income this month take care");
			userResponsePopUp = "You have exceeded your total income this month take care";
			is75Percent = true;
		}
		else {
			userResponsePopUp = "You have not exceeded your limit yet!!";
			is75Percent = false; //TODO fix this logic later
		}
		
		return ExpenseResponse.builder()
				.comment(userResponsePopUp)
				.remainingExpenseMontlyLimit(remainingExpenseMontlyLimit)
				.remainingExpenseIncomeLimit(remaingExpenseIncomeLimit)
				.isIt75Percent(is75Percent)
				.build();
	}
	
	
}
