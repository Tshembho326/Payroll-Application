package com.payroll.startup.Services;

import com.payroll.startup.Models.Contact;
import com.payroll.startup.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Integer id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contact with ID " + id + " not found"));
    }

    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void updateContact(Integer id, String phoneNumber, String email, String homeNumber) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contact with ID " + id + " not found"));

        if (phoneNumber != null && !phoneNumber.isEmpty()) contact.setPhoneNumber(phoneNumber);
        if (email != null && !email.isEmpty()) contact.setEmail(email);
        if (homeNumber != null && !homeNumber.isEmpty()) contact.setHomeNumber(homeNumber);

        contactRepository.save(contact);
    }

    public void deleteContact(Integer id) {
        if (!contactRepository.existsById(id)) {
            throw new IllegalArgumentException("Contact with ID " + id + " not found");
        }
        contactRepository.deleteById(id);
    }
}
