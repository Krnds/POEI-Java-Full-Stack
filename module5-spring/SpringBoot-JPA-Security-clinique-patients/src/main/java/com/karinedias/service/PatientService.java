package com.karinedias.service;

import com.karinedias.model.Patient;
import com.karinedias.repository.PatientRepository;
import com.karinedias.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Alléger le code du controller
@Service
public class PatientService {

    @Autowired
    private final PatientRepository patientRepo;
    private final VilleRepository villeRepo;

    public PatientService(PatientRepository patientRepo, VilleRepository villeRepo) {
        this.patientRepo = patientRepo;
        this.villeRepo = villeRepo;
    }

    public Patient addPatient(Patient patient) {
        patientRepo.save(patient);
        return null;
    }

}
