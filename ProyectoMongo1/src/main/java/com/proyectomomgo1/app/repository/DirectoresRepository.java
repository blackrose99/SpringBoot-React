package com.proyectomomgo1.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectomomgo1.app.Entity.Directores;

public interface DirectoresRepository extends MongoRepository<Directores, String>{
	List<Directores> findAll();
}
