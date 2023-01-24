package com.egallery.co.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "obras")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Obras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio_anterior")
    private double precioAnterior;

    @Column(name="precio_actual")
    private double precioActual;

    @Column(name="precio_final")
    private double precioFinal;

    @Lob
    @Column(name="foto")
    private byte[] foto;

    @Column(name="tecnica")
    private String tecnica;

    @ManyToOne
    @JoinColumn(name = "usuario_autor", referencedColumnName ="id")
    private Usuarios usuarioAutor;

    @Column(name="vendida")
    private boolean vendida;

    @ManyToOne
    @JoinColumn(name = "usuario_comprador", referencedColumnName ="id")
    private Usuarios usuarioComprador;

 }

