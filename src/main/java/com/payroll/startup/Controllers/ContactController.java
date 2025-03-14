package com.payroll.startup.Controllers;

import com.payroll.startup.Models.Contact;
import com.payroll.startup.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts/")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("all")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("{contact_id}")
    public Contact getContactById(@PathVariable("contact_id") Integer id) {
        return contactService.getContactById(id);
    }

    @PostMapping
    public void addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
    }

    @PutMapping("{contact_id}")
    public void updateContact(@PathVariable("contact_id") Integer id, @RequestBody Contact contact) {
        contactService.updateContact(id, contact.getPhoneNumber(), contact.getEmail(), contact.getHomeNumber());
    }

    @DeleteMapping("{id}")
    public void deleteContact(@PathVariable("contact_id") Integer id) {
        contactService.deleteContact(id);
    }
}