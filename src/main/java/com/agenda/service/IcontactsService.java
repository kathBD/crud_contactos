package com.agenda.service;


import com.agenda.domain.Contactos;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IcontactsService {

    public List<Contactos> list();

    public Contactos save(Contactos contactos);

    public Contactos update(Long id, Contactos contactos);



    public void delete(Contactos contactos);


    public Optional<Contactos> findContactos(Contactos contactos);

    public Optional<Contactos> findById(Long id);

    public Optional<Contactos> getById(Long id);


    Contactos findById();
}
