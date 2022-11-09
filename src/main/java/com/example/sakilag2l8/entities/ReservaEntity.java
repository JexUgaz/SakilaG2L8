package com.example.sakilag2l8.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reserva", schema = "sakilag2", catalog = "")
public class ReservaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idReserva")
    private int idReserva;
    @Basic
    @Column(name = "Pelicula_idPelicula")
    private int peliculaIdPelicula;
    @Basic
    @Column(name = "fecha")
    private String fecha;
    @Basic
    @Column(name = "horaInicio")
    private String horaInicio;
    @Basic
    @Column(name = "horaFin")
    private String horaFin;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getPeliculaIdPelicula() {
        return peliculaIdPelicula;
    }

    public void setPeliculaIdPelicula(int peliculaIdPelicula) {
        this.peliculaIdPelicula = peliculaIdPelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaEntity that = (ReservaEntity) o;
        return idReserva == that.idReserva && peliculaIdPelicula == that.peliculaIdPelicula && Objects.equals(fecha, that.fecha) && Objects.equals(horaInicio, that.horaInicio) && Objects.equals(horaFin, that.horaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReserva, peliculaIdPelicula, fecha, horaInicio, horaFin);
    }
}
