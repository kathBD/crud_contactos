package com.agenda.dao;

import com.agenda.domain.Contactos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ContactsDao extends JpaRepository<Contactos, Long> {

    @Modifying
    @Query("update Contactos contac set contac.nombre = :name where contac.id = :id ")

    public void updateName(
            @Param(value = "id") Long id,
            @Param(value = "name") String name
    );

    @Modifying
    @Query("update Contactos contac set contac.telefono = :phone where contac.id = :id ")

    public void updatePhone(
            @Param(value = "id") Long id,
            @Param(value = "phone") String phone
    );

    @Modifying
    @Query("update Contactos contac set contac.email = :email where contac.id = :id ")

    public void updateEmail(
            @Param(value = "id") Long id,
            @Param(value = "email") String email
    );

    @Modifying
    @Query("update Contactos contac set contac.nacimiento = :birth where contac.id = :id ")

    public void updateBirth(
            @Param(value = "id") Long id,
            @Param(value = "birth") String birth
    );

    @Override
    Optional<Contactos> findById(Long id);

    Contactos getById(Long id);
}
