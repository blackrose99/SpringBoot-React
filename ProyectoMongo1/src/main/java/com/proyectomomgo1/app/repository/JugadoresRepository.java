package com.proyectomomgo1.app.repository;

import com.proyectomomgo1.app.Entity.Jugadores;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JugadoresRepository extends MongoRepository<Jugadores, String> {
	List<Jugadores> findAll();
}
