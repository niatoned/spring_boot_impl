package com.emonics.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emonics.beans.Student;

@Controller
public class StudentController {
@GetMapping(value="/student")
public String studentForm(Model model) {
	model.addAttribute("command", new Student());
	return "student";
}
@PostMapping(value="/addStudent")
public String addStudent(@Valid @ModelAttribute("command") Student student, Errors errors, Model model) {
	if(errors.hasErrors()) {
		return "student";
	}
	
	System.out.println("Student values: "
			+ student.getName() + " / "
			+ student.getAge()
			+ " / " + student.getId());
	model.addAttribute("id", student.getId());
	model.addAttribute("name", student.getName());
	model.addAttribute("age", student.getAge());
	return "resultingStudent";
	
}
}
