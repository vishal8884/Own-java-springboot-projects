package com.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.domain.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

	public List<Expense> findByEmailId(String emailId);
	
	@Query(nativeQuery = true,value = "SELECT SUM(expense_amount)\r\n"
			+ "FROM `expense-report`\r\n"
			+ "WHERE email_id = ?1")
	public long fetchTotalExpenseSumByEmail(String EmailId);
}
