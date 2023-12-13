package com.griffinfore.savetravels2.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.griffinfore.savetravels2.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	ArrayList<Expense> findAll();
}
