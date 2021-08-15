package com.cz.ci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cz.ci.model.Contact;
import com.cz.ci.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listContacts",contactService.getAllContacts());
		return "index";
	}
	
	@GetMapping("/showNewContactForm")
	public String showNewContactForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact",contact);
		return "new_contact";
	}
	
	//Update contact will also mark contact as active we have selected inactive contact for updates
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact ) {
		contactService.saveContact(contact);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Contact contact = contactService.getContactById(id);
		model.addAttribute("contact",contact);
		return "update_contact";
	}
	
	//This will mark contact as inactive
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable(value = "id") long id, Model model) {
		this.contactService.deleteContactById(id);
		return "redirect:/";
	}
	
}
