package com.example.training.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.training.model.Employees;
import com.example.training.service.EmployeeService;

@Controller
public class EmployeeController {

	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	// Demo
	@RequestMapping(value = { "/", "/index" })
	public String getIndex() {
		return "index";
	}
	// Listing all employee

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String listAllEmployee(Model model) {
		logger.info("Listing all employee ");
		Map<String, Object> attributes = this.employeeService.findAllEmp();
		model.addAllAttributes(attributes);
		return "employee-index";
	}
	// Displaying employee details

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
	public String DetailEmployee(Model model, @PathVariable("empId") Long empId) {
		logger.info("Displaying employee details >> empId: " + empId);
		Map<String, Object> attributes = this.employeeService.findEmp(empId);
		model.addAllAttributes(attributes);
		return "employee-detail";
	}

	// Create employee

	@RequestMapping(value = "employee", method = RequestMethod.POST)
	public String createEmployee(Model model, @Valid @ModelAttribute("empDto") Employees emp) {
		logger.info("Create employee id" + emp);
		this.employeeService.createEmployee(emp);
		return "redirect:/employee";
	}

	// Delete employee
	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
	public String deleteEmploee(@PathVariable("empId") Long empId) {
		logger.info("Delete employee id" + empId);
		this.employeeService.deleteEmployee(empId);
		return "redirect:/employee";

	}

	// Updating employee
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public String updateEmployee(@Valid @ModelAttribute("empDto") Employees emp) {
		logger.info("Updating employee " + emp);
		this.employeeService.updateEmployee(emp);
		return "redirect:/employee";
	}
}
