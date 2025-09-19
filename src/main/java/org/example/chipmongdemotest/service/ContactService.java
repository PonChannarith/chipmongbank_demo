package org.example.chipmongdemotest.service;

import org.example.chipmongdemotest.model.Contact;
import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    void saveContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(Long id);
}
