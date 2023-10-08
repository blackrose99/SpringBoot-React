package com.proyectomomgo1.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyectomomgo1.app.Entity.Competiciones;
public interface CompeticionesRepository extends MongoRepository<Competiciones, String> {
	List<Competiciones> findAll();
}
