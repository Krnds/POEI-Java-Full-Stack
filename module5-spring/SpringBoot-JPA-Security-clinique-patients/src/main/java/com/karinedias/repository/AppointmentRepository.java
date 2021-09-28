package com.karinedias.repository;

import com.karinedias.model.Appointment;
import org.springframework.data.repository.CrudRepository;

// To have access to CRUD operations
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}