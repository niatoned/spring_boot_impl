package com.emonics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.emonics.beans.Contact;
import com.emonics.dao.ContactDao;

@Controller
public class ContactController {
	@Autowired
	private ContactDao contactDao;
	
	@GetMapping("/")
	public String listContact(Model model) {
		model.addAttribute("contactList", contactDao.list());
		return "contactList";
	}
	
	@GetMapping("/newContact")
	public String newContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "contactForm";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact) {
		contactDao.saveOrUpdate(contact);
		return "redirect:/";
	}
	
	@GetMapping("/editContact")
	public String editContact(Integer id, Model model) {
		model.addAttribute("contact", contactDao.get(id));
		return "contactForm";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(Integer id) {
		contactDao.delete(id);
		return "redirect:/";
	}
}
