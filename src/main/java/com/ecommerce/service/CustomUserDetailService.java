package com.ecommerce.service;

import com.ecommerce.config.CustomUser;
import com.ecommerce.config.SecurityConfig;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found " + user.getUsername());
        }
        else {
            return new CustomUser(user);
        }
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User createUser(User user){
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        User createdUser = userRepo.save(newUser);
        return createdUser;
    }

    public User updateUser(User updatedUser){
        String username = updatedUser.getUsername();
        User user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found " + updatedUser.getUsername());
        }
        user.setPassword(new BCryptPasswordEncoder().encode(updatedUser.getPassword()));
        return userRepo.save(user);
    }

    public void deleteUser(String username){
        User user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found " + username);
        }
        userRepo.delete(user);
    }
}
