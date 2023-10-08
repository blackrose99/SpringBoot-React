package com.proyectomomgo1.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyectomomgo1.app.Entity.Asociaciones;
import com.proyectomomgo1.app.exeption.NotFoundException;
import com.proyectomomgo1.app.repository.AsociacionRepository;

@RestController
@RequestMapping(value = "/api/asociacion")
public class asociacionController {

    @Autowired
    private AsociacionRepository asociacionRepository;

    @GetMapping("/")
    public List<Asociaciones> getAsociaciones() {
        return asociacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Asociaciones getAsociacionesById(@PathVariable String id) {
        return asociacionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Existe " + "La Asociacion con el ID " + id));
    }

    @PostMapping("/")
    public Asociaciones saveAsociaciones(@RequestBody Asociaciones asociacion) {
        return asociacionRepository.save(asociacion);
    }

    @PutMapping("/{id}")
    public Asociaciones updateAsociaciones(@PathVariable String id, @RequestBody Asociaciones asociacion) {
        asociacion.setId(id);
        return asociacionRepository.save(asociacion);
    }

    @DeleteMapping("/{id}")
    public Asociaciones deleAsociaciones(@PathVariable String id) {
        Asociaciones asociacion = asociacionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipo no encontrado"));
        asociacionRepository.deleteById(id);
        return asociacion;
    }
}
