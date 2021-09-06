package com.karinedias.security;

import com.karinedias.model.User;
import com.karinedias.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String usernameField) throws UsernameNotFoundException {

        User user = userRepo.findByEmailOrUsername(usernameField, usernameField);

        if (user == null) {
            throw new UsernameNotFoundException("No user with username " + usernameField + " was found.");
        } else {
            return new UserDetailsImpl(user);
        }
    }
}
