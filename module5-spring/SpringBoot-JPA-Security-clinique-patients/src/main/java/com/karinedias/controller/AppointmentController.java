package com.karinedias.controller;

import com.karinedias.model.Appointment;
import com.karinedias.model.Patient;
import com.karinedias.service.AppointmentService;
import com.karinedias.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;


@Controller
@RequestMapping("/rdv")
@Secured("ROLE_ADMIN")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final PatientService patientService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }


    @Secured("ROLE_USER")
    @GetMapping("/all")
    public String getPatients(Model model) {
        model.addAttribute("rdv", appointmentService.findAll());
        model.addAttribute("patients", patientService.findAll());
        return "/appt/getAppointments";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        appointmentService.delete(id);
        return "redirect:/rdv/all";
    }


    // Form to Update
    @GetMapping("/updateForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        model.addAttribute("rdv", appointmentService.findById(id));
        model.addAttribute("idPatient", appointmentService.findById(id).getIdPatient());
        return "appt/editAppointment";
    }


    @PostMapping(value = "/edit/{id}")
    public String updatePatient(@PathVariable(name = "id") int id, HttpServletRequest request, Model model) {

        Appointment appointment = appointmentService.findById(id);
        Patient patient = patientService.findById(Integer.parseInt(request.getParameter("idPatient")));
        Timestamp date = Timestamp.valueOf(request.getParameter("date"));
        String type = request.getParameter("type");
        int duration = Integer.parseInt(request.getParameter("duration"));
        String note = request.getParameter("note");
        appointmentService.update(id, patient, date, type, duration, note);

        return "redirect:/rdv/all";
    }

    @PostMapping("/add")
    public String saveAppointment(@ModelAttribute("rdv") Appointment appt, Model model) {
        model.addAttribute("rdv", appointmentService.findAll());
        appointmentService.create(appt);
        return "redirect:/rdv/all";
    }
}
