package com.karinedias.repository;

import com.karinedias.model.User;
import org.springframework.data.repository.CrudRepository;

// To have access to CRUD operations
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String username);

    // Cherche un utilisateur grâce à son nom d'utilisateur ou son mail
    User findByEmailOrUsername(String username, String email);


}