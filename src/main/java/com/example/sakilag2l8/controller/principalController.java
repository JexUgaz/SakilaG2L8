package com.example.sakilag2l8.controller;

import com.example.sakilag2l8.entities.PeliculaEntity;
import com.example.sakilag2l8.entities.ReservaEntity;
import com.example.sakilag2l8.respository.PeliculasRepository;
import com.example.sakilag2l8.respository.ReservaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
public class principalController {
    @Autowired
    PeliculasRepository peliculasRepository;
    @Autowired
    ReservaRespository reservaRespository;
    @GetMapping("/listarPeliculas")
    public List<PeliculaEntity> listarPeliculas(){
        return peliculasRepository.findAll();
    }
    @PostMapping(value = "/reservar")
    public ResponseEntity<HashMap<String, Object>> reservar(@RequestBody ReservaEntity reserva){
        HashMap<String, Object> resonseMap = new HashMap<>();
        reservaRespository.save(reserva);
        resonseMap.put("msg","Reserva creada exitosamente!");
        return ResponseEntity.status(HttpStatus.CREATED).body(resonseMap);
    }

}
