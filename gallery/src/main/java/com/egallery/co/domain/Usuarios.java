package com.egallery.co.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="alias")
    private String alias;

    @Column(name="edad")
    private int edad;

    @Lob
    @Column(name="foto")
    private byte[] foto;

    @Column(name="correo")
    private String correo;

    @Column(name="rol")
    private String rol;

 }

