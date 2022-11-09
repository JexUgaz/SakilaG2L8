package com.example.sakilag2l8.controller;

import com.example.sakilag2l8.entities.PeliculaEntity;
import com.example.sakilag2l8.entities.ReservaEntity;
import com.example.sakilag2l8.respository.PeliculasRepository;
import com.example.sakilag2l8.respository.ReservaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    @PutMapping(value = "/actualizaReserva")
    public ResponseEntity<HashMap<String, Object>> actualizarReserva(@RequestBody ReservaEntity reserva){
        HashMap<String, Object> responseMap= new HashMap<>();
        if(reserva.getIdReserva()!=null && reserva.getIdReserva()>0){
            Optional<ReservaEntity> opt=reservaRespository.findById(reserva.getIdReserva());
            if(opt.isPresent()){
                ReservaEntity reserva1=opt.get();
                if(reserva.getFecha()!=null){
                    reserva1.setFecha(reserva.getFecha());
                }if(reserva.getPeliculaIdPelicula()!=null){
                    reserva1.setPeliculaIdPelicula(reserva.getPeliculaIdPelicula());
                }if(reserva.getHoraInicio()!=null){
                    reserva1.setHoraInicio(reserva.getHoraInicio());
                }if(reserva.getHoraFin()!=null){
                    reserva1.setHoraFin(reserva.getHoraFin());
                }
                reservaRespository.save(reserva1);
                responseMap.put("estado","actualizado");
                return ResponseEntity.ok(responseMap);
            }else{
                responseMap.put("estado","error");
                responseMap.put("msg","La reserva a actualizar no existe!");
                return ResponseEntity.badRequest().body(responseMap);
            }
        }else{
            responseMap.put("estado","error");
            responseMap.put("msg","Debe enviar un ID.");
            return ResponseEntity.badRequest().body(responseMap);
        }
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> gestiondeErrores(HttpServletRequest request){
        HashMap<String,String> responseMap= new HashMap<>();
        if(request.getMethod().equals("POST")||request.getMethod().equals("PUT")){
            responseMap.put("estado","error");
            responseMap.put("msg","Reserva enviada incorrectamente");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }
}
