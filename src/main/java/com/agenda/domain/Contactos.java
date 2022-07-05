package com.agenda.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;




@Data
@Entity
@Table(name = "contacto")
public class Contactos implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Long id;

    @Column(name = "cont_nombre")
    private String nombre;

    @Column(name = "cont_teléfono")
    private String telefono;

    @Column(name = "cont_email")
    private String email;

    @Column(name = "cont_fecha_nacimiento")
    private String nacimiento;

}

