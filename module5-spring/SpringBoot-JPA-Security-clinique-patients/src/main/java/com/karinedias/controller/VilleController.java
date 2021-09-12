package com.karinedias.controller;

import com.karinedias.model.User;
import com.karinedias.model.Ville;
import com.karinedias.service.UserService;
import com.karinedias.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cities")
public class VilleController {

    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }


    // READ
    @GetMapping("/all")
    public String getAllCities(Model model) {

        model.addAttribute("villes", villeService.findAll());
        return "/city/getCities";
    }


    @GetMapping("/delete-city/{id}")
    public String deleteCity(@PathVariable int id) {
        villeService.delete(id);
        return "redirect:/cities/all";
    }

    // Form to Update
    @GetMapping("/updateForm-city/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("ville", villeService.findById(id));
        return "city/editCity";
    }


    @PostMapping(value = "/edit-city/{id}")
    public String updateCity(@PathVariable(name = "id") int id, HttpServletRequest request, Model model) {
//       Ville ville = villeService.findById(id);
        String nom = request.getParameter("nom");
        String codePostal = request.getParameter("codePostal");
        villeService.update(id, nom, codePostal);

        return "redirect:/cities/all";
    }


    @RequestMapping("/add-new-city")
    public String addNewCity(Model model) {
        model.addAttribute("villes", villeService.findAll());
        return "city/createCity";
    }

    @PostMapping("/add-city")
    public String savePatient(@ModelAttribute("ville") Ville ville) {
        villeService.create(ville);
        return "redirect:/cities/all";
    }

}