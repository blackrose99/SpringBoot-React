package com.proyectomomgo1.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectomomgo1.app.Entity.Directores;
import com.proyectomomgo1.app.exeption.NotFoundException;
import com.proyectomomgo1.app.repository.DirectoresRepository;

@RestController
@RequestMapping(value = "/api/directores")
public class directoresController {
	 @Autowired
	    private DirectoresRepository directoresRepository;

	    @GetMapping("/")
	    public List<Directores> getDirectores() {
	        return directoresRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Directores getDirectorById(@PathVariable String id) {
	        return directoresRepository.findById(id)
	                .orElseThrow(() -> new NotFoundException("No existe el director con el ID " + id));
	    }

	    @PostMapping("/")
	    public Directores saveDirector(@RequestBody Map<String, Object> body) {
	        ObjectMapper mapper = new ObjectMapper();
	        Directores director = mapper.convertValue(body, Directores.class);
	        return directoresRepository.save(director);
	    }

	    @PutMapping("/{id}")
	    public Directores updateDirector(@PathVariable String id, @RequestBody Map<String, Object> body) {
	        ObjectMapper mapper = new ObjectMapper();
	        Directores director = mapper.convertValue(body, Directores.class);
	        director.setId(id);
	        return directoresRepository.save(director);
	    }

	    @DeleteMapping("/{id}")
	    public Directores deleteDirector(@PathVariable String id) {
	        Directores director = directoresRepository.findById(id)
	                .orElseThrow(() -> new NotFoundException("Director no encontrado"));
	        directoresRepository.deleteById(id);
	        return director;
	    }
}
