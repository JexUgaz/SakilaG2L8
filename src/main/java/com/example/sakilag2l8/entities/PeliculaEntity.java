package com.example.sakilag2l8.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "pelicula", schema = "sakilag2", catalog = "")
public class PeliculaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPelicula")
    private Integer idPelicula;
    @Basic
    @Column(name = "Nombre")
    private String nombre;
}
