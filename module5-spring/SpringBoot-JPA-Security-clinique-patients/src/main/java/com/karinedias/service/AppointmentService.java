package com.karinedias.service;

import com.karinedias.model.Appointment;
import com.karinedias.model.Patient;
import com.karinedias.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private final AppointmentRepository apptRepo;

    public AppointmentService(AppointmentRepository apptRepo) {
        this.apptRepo = apptRepo;
    }


    public Appointment create(Appointment appt) {
        return apptRepo.save(appt);
    }

    public List<Appointment> findAll() {
        return (List<Appointment>) apptRepo.findAll();
    }

    public Appointment findById(int id) {
        return apptRepo.findById(id).orElse(null);
    }


    public Appointment update(int id, Patient idPatient, Timestamp date, String type, int duration, String note) {
        Appointment appt = apptRepo.findById(id).orElseThrow(() -> new EntityNotFoundException
                ("Appointment not found with: id" + id));
        appt.setId(id);
        appt.setIdPatient(idPatient);
        appt.setDate(date);
        appt.setType(type);
        appt.setDuration(duration);
        appt.setNote(note);

        return apptRepo.save(appt);
    }


    public void delete(int id) {
        apptRepo.deleteById(id);
    }

}

