package com.agenda.service;

import com.agenda.dao.ContactsDao;
import com.agenda.domain.Contactos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class ContactsService implements IcontactsService{



    @Autowired
    private ContactsDao contactsDao;


    @Override
    @Transactional(readOnly = true)
    public List<Contactos> list() {
        List<Contactos> contactos = null;
        try {
            contactos = (List<Contactos>) contactsDao.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return contactos;
    }

    @Override
    @Transactional
    public Contactos save(Contactos contactos) {
        return contactsDao.save(contactos);
    }




    @Override
    @Transactional
    public Contactos update(Long id, Contactos contactos) {
        contactos.setId(id);
        return contactsDao.save(contactos);
    }

    @Override
    @Transactional
    public void delete(Contactos contactos) {
      contactsDao.delete(contactos);
    }

    @Transactional
    public void updateName(Long id, Contactos contactos){
        contactsDao.updateName(id, contactos.getNombre());
    }

    @Transactional
    public void updatePhone(Long id, Contactos contactos){
        contactsDao.updatePhone(id, contactos.getTelefono());
    }

    @Transactional
    public void updateEmail(Long id, Contactos contactos){
        contactsDao.updateEmail(id, contactos.getEmail());
    }

    @Transactional
    public void updateBirth(Long id, Contactos contactos){
        contactsDao.updateBirth(id, contactos.getNacimiento());
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Contactos> findContactos(Contactos contactos) {

        return contactsDao.findById(contactos.getId());
    }

    @Override
    public Optional<Contactos> findById(Long id) {
        return contactsDao.findById(id);
    }

    @Override
    public Optional<Contactos> getById(Long id) {
        return Optional.ofNullable(contactsDao.getById(id));
    }

    @Override
    public Contactos findById() {
        return null;
    }
}
