
package com.proyectomomgo1.app.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyectomomgo1.app.Entity.Asociaciones;


public interface AsociacionRepository extends MongoRepository<Asociaciones, String> {
	List<Asociaciones> findAll();

}
