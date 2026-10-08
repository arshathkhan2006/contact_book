package com.campus.contact_details.exception;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(Long id) {
        super("Contact with ID " + id + " was not found.");
    }
}
