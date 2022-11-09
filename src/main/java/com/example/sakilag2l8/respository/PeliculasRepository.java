package com.example.sakilag2l8.respository;

import com.example.sakilag2l8.entities.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasRepository  extends JpaRepository<PeliculaEntity,Integer> {
}
