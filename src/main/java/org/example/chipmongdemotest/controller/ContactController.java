package org.example.chipmongdemotest.controller;

import org.example.chipmongdemotest.model.Contact;
import org.example.chipmongdemotest.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays; // Import the necessary class
import java.util.List; // Import the necessary class

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Helper method to provide lists for the dropdowns
    private void addDropdownData(Model model) {
        // You should get these from a service or a database in a real application
        List<String> provinces = Arrays.asList("Phnom Penh", "Takeo", "Kandal", "Battambang");
        List<String> amphurs = Arrays.asList("Khan Daun Penh", "Khan Chamkar Mon", "Doun Keo", "Bati");
        model.addAttribute("provinces", provinces);
        model.addAttribute("amphurs", amphurs);
    }

    // Show empty form for creating new contact
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("contact", new Contact());
        addDropdownData(model); // Add this line to provide the lists
        return "contact_form";
    }

    // Save new contact
    @PostMapping("/save")
    public String saveContact(@ModelAttribute Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts/new?success";
    }

    // Show form with existing contact for editing
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        addDropdownData(model); // Add this line to provide the lists
        return "contact_form";
    }

    // Update existing contact
    @PostMapping("/update/{id}")
    public String updateContact(@PathVariable Long id, @ModelAttribute Contact contact) {
        contact.setId(id);
        contactService.updateContact(contact);
        return "redirect:/contacts/new?updated";
    }
}