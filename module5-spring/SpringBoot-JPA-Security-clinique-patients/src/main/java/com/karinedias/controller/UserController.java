package com.karinedias.controller;

import com.karinedias.model.Patient;
import com.karinedias.model.User;
import com.karinedias.model.Ville;
import com.karinedias.repository.PatientRepository;
import com.karinedias.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    // READ
    @GetMapping("")
    public String getAllUsers(Model model) {

        List<User> users = (List<User>) userRepo.findAll();
        model.addAttribute("users", users);
        return "getUsers";
    }

}
