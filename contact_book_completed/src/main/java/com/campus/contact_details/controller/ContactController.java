package com.campus.contact_details.controller;

import com.campus.contact_details.entity.Contact;
import com.campus.contact_details.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/contacts";
    }

    @GetMapping("/contacts")
    public String listContacts(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model
    ) {
        model.addAttribute("contacts", contactService.searchContacts(keyword));
        model.addAttribute("keyword", keyword == null ? "" : keyword);
        return "contacts";
    }

    @GetMapping("/contacts/new")
    public String showAddContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add-contact";
    }

    @PostMapping("/contacts/save")
    public String saveContact(
            @Valid @ModelAttribute("contact") Contact contact,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "add-contact";
        }

        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/edit/{id}")
    public String showEditContactForm(@PathVariable Long id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "edit-contact";
    }

    @PostMapping("/contacts/update/{id}")
    public String updateContact(
            @PathVariable Long id,
            @Valid @ModelAttribute("contact") Contact contact,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            contact.setId(id);
            return "edit-contact";
        }

        contactService.getContactById(id);

        contact.setId(id);
        contactService.saveContact(contact);

        return "redirect:/contacts";
    }

    @GetMapping("/contacts/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }
}
