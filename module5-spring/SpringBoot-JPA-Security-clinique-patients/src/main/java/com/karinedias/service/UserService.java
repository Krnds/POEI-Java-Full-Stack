package com.karinedias.service;

import com.karinedias.model.User;
import com.karinedias.repository.UserRepository;
import com.karinedias.security.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    public User findById(int id) {
        return userRepo.findById(id).get();
    }

    public void addUser(User user) {
        userRepo.save(user);
    }


    public User updateUser(int id, String username, String email, String role, String password, String name) {
        User existingUser = userRepo.findById(id).get();
        existingUser.setName(name);
        existingUser.setUsername(username);
        existingUser.setEmail(email);
        existingUser.setRoles(role);
        //TODO: attention là dessus !
        existingUser.setPassword(encoder.encode(existingUser.getPassword()));
        return userRepo.save(existingUser);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }


}
