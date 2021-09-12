package com.karinedias.controller;

import com.karinedias.model.User;
import com.karinedias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
//    @Autowired
//    private final PasswordEncoder encoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // READ
    @Secured("ROLE_ADMIN")
    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/user/getUsers";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/all";
    }

    // Form to Update
    @GetMapping("/updateForm-user/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // Get list of users for template form
//        User user = userService.findById(id);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
//        model.addAttribute("role", user.getRoles());
//        model.addAttribute("password", user.getPassword());
//        model.addAttribute("name", user.getName());

        model.addAttribute("user", userService.findById(id));

        return "user/editUser";
    }


    @PostMapping(value = "/edit-user/{id}")
    public String updateUser(@PathVariable(name = "id") int id, HttpServletRequest request, Model model) {

        User user = userService.findById(id);

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("roles");
//        System.out.println("Password changé AVANT encodage = " + request.getParameter("password"));
//        String password = encoder.encode(request.getParameter("password"));
//        System.out.println("Password changé APRES encodage = " + password);
        String name = request.getParameter("name");
        userService.updateUser(id, username, email, role, user.getPassword(), name);

        return "redirect:/all";
    }


    @RequestMapping("/add-new-user")
    public String addNewPatient(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/createUser";
    }

    @PostMapping("/add-user")
    public String savePatient(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/all";
    }

}
