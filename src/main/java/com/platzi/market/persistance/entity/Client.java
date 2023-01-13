package com.platzi.market.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Client {

    @Id
    @Column(name = "id")
    private String clientId;

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "celular")
    private Number phoneNumber;

    @Column(name = "direccion")
    private String direction;

    @Column(name = "correo_electronico")
    private String email;
}
