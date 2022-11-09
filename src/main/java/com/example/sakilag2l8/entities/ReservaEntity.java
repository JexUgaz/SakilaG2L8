package com.example.sakilag2l8.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "reserva", schema = "sakilag2", catalog = "")
public class ReservaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idReserva")
    private Integer idReserva;
    @Basic
    @Column(name = "Pelicula_idPelicula")
    private Integer peliculaIdPelicula;
    @Basic
    @Column(name = "fecha")
    private String fecha;
    @Basic
    @Column(name = "horaInicio")
    private String horaInicio;
    @Basic
    @Column(name = "horaFin")
    private String horaFin;

}
