package com.karinedias.service;

import com.karinedias.model.Ville;
import com.karinedias.model.Ville;
import com.karinedias.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class VilleService {

    @Autowired
    private final VilleRepository villeRepo;

    public VilleService(VilleRepository villeRepo) {
        this.villeRepo = villeRepo;
    }

    public Ville create(Ville ville) {
        return villeRepo.save(ville);
    }

    public List<Ville> findAll() {
        return (List<Ville>) villeRepo.findAll();
    }

    public Ville findById(int id) {
        return villeRepo.findById(id).get();
    }

    public Ville update(int id, String nom, String codePostal) {
        Ville ville = villeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException
                ("Ville not found with: id" + id));
        ville.setNom(nom);
        ville.setCodePostal(Integer.parseInt(codePostal));
        return villeRepo.save(ville);
    }


    public void delete(int id) {
        villeRepo.deleteById(id);
    }

}