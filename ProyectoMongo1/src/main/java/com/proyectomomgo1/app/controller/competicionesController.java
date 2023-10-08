package com.proyectomomgo1.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectomomgo1.app.Entity.Competiciones;
import com.proyectomomgo1.app.exeption.NotFoundException;
import com.proyectomomgo1.app.repository.CompeticionesRepository;

@RestController
@RequestMapping("/api/competiciones")
public class competicionesController {

    @Autowired
    private CompeticionesRepository competicionesRepository;

    @GetMapping("/")
    public List<Competiciones> getCompeticiones() {
        return competicionesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Competiciones getCompeticionById(@PathVariable String id) {
        return competicionesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe la competición con el ID " + id));
    }

    @PostMapping("/")
    public ResponseEntity<Competiciones> crearCompeticion(@RequestBody Competiciones competicion) {
        Competiciones competicionCreada = competicionesRepository.save(competicion);
        return new ResponseEntity<>(competicionCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Competiciones updateCompeticion(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Competiciones competicion = mapper.convertValue(body, Competiciones.class);
        competicion.setId(id);
        return competicionesRepository.save(competicion);
    }

    @DeleteMapping("/{id}")
    public Competiciones deleteCompeticion(@PathVariable String id) {
        Competiciones competicion = competicionesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Competicion no encontrada"));
        competicionesRepository.deleteById(id);
        return competicion;
    }
}
