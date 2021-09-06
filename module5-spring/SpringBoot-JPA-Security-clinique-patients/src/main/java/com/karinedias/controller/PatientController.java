package com.karinedias.controller;

import com.karinedias.model.Patient;
import com.karinedias.model.Ville;
import com.karinedias.repository.PatientRepository;
import com.karinedias.repository.VilleRepository;
import com.karinedias.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
@Secured("ROLE_ADMIN")
public class PatientController {


//    @Autowired
//    private final PatientService patientService;

    private final PatientRepository patientRepo;
    private final VilleRepository villeRepo;


    public PatientController(PatientRepository patientRepo, VilleRepository villeRepo) {
        this.patientRepo = patientRepo;
        this.villeRepo = villeRepo;
    }

    //LOGIN PAGE
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // READ
    @Secured("ROLE_USER")
    @GetMapping("/all")
    public String getAllPatients(Model model) {

        List<Patient> patients = (List<Patient>) patientRepo.findAll();
        model.addAttribute("patients", patients);
        List<Ville> cities = (List<Ville>) villeRepo.findAll();
        model.addAttribute("cities", cities);

        return "getAll";
    }


    // DELETE
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePatient(@PathVariable String id, Model model) {
        patientRepo.deleteById(Integer.parseInt(id));
        model.addAttribute("patients", patientRepo.findAll());
        return "redirect:/all";
    }


    // Form to Update
    @GetMapping("/updateForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {

        Optional<Patient> patient = patientRepo.findById(Integer.parseInt(id));
// Pour avoir la liste des villes dans le formulaire
        List<Ville> villes = (List<Ville>) villeRepo.findAll();
        model.addAttribute("villes", villes);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("patient", patient.get()); //TODO: faire un if/else ?
        // redirige vers la template edit.html
        return "edit";
    }


    @PostMapping(value = "/edit/{id}")
    public String addPatientPost(@PathVariable(name = "id") String id, HttpServletRequest request, Model model) {

        Optional<Patient> patientFound = patientRepo.findById(Integer.parseInt(id));
        // Pour avoir la liste des villes dans le formulaire
        List<Ville> villes = (List<Ville>) villeRepo.findAll();
        model.addAttribute("villes", villes);
        try {
            Patient p = patientFound.get();
            p.setNom(request.getParameter("nom"));
            p.setPrenom(request.getParameter("prenom"));
            p.setEmail(request.getParameter("email"));
            p.setTelephone(request.getParameter("telephone"));
            Ville v = villeRepo.findById(Integer.valueOf(request.getParameter("ville"))).orElse(null);
            p.setVille(v);
            patientRepo.save(p);
        } catch (Exception e) {

            e.printStackTrace();
        }


        return "redirect:/all";
    }


    @RequestMapping("/add-new")
    public String addNewPatient(Model model) {

        List<Ville> villes = (List<Ville>) villeRepo.findAll();
        model.addAttribute("villes", villes);
        return "create";
    }


//    @PostMapping("/add")
//    public String addPatient(@RequestBody Patient patient) {
//        Patient newPatient = patientRepo.save(patient);
//        System.out.println(newPatient.toString());
//        Optional<Patient> addedPatient = Optional.of(patientRepo.save(patient));
//        return "redirect:/all";
//    }

//    @PostMapping("/add")
//    public String addPatient2(@Validated Patient patient, BindingResult result, Model model) {
//        System.out.println("PATIENT ADDED : " + patient.toString());
//
//        patientRepo.save(patient);
//        return "redirect:/all";
//    }


    // CREATE NEW PATIENT
//    @GetMapping("/add")
//    public String addPost(HttpServletRequest request) {
//        System.out.println("Nom = " + request.getParameter("name"));
//        try {
//            Patient newPatient = new Patient();
//            newPatient.setNom(request.getParameter("nom"));
//            newPatient.setPrenom(request.getParameter("prenom"));
//            newPatient.setEmail(request.getParameter("email"));
//            newPatient.setTelephone(request.getParameter("telephone"));
//            Ville v = villeRepo.findById(Integer.valueOf(request.getParameter("ville"))).orElse(null);
//            newPatient.setVille(v);
//            patientRepo.save(newPatient);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return "redirect:/all";
//    }

//    @GetMapping(value = "/add")
//    public String addPatientGet(Model model) {
//        model.addAttribute("nom", p.getNom());
//        model.addAttribute("prenom", "prenom");
//        model.addAttribute("email", "email");
//        model.addAttribute("telephone", "Téléphone*");
//        List<Ville> lv = (List<Ville>) villeRepo.findAll();
//        model.addAttribute("villes", lv);
//        Ville villeDefaut = villeRepo.findById(1).orElse(null);
//        model.addAttribute("ville", villeDefaut);
//        model.addAttribute("button_submit_text", "Ajouter patient");
//        return "redirect:/all";
//    }


    // Taken from https://www.baeldung.com/spring-mvc-and-the-modelattribute-annotation
//    @RequestMapping(value = "/add2", method = RequestMethod.GET)
//    public String submit(
//            @ModelAttribute("patient") Patient p,
//            BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "There was an error";
//        }
//        model.addAttribute("nom", p.getNom());
//        model.addAttribute("prenom", p.getPrenom());
//        model.addAttribute("email", p.getEmail());
//        model.addAttribute("telephone", p.getTelephone());
//        List<Ville> lv = (List<Ville>) villeRepo.findAll();
//        model.addAttribute("villes", lv);
//        Ville villeDefaut = villeRepo.findById(1).orElse(null);
//        model.addAttribute("ville", villeDefaut);
//        patientRepo.save(p);
//        model.addAttribute("button_submit_text", "Ajouter patient");
//        return "redirect:/patient/list";
//
//
//
//    }

    // CREATE
    @PostMapping("/add")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patientRepo.save(patient);
        return "redirect:/all";
    }


}
