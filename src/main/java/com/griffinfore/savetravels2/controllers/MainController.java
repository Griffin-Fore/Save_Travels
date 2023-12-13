package com.griffinfore.savetravels2.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.griffinfore.savetravels2.models.Expense;
import com.griffinfore.savetravels2.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
//	If it isn't spelled right, it won't import
//	Bring the service into the controller
	@Autowired
	public ExpenseService expenseService;

//	All expenses and expense form route
	@GetMapping("/")
//	ModelAttribute must be included when used in the jsp
//	ModelAttribute is case sensitive
	public String mainPage(@ModelAttribute("Expenses") Expense expense, Model model) {
		ArrayList<Expense> allExpenses = expenseService.getAllExpenses();
		model.addAttribute("allExpenses", allExpenses);
		return "AllExpenses.jsp";
	}

//	Create expense route
	@PostMapping("/expense/new")
//	Don't name the modelAttribute the same as the model
//	Must match the modelattribute from the form
	public String createExpense(@Valid @ModelAttribute("Expenses") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "AllExpenses.jsp";
		}
		expenseService.createNewExpense(expense);
		return "redirect:/";
	}

//	Edit expense form
//	Use Model model to attach the object to the form
	@RequestMapping("/expense/edit/{id}")
//	ModelAttributes takes the information from the form
	public String editExpensePage(@PathVariable("id") Long id, @ModelAttribute("editExpense") Expense expense, Model model) {
//		the model.adddAttribute prePopulates the form
		Expense oneExpense = expenseService.findOneExpense(id);
		model.addAttribute("oneExpense", oneExpense);
		return "EditExpense.jsp";
	}

//	How does the model know to prepopulate the form?
//	How does the form get the model's information?
//	Edit expense process route
	@RequestMapping(value="/expense/edit/process/{id}", method=RequestMethod.PUT)
	public String editExpenseMethod( @PathVariable("id") Long id, @Valid @ModelAttribute("editExpense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			Expense oneExpense = expenseService.findOneExpense(id);
			model.addAttribute("oneExpense", oneExpense);
			 return "EditExpense.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/";
	}

//	View one expense route
	@GetMapping("/one/expense/{id}")
	public String showOneExpense( @PathVariable("id") Long id, RedirectAttributes redirectAttributes, Model model) {
		Expense oneExpense = expenseService.findOneExpense(id);
		if(oneExpense==null) {
			return "redirect:/";
		}
		model.addAttribute("expense", oneExpense);
		return "OneExpense.jsp";
	}

//	Delete expense route
	@RequestMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
}