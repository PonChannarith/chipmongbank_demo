package org.example.chipmongdemotest.service.impl;

import org.example.chipmongdemotest.model.Contact;
import org.example.chipmongdemotest.repository.ContactMapper;
import org.example.chipmongdemotest.service.ContactService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactMapper contactMapper;

    public ContactServiceImpl(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    @Override
    public List<Contact> getAllContacts() { return contactMapper.findAll(); }

    @Override
    public Contact getContactById(Long id) { return contactMapper.findById(id); }

    @Override
    public void saveContact(Contact contact) { contactMapper.insert(contact); }

    @Override
    public void updateContact(Contact contact) { contactMapper.update(contact); }

    @Override
    public void deleteContact(Long id) { contactMapper.delete(id); }
}
