package com.karinedias.controller;

import com.karinedias.model.Patient;
import com.karinedias.model.Ville;
import com.karinedias.service.PatientService;
import com.karinedias.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
@Secured("ROLE_ADMIN")
public class PatientController {

    private final PatientService patientService;
    private final VilleService villeService;

    @Autowired
    public PatientController(PatientService patientService, VilleService villeService) {
        this.patientService = patientService;
        this.villeService = villeService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @Secured("ROLE_USER")
    @GetMapping("/all")
    public String getPatients(Model model) {
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("cities", villeService.findAll());
        return "getAll";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.delete(id);
        return "redirect:/all";
    }

    // Form to Update
    @GetMapping("/updateForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // Get list of cities for template form
        model.addAttribute("villes", villeService.findAll());
        // set patient as a model attribute to pre-populate the form
        model.addAttribute("patient", patientService.findById(id));
        return "edit";
    }


    @PostMapping(value = "/edit/{id}")
    public String updatePatient(@PathVariable(name = "id") int id, HttpServletRequest request, Model model) {

        Patient patient = patientService.findById(id);

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        System.out.println("Paramètre ville = " + request.getParameter("ville"));
        Ville ville = villeService.findById(Integer.valueOf(request.getParameter("ville")));
        patientService.update(id, nom, prenom, email, telephone, ville);

        return "redirect:/all";
    }

    //TODO: delete
    @RequestMapping("/add-new")
    public String addNewPatient(Model model) {
        model.addAttribute("villes", villeService.findAll());
        return "create";
    }

    @PostMapping("/add")
    public String savePatient(@ModelAttribute("patient") Patient patient, Model model) {
        model.addAttribute("villes", villeService.findAll());
        patientService.create(patient);
        return "redirect:/all";
    }


}

