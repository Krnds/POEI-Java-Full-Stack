package com.karinedias.repository;

import com.karinedias.model.Patient;
import org.springframework.data.repository.CrudRepository;

// To have access to CRUD operations
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    Patient findByEmail(String email);
}
