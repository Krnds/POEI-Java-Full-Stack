package com.karinedias.controller;

import com.karinedias.model.Ville;
import com.karinedias.repository.VilleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class VilleController {

    private final VilleRepository villeRepo;

    public VilleController(VilleRepository villeRepo) {
        this.villeRepo = villeRepo;
    }


    // READ
    @GetMapping("")
    public String getAllCities(Model model) {

        List<Ville> villes = (List<Ville>) villeRepo.findAll();
        model.addAttribute("villes", villes);
        return "getCities";
    }

}