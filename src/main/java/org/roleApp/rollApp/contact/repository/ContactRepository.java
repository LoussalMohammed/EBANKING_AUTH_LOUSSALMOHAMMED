package org.roleApp.rollApp.contact.repository;

import org.roleApp.rollApp.contact.entity.Contact;
import org.roleApp.rollApp.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    default Contact findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("No entity contact found using specified id: "+ id));
    }
}
