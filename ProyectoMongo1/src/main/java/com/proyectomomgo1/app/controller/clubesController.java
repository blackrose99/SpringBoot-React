package com.proyectomomgo1.app.controller;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyectomomgo1.app.Entity.Clubes;
import com.proyectomomgo1.app.exeption.NotFoundException;
import com.proyectomomgo1.app.repository.CublesRepository;


@RestController
@RequestMapping(value = "/api/clubes")
public class clubesController {
	@Autowired
    private CublesRepository clubesRepository;

    @GetMapping("/")
    public List<Clubes> getClubes() {
        return clubesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Clubes getClubById(@PathVariable String id) {
        return clubesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe el club con el ID " + id));
    }

    @PostMapping("/")
    public Clubes saveClub(@RequestBody Map<String, Object> body) {
        Clubes club = new Clubes();
        club.setNombre((String) body.get("nombre"));
        // Puedes manejar otras propiedades aquí

        return clubesRepository.save(club);
    }

    @PutMapping("/{id}")
    public Clubes updateClub(@PathVariable String id, @RequestBody Map<String, Object> body) {
        Clubes club = clubesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Club no encontrado"));

        club.setNombre((String) body.get("nombre"));
        // Puedes manejar otras propiedades aquí

        return clubesRepository.save(club);
    }

    @DeleteMapping("/{id}")
    public Clubes deleteClub(@PathVariable String id) {
        Clubes club = clubesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Club no encontrado"));
        clubesRepository.deleteById(id);
        return club;
    }
}
