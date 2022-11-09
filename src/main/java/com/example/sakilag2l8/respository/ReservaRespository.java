package com.example.sakilag2l8.respository;

import com.example.sakilag2l8.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRespository extends JpaRepository<ReservaEntity, Integer> {
}
