package com.karinedias.repository;

import com.karinedias.model.Ville;
import org.springframework.data.repository.CrudRepository;

// To have access to CRUD operations
public interface VilleRepository extends CrudRepository<Ville, Integer> {
}
