package com.karinedias.service;

import com.karinedias.model.Patient;
import com.karinedias.model.Ville;
import com.karinedias.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private final PatientRepository patientRepo;

    public PatientService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient create(Patient patient) {
        return patientRepo.save(patient);
    }

    public List<Patient> findAll() {
        return (List<Patient>) patientRepo.findAll();
    }

    public Patient findById(int id) {
        return patientRepo.findById(id).get();
    }

    public Patient update(int id, String nom, String prenom, String email, String telephone, Ville ville) {
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new EntityNotFoundException
                ("Patient not found with: id" + id));
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setEmail(email);
        patient.setTelephone(telephone);
        patient.setVille(ville);

        return patientRepo.save(patient);
    }


    public void delete(int id) {
        patientRepo.deleteById(id);
    }

}
