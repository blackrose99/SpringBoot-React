package com.proyectomomgo1.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectomomgo1.app.Entity.Clubes;

public interface CublesRepository extends MongoRepository<Clubes, String> {
	List<Clubes> findAll();

}
