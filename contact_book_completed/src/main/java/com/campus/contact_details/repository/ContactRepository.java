package com.campus.contact_details.repository;

import com.campus.contact_details.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByNameContainingIgnoreCaseOrPhoneContainingOrEmailContainingIgnoreCase(
            String name,
            String phone,
            String email
    );
}
