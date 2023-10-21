package com.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpenseResponse {

	private String comment;
	private String remainingExpenseMontlyLimit;
	private String remainingExpenseIncomeLimit;
	
	private boolean isIt75Percent;
}
