package com.example.sakilag2l8.controller;

import com.example.sakilag2l8.entities.PeliculaEntity;
import com.example.sakilag2l8.respository.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class principalController {
    @Autowired
    PeliculasRepository peliculasRepository;
    @GetMapping("/listarPeliculas")
    public List<PeliculaEntity> listarPeliculas(){
        return peliculasRepository.findAll();
    }
}
