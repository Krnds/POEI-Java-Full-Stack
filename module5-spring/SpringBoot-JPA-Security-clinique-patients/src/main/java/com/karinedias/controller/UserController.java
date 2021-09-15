package com.karinedias.controller;

import com.karinedias.model.User;
import com.karinedias.security.ApplicationConfig;
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
@Secured("ROLE_ADMIN")
public class UserController {

    private final UserService userService;
    @Autowired
    private final PasswordEncoder encoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
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
        return "redirect:/users/all";
    }

    // Form to Update
    @GetMapping("/updateForm-user/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user/editUser";
    }


    @PostMapping(value = "/edit-user/{id}")
    public String updateUser(@PathVariable(name = "id") int id, HttpServletRequest request, Model model) {

        User user = userService.findById(id);

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("roles");
        String name = request.getParameter("name");
        userService.updateUser(id, username, email, role, user.getPassword(), name);

        return "redirect:/users/all";
    }


    @RequestMapping("/add-new-user")
    public String addNewPatient(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/createUser";
    }

    @PostMapping("/add-user")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        // Save encrypted password in database
        user.setPassword(encoder.encode(user.getPassword()));
        model.addAttribute("as_admin", false);
        userService.addUser(user);
        return "redirect:/users/all";
    }

}
