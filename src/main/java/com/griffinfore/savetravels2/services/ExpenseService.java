package com.griffinfore.savetravels2.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.griffinfore.savetravels2.models.Expense;
import com.griffinfore.savetravels2.repositories.ExpenseRepository;

@Service
public class ExpenseService {
//	Where the CRUD methods go
//	Wrapper classes for the Crudrepository methods
	
//	Autowired allows you to import the repo without the constructor
	
	@Autowired
	ExpenseRepository expenseRepo;

	//	Get All Expenses
	public ArrayList<Expense> getAllExpenses(){
		return expenseRepo.findAll();
	}
	
//	Create New Expense
	public Expense createNewExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
//	Find One Expense
	public Expense findOneExpense(Long Id) {
		return expenseRepo.findById(Id).orElse(null);
	}
	
//	Update One Expense
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
//	Delete One Expense
	public void deleteExpense(Long Id) {
		expenseRepo.deleteById(Id);
	}
}
