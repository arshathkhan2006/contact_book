package com.campus.contact_details.service;

import com.campus.contact_details.entity.Contact;
import com.campus.contact_details.exception.ContactNotFoundException;
import com.campus.contact_details.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<Contact> searchContacts(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return getAllContacts();
        }

        return contactRepository
                .findByNameContainingIgnoreCaseOrPhoneContainingOrEmailContainingIgnoreCase(
                        keyword, keyword, keyword
                );
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new ContactNotFoundException(id);
        }

        contactRepository.deleteById(id);
    }
}
