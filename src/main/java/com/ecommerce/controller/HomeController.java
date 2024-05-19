package com.ecommerce.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ecommerce.JWT.JwtAuthResponse;
import com.ecommerce.JWT.JwtTokenHelper;
import com.ecommerce.entity.JwtAuthRequest;
import com.ecommerce.entity.User;
import com.ecommerce.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping ("/api/SignUp")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = customUserDetailService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping ("/Home/AllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = customUserDetailService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @PutMapping("/Home/{userName}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userName){
        User updatedUser = customUserDetailService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/Home/{userName}")
    public ResponseEntity<User> deleteUser(@PathVariable String userName){
        customUserDetailService.deleteUser(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/Login")
    public ResponseEntity<JwtAuthResponse> Login(@RequestBody JwtAuthRequest request){
        this.authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = this.customUserDetailService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken(token);
        jwtAuthResponse.setUser((User) userDetails);
        return  new ResponseEntity<JwtAuthResponse>(jwtAuthResponse,HttpStatus.OK);
    }

    public void authenticate(String username, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
        }
        catch(DisabledException e){
            throw new DisabledException("User is disabled");
        }

        catch(BadCredentialsException e){
            throw new BadCredentialsException("Wrong credentials");
        }

        catch(Exception e){
            String message = e.getMessage();
            throw new RuntimeException(message);
        }

    }
}
