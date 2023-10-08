package com.proyectomomgo1.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectomomgo1.app.Entity.Jugadores;
import com.proyectomomgo1.app.exeption.NotFoundException;
import com.proyectomomgo1.app.repository.JugadoresRepository;

@RestController
@RequestMapping(value = "/api/jugadores")
public class JugadoresController {

    @Autowired
    private JugadoresRepository jugadoresRepository;

    @GetMapping("/")
    public List<Jugadores> getJugadores() {
        return jugadoresRepository.findAll();
    }

    @GetMapping("/{id}")
    public Jugadores getJugadorById(@PathVariable String id) {
        return jugadoresRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe el jugador con el ID " + id));
    }

    @PostMapping("/")
    public ResponseEntity<Jugadores> crearJugador(@RequestBody Jugadores jugador) {
        Jugadores jugadorCreado = jugadoresRepository.save(jugador);
        return new ResponseEntity<>(jugadorCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Jugadores updateJugadores(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        Jugadores jugador = mapper.convertValue(body, Jugadores.class);
        jugador.setId(id);
        return jugadoresRepository.save(jugador);
    }

    @DeleteMapping("/{id}")
    public Jugadores deleteJugador(@PathVariable String id) {
        Jugadores jugador = jugadoresRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Jugador no encontrado"));
        jugadoresRepository.deleteById(id);
        return jugador;
    }
}
