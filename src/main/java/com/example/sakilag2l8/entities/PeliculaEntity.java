package com.example.sakilag2l8.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pelicula", schema = "sakilag2", catalog = "")
public class PeliculaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPelicula")
    private int idPelicula;
    @Basic
    @Column(name = "Nombre")
    private String nombre;

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaEntity that = (PeliculaEntity) o;
        return idPelicula == that.idPelicula && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, nombre);
    }
}
